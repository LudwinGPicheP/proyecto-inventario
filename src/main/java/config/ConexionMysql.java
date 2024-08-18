package config;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author luna
 */
public class ConexionMysql {
    private static final String URL = "jdbc:mysql://autorack.proxy.rlwy.net:58499/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "vITTeYwrgmXEPWiszxVnVmOaEaVZeliB";
    private Connection conexionmysql = null;
    
    public ConexionMysql() {
        try {
            // Carga el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión
            conexionmysql = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
    
    // Método para obtener la conexión
    public Connection getConexion() {
        return conexionmysql;
       
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexionmysql != null && !conexionmysql.isClosed()) {
                conexionmysql.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
