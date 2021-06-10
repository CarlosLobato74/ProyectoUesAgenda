package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT  ID_User, ID_agenda, Descripcion, Fecha, Hora FROM agenda WHERE ID_User = ?";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_User, ID_agenda, Descripcion, Fecha, Hora"
            + "FROM agenda WHERE ID_Agenda = ?";

    private static final String SQL_INSERT = "INSERT INTO agenda(ID_User, Descripcion, Fecha, Hora) VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE agenda"
            + " SET Descripcion=?, Fecha=?, Hora=? WHERE ID_Agenda=?";

    private static final String SQL_DELETE = "DELETE FROM agenda WHERE ID_Agenda = ?";

    private static final String SQL_SELECT_BY_USER ="SELECT * FROM login WHERE ID_User = ?";
   

    Login l = new Login();
    
    private int us = l.getUserId();
    


    /*Crea una lista con nuestros agendas creadas*/

    
    public List<Cliente> listar() {
              
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;        
        List<Cliente> clientes = new ArrayList<>();
        
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, this.us);
            rs = stmt.executeQuery();
            /*Genera una lista con los datos que encuentra por la sentencia del sql*/
            while (rs.next()) {
                int idUser = rs.getInt("ID_User");
                int idAgenda = rs.getInt("ID_Agenda");
                String descripcion = rs.getString("Descripcion");
                String fecha = rs.getString("Fecha");
                String hora = rs.getString("Hora");

                cliente = new Cliente(idUser, idAgenda, descripcion, fecha, hora);

                clientes.add(cliente);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return clientes;
    }
    

    /*Info  de Usuario*/
 public List<Login> listarUsuario() {
              
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Login log = null;        
        List<Login> userInfo = new ArrayList<>();
        
        try {
           
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_USER);
            stmt.setInt(1, this.us);
            rs = stmt.executeQuery();
            /*Genera una lista con los datos que encuentra por la sentencia del sql*/
            while (rs.next()) {
                
                int id_User = rs.getInt("ID_User");
                String User = rs.getString("User");
                String pass = rs.getString("Password");
                String fName = rs.getString("Firts_Name");
                String lasName = rs.getString("Last_Name");
                String phone = rs.getString("Phone");
                String address = rs.getString("Address");
                
                log = new Login(id_User, User, pass,fName,lasName,phone,address);
                userInfo.add(log);
                
            }
        } catch (SQLException ex) {
            System.out.println("ERRORRRRR PRIMER EXCEPCIOONNNNNNNNNNNNNNNNNNNNN");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
            
        }
        return userInfo;
    }
/*buscar por id*/
    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdAgenda());
            rs = stmt.executeQuery();
            rs.absolute(1);

            String descripcion = rs.getString("Descripcion");
            String fecha = rs.getString("Fecha");
            String hora = rs.getString("Hora");

            cliente.setDescripcion(descripcion);
            cliente.setFecha(fecha);
            cliente.getHora();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    /*INSERTAR */
    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,this.us);
            stmt.setString(2, cliente.getDescripcion());
            stmt.setString(3, cliente.getFecha());
            stmt.setString(4, cliente.getHora());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /*ACTUALIZAR*/
    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(0, cliente.getDescripcion());
            stmt.setString(1, cliente.getFecha());
            stmt.setString(2, cliente.getHora());
            stmt.setInt(3, cliente.getIdAgenda());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /*ELIMINAR*/

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdAgenda());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
