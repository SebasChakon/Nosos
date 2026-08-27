package Modelo;

import conf.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public void registrar(Estudiante e) throws SQLException {
        String sql = "INSERT INTO estudiantes "
                + "(nombre, nota1, nota2, nota3, nota4, promedio, estado, resultado_cualitativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setDouble(2, e.getNota1());
            ps.setDouble(3, e.getNota2());
            ps.setDouble(4, e.getNota3());
            ps.setDouble(5, e.getNota4());
            ps.setDouble(6, e.getPromedio());
            ps.setString(7, e.getEstado());
            ps.setString(8, e.getResultadoCualitativo());

            ps.executeUpdate();
        }
    }

    public List<Estudiante> listarTodos() throws SQLException {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes ORDER BY id DESC";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearFila(rs));
            }
        }
        return lista;
    }

    public Estudiante buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearFila(rs);
                }
            }
        }
        return null;
    }

    public void actualizar(Estudiante e) throws SQLException {
        String sql = "UPDATE estudiantes SET "
                + "nombre = ?, nota1 = ?, nota2 = ?, nota3 = ?, nota4 = ?, "
                + "promedio = ?, estado = ?, resultado_cualitativo = ? "
                + "WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setDouble(2, e.getNota1());
            ps.setDouble(3, e.getNota2());
            ps.setDouble(4, e.getNota3());
            ps.setDouble(5, e.getNota4());
            ps.setDouble(6, e.getPromedio());
            ps.setString(7, e.getEstado());
            ps.setString(8, e.getResultadoCualitativo());
            ps.setInt(9, e.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM estudiantes WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Estudiante mapearFila(ResultSet rs) throws SQLException {
        Estudiante e = new Estudiante();
        e.setId(rs.getInt("id"));
        e.setNombre(rs.getString("nombre"));
        e.setNota1(rs.getDouble("nota1"));
        e.setNota2(rs.getDouble("nota2"));
        e.setNota3(rs.getDouble("nota3"));
        e.setNota4(rs.getDouble("nota4"));
        e.setPromedio(rs.getDouble("promedio"));
        e.setEstado(rs.getString("estado"));
        e.setResultadoCualitativo(rs.getString("resultado_cualitativo"));
        return e;
    }
}