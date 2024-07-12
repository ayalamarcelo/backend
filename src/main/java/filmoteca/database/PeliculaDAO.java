package filmoteca.database;

import filmoteca.domain.models.Pelicula;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public void crearPelicula(Pelicula pelicula) {
        var query = "INSERT INTO peliculas (titulo, director, anio, genero) VALUES (?, ?, ?, ?)";
        try (var con = DatabaseConnection.getConnection(); var pst = con.prepareStatement(query)) {
            pst.setString(1, pelicula.getTitulo());
            pst.setString(2, pelicula.getDirector());
            pst.setInt(3, pelicula.getAnio());
            pst.setString(4, pelicula.getGenero());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pelicula leerPelicula(int id) {
        String query = "SELECT * FROM peliculas WHERE id = ?";
        try (var con = DatabaseConnection.getConnection(); var pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            var rs = pst.executeQuery();
            if (rs.next()) {
                var pelicula = new Pelicula(
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anio"),
                        rs.getString("genero")
                );
                pelicula.setId(rs.getInt("id"));
                return pelicula;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pelicula> leerTodasLasPeliculas() {
        var query = "SELECT * FROM peliculas";
        var peliculas = new ArrayList<Pelicula>();
        try (var con = DatabaseConnection.getConnection(); var st = con.createStatement();
             var rs = st.executeQuery(query)) {
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anio"),
                        rs.getString("genero")
                );
                pelicula.setId(rs.getInt("id"));
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public void actualizarPelicula(Pelicula pelicula) {
        var query = "UPDATE peliculas SET titulo = ?, director = ?, anio = ?, genero = ? WHERE" +
            " id = ?";
        try (var con = DatabaseConnection.getConnection(); var pst = con.prepareStatement(query)) {
            pst.setString(1, pelicula.getTitulo());
            pst.setString(2, pelicula.getDirector());
            pst.setInt(3, pelicula.getAnio());
            pst.setString(4, pelicula.getGenero());
            pst.setInt(5, pelicula.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPelicula(int id) {
        var query = "DELETE FROM peliculas WHERE id = ?";
        try (var con = DatabaseConnection.getConnection(); var pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
