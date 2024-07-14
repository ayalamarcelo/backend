package java.domain.models;

import java.domain.models.Pelicula;

public class Accion extends Pelicula {
    private boolean tieneEscenasDePelea;

    public Accion() {}

    public Accion(String titulo, String director, int anio, String genero, boolean tieneEscenasDePelea) {
        super(titulo, director, anio, genero);
        this.tieneEscenasDePelea = tieneEscenasDePelea;
    }

    public boolean isTieneEscenasDePelea() {
        return tieneEscenasDePelea;
    }

    public void setTieneEscenasDePelea(boolean tieneEscenasDePelea) {
        this.tieneEscenasDePelea = tieneEscenasDePelea;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Director: " + getDirector());
        System.out.println("Año: " + getAnio());
        System.out.println("Género: " + getGenero());
        System.out.println("Tiene escenas de pelea: " + (tieneEscenasDePelea ? "Sí" : "No"));
    }
}