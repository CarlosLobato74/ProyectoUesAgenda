package datos;

import datos.Login;
import dominio.Cliente;
import dominio.validar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoJDBC implements validar {

    String SQL_LOGIN = "Select * from login WHERE  User=? and Password = MD5(?)";
    private static final String SQL_INSERTL = "INSERT INTO login(User,password,Firts_Name,Last_Name,Phone,Address) VALUES(?, MD5(?), ?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_USER = "SELECT * FROM login WHERE User = ?";
    
    //Recupera los valores del usuario para buscarlo en la base de datos
    @Override
    public int validar(Login log) {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        int r = 0;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(SQL_LOGIN);
            ps.setString(1, log.getUser());
            ps.setString(2, log.getPassword());
            rs = ps.executeQuery();

            while (rs.next()) {
                r++;
                log.setUserId(rs.getInt("ID_User"));
                log.setUser(rs.getString("User"));
                log.setPassword(rs.getString("Password"));
            }
            if (r > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            
            return 0;
        }
    }

    //Inserta un nuevo usuario despues del registro 
    public int insertar(Login login) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTL);
            stmt.setString(1, login.getUser());
            stmt.setString(2, login.getPassword());
            stmt.setString(3, login.getFirstN());
            stmt.setString(4, login.getLastN());
            stmt.setString(5, login.getPhone());
            stmt.setString(6, login.getAddress());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("---------------#Error al insertar el usuario al registro");
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //Hace la validacion para que revise que no existe otro usuario igual
    public int verSiExiste(Login log) {

        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        int r = 0;
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(SQL_SELECT_BY_USER);
            ps.setString(1, log.getUser());
            rs = ps.executeQuery();
            while (rs.next()) {
                r++;
            }
            if (r > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
