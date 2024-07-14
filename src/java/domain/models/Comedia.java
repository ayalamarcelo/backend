package java.domain.models;

public class Comedia extends Pelicula {
    private boolean esFamiliar;

    public Comedia() {}

    public Comedia(String titulo, String director, int anio, String genero, boolean esFamiliar) {
        super(titulo, director, anio, genero);
        this.esFamiliar = esFamiliar;
    }

    public boolean isEsFamiliar() {
        return esFamiliar;
    }

    public void setEsFamiliar(boolean esFamiliar) {
        this.esFamiliar = esFamiliar;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Director: " + getDirector());
        System.out.println("Año: " + getAnio());
        System.out.println("Género: " + getGenero());
        System.out.println("Es familiar: " + (esFamiliar ? "Sí" : "No"));
    }
}