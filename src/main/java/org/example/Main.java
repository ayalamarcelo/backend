package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    package org.example;

import java.util.List;
import java.util.Scanner;

    public class Main {
        private static final Scanner scanner = new Scanner(System.in);
        private static final PeliculaDAO peliculaDAO = new PeliculaDAO();

        public static void main(String[] args) {
            mostrarMenu();
        }

        private static void mostrarMenu() {
            int opcion;
            do {
                System.out.println("Bienvenido al sistema de gestión de películas");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Crear nueva película");
                System.out.println("2. Mostrar todas las películas");
                System.out.println("3. Actualizar película");
                System.out.println("4. Borrar película");
                System.out.println("5. Salir");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después del número

                switch (opcion) {
                    case 1:
                        crearPelicula();
                        break;
                    case 2:
                        mostrarPeliculas();
                        break;
                    case 3:
                        actualizarPelicula();
                        break;
                    case 4:
                        borrarPelicula();
                        break;
                    case 5:
                        System.out.println("Gracias por usar el sistema.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                }
            } while (opcion != 5);

            scanner.close();
        }

        private static void crearPelicula() {
            System.out.println("Ingrese los detalles de la nueva película:");

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Director: ");
            String director = scanner.nextLine();

            System.out.print("Año: ");
            int ano = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            System.out.print("Género: ");
            String genero = scanner.nextLine();

            Pelicula nuevaPelicula = new Pelicula(0, titulo, director, ano, genero);
            peliculaDAO.crearPelicula(nuevaPelicula);
            System.out.println("Película creada exitosamente.");
        }

        private static void mostrarPeliculas() {
            List<Pelicula> peliculas = peliculaDAO.leerPeliculas();
            System.out.println("Listado de películas:");
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }
        }

        private static void actualizarPelicula() {
            System.out.print("Ingrese el ID de la película a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            System.out.println("Ingrese los nuevos detalles de la película:");

            System.out.print("Nuevo título: ");
            String titulo = scanner.nextLine();

            System.out.print("Nuevo director: ");
            String director = scanner.nextLine();

            System.out.print("Nuevo año: ");
            int ano = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            System.out.print("Nuevo género: ");
            String genero = scanner.nextLine();

            Pelicula peliculaActualizada = new Pelicula(id, titulo, director, ano, genero);
            peliculaDAO.actualizarPelicula(peliculaActualizada);
            System.out.println("Película actualizada exitosamente.");
        }

        private static void borrarPelicula() {
            System.out.print("Ingrese el ID de la película a borrar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            peliculaDAO.borrarPelicula(id);
            System.out.println("Película eliminada exitosamente.");
        }
    }

}
}