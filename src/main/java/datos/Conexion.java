package datos;


import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/ues_base?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "UesOcc";
    private static BasicDataSource dataSource;
    
    
    /*Recupera una conexion a la base de datos*/
    public static DataSource getDataSource(){
       if (dataSource == null){
            dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASSWORD);
        dataSource.setInitialSize(50);
       }
        return dataSource;
    }
    /*Obtiene la conexion a la base de datos dependiendo del pool de conexion*/
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    /*Cierra el ResultSet*/
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    /*Cierra el PreparedStatement*/
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    /*Cierra el objeto de conexion*/
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
