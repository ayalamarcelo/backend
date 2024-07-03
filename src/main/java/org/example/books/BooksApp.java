package org.example.books;

public class BooksApp {
    package com.example.peliculas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Scanner;

    public class PeliculasApp {

        public static void main(String[] args) {
            PeliculaDAO peliculaDAO = new PeliculaDAO();
            Scanner scanner = new Scanner(System.in);
            ObjectMapper mapper = new ObjectMapper();

            while (true) {
                System.out.println("Selecciona una opción:");
                System.out.println("1. Crear película");
                System.out.println("2. Leer películas");
                System.out.println("3. Actualizar película");
                System.out.println("4. Borrar película");
                System.out.println("5. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        System.out.println("Ingresa el JSON de la nueva película:");
                        String jsonNuevaPelicula = scanner.nextLine();
                        try {
                            Pelicula nuevaPelicula = mapper.readValue(jsonNuevaPelicula, Pelicula.class);
                            peliculaDAO.crearPelicula(nuevaPelicula);
                            System.out.println("Película creada exitosamente.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        List<Pelicula> peliculas = peliculaDAO.leerPeliculas();
                        try {
                            String jsonPeliculas = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(peliculas);
                            System.out.println(jsonPeliculas);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.println("Ingresa el JSON de la película actualizada:");
                        String jsonPeliculaActualizada = scanner.nextLine();
                        try {
                            Pelicula peliculaActualizada = mapper.readValue(jsonPeliculaActualizada, Pelicula.class);
                            peliculaDAO.actualizarPelicula(peliculaActualizada);
                            System.out.println("Película actualizada exitosamente.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4:
                        System.out.println("Ingresa el ID de la película a borrar:");
                        int idBorrar = scanner.nextInt();
                        peliculaDAO.borrarPelicula(idBorrar);
                        System.out.println("Película borrada exitosamente.");
                        break;

                    case 5:
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción inválida. Intenta nuevamente.");
                }
            }
        }
    }

}
