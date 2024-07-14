package java.domain.models;

public class Drama extends Pelicula {
    private boolean basadoEnHechosReales;

    public Drama() {}

    public Drama(String titulo, String director, int anio, String genero, boolean basadoEnHechosReales) {
        super(titulo, director, anio, genero);
        this.basadoEnHechosReales = basadoEnHechosReales;
    }

    public boolean isBasadoEnHechosReales() {
        return basadoEnHechosReales;
    }

    public void setBasadoEnHechosReales(boolean basadoEnHechosReales) {
        this.basadoEnHechosReales = basadoEnHechosReales;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Director: " + getDirector());
        System.out.println("Año: " + getAnio());
        System.out.println("Género: " + getGenero());
        System.out.println("Basado en hechos reales: " + (basadoEnHechosReales ? "Sí" : "No"));
    }
}