package java.infrastructure.repository.controllers;

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

    @Override
    public void init() throws ServletException {
        Connection conexion = null;
        try {
            conexion = DatabaseConnection.getInitialConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.peliculaController = new PeliculaController(conexion);
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
        String titulo = req.getParameter("titulo");
        String director = req.getParameter("director");
        int anio = Integer.parseInt(req.getParameter("anio"));
        String genero = req.getParameter("genero");

        Pelicula nuevaPelicula = new Pelicula(titulo, director, anio, genero);
        try {
            peliculaController.crearPelicula(nuevaPelicula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("pelicula");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String director = req.getParameter("director");
        int anio = Integer.parseInt(req.getParameter("anio"));
        String genero = req.getParameter("genero");

        Pelicula pelicula = new Pelicula(titulo, director, anio, genero);
        pelicula.setId(id);
        try {
            peliculaController.actualizarPelicula(pelicula);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("pelicula");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            peliculaController.eliminarPelicula(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("pelicula");
    }
}
