package java.domain.models;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int anio;
    private String genero;

    public Pelicula() {}

    public Pelicula(String titulo, String director, int anio, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.genero = genero;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public void mostrarDetalles() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Director: " + getDirector());
        System.out.println("Año: " + getAnio());
        System.out.println("Género: " + getGenero());
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                '}';
    }
}
