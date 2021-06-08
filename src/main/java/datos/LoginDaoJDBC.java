package datos;

import datos.Login;
import dominio.validar;
import java.sql.*;

public class LoginDaoJDBC implements validar {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    @Override
    public int validar(Login log) {

        String sql = "Select * from login WHERE  User=? and Password =?";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, log.getUser());
            ps.setString(2, log.getPassword());
            rs = ps.executeQuery();


           
            
            while (rs.next()) {
                r++;

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

}
