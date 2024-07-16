package java.infrastructure.repository.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.domain.models.Pelicula;
import java.infrastructure.repository.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pelicula")
public class PeliculaServlet extends HttpServlet {
    private PeliculaController peliculaController;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        Connection conexion = null;
        try {
            conexion = DatabaseConnection.getInitialConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.peliculaController = new PeliculaController(conexion);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Pelicula pelicula = null;
            try {
                pelicula = peliculaController.obtenerPelicula(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("pelicula", pelicula);
            req.getRequestDispatcher("/pelicula.jsp").forward(req, resp);
        } else {
            List<Pelicula> peliculas = null;
            try {
                peliculas = peliculaController.obtenerTodasLasPeliculas();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("peliculas", peliculas);
            req.getRequestDispatcher("/peliculas.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pelicula nuevaPelicula = objectMapper.readValue(req.getReader(), Pelicula.class);
        try {
            peliculaController.crearPelicula(nuevaPelicula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("pelicula");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pelicula pelicula = objectMapper.readValue(req.getReader(), Pelicula.class);
        try {
            peliculaController.actualizarPelicula(pelicula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("pelicula");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pelicula pelicula = objectMapper.readValue(req.getReader(), Pelicula.class);
        try {
            peliculaController.eliminarPelicula(pelicula.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("pelicula");
    }
}

