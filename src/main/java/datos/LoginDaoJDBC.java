package datos;

import datos.Login;
import dominio.Cliente;
import dominio.validar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoJDBC implements validar {

    
    String sql = "Select * from login WHERE  User=? and Password =?";

    @Override
    public int validar(Login log) {

        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        int r = 0;
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, log.getUser());
            ps.setString(2, log.getPassword());
            rs = ps.executeQuery();

            while (rs.next()) {
                r++;
                log.setUserId(rs.getInt("ID_User"));
                log.setUser(rs.getString("User"));
                log.setPassword(rs.getString("Password"));
                System.out.println("este es el usuario: "+ log.getUserId());
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
