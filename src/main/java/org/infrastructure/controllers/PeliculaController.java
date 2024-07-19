package org.infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.services.PeliculaService;
import org.domain.models.Pelicula;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/peliculas")
public class PeliculaController extends HttpServlet {

    private final ObjectMapper mapper;
    private final PeliculaService service;

    public PeliculaController() {
        this.mapper = new ObjectMapper();
        this.service = new PeliculaService();
    }

    // CORSFilter
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // configureCorsHeaders(resp);
    }

    private void configureCorsHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "#");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, PUT");
        resp.setHeader("Access-Control-Allow-Header", "content-type");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Pelicula pelicula = mapper.readValue(req.getInputStream(), Pelicula.class);
        service.savePelicula(pelicula);
        resp.setStatus(200);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // configureCorsHeaders(resp);
        String titulo = req.getParameter("titulo");
        if(titulo != null) {
            Pelicula pelicula = service.findByTitulo(titulo);
            if(pelicula != null) {
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(mapper.writeValueAsString(pelicula));

            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.setContentType("text/plain");
                resp.getWriter().write("Pelicula no encontrada...");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idString = req.getParameter("id");

        if (idString != null && !idString.isEmpty()) {
            int id = Integer.parseInt(idString);
            service.deletePelicula(id);
            resp.setStatus(200);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("ID inválido");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idString = req.getParameter("id");
        String titulo = req.getParameter("titulo");
        String director = req.getParameter("director");
        String genero = req.getParameter("genero");

        if (idString != null && !idString.isEmpty() &&
                titulo != null && !titulo.isEmpty() &&
                director != null && !director.isEmpty() &&
                genero != null && !genero.isEmpty()) {

            int id = Integer.parseInt(idString);
            Pelicula pelicula = new Pelicula(id, titulo, director, genero);

            boolean updated = service.updatePelicula(pelicula);

            if (updated) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Datos actualizados...");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Datos no actualizados...");
            }
        }
    }
}

