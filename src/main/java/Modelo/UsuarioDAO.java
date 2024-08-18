package Modelo;

import config.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    ConexionMysql con = new ConexionMysql();
    Connection connection;

    public Usuario validarUsuario(String nombreUsuario, String contrasenia) {
        Usuario usuario = null;
        
        
        String sql = "SELECT * FROM tb_usuario WHERE nombre_usuario = ? AND contrasenia = ?";
        try {
            connection = con.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getString("id_user"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRolUsuario(rs.getString("rol_usuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.cerrarConexion();
        }
        return usuario;
    }
}
