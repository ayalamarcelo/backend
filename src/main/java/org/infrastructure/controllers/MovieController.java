package org.infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.services.MovieService;
import org.domain.models.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/movies")
public class MovieController extends HttpServlet {

    private final ObjectMapper mapper;
    private final MovieService service;

    public MovieController() {
        this.mapper = new ObjectMapper();
        this.service = new MovieService();
    }

    // CORSFilter
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // configureCorsHeaders(resp);
    }

    /*
     Note: This method will be improved later when the front-end is integrated
     with the back-end.
    */

    private void configureCorsHeaders(HttpServletResponse resp) {
        // TODO: Improve CORS configuration when integrating the front-end with the back-end.
        resp.setHeader("Access-Control-Allow-Origin", "#");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, PUT");
        resp.setHeader("Access-Control-Allow-Header", "content-type");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Movie movie = mapper.readValue(req.getInputStream(), Movie.class);
        service.saveMovie(movie);
        resp.setStatus(200);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // configureCorsHeaders(resp);
        String title = req.getParameter("title");
        if(title != null) {
            Movie movie = service.findByTitle(title);
            if(movie != null) {
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(mapper.writeValueAsString(movie));

            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.setContentType("text/plain");
                resp.getWriter().write("Movie not found...");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idString = req.getParameter("id");

        if (idString != null && !idString.isEmpty()) {
            int id = Integer.parseInt(idString);
            service.deleteMovie(id);
            resp.setStatus(200);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid ID");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        try {
          // Read the request body and convert it to a Movie object
          Movie movie = mapper.readValue(req.getInputStream(), Movie.class);

          // Validate the fields of the Movie object
          if (movie.getId() != 0 &&  movie.getTitle() != null && !movie.getTitle().isEmpty() &&
             movie.getDirector() != null && !movie.getDirector().isEmpty() &&
             movie.getGenre() != null && !movie.getGenre().isEmpty()) {

              // Attempt to update the movie record
             boolean updated = service.updateMovie(movie);

             // Set the response status and message based on the update result
                if (updated) {
                   resp.setStatus(HttpServletResponse.SC_OK);
                 resp.getWriter().write("Updated data!");
                } else {
                     resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   resp.getWriter().write("Data not updated...");
               }
            } else {
              resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
             resp.getWriter().write("Invalid input data...");
           }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error processing request: " + e.getMessage());
        }
    }
}

