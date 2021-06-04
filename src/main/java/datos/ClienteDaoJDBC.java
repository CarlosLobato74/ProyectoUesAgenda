package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT , ID_User, id_agenda, descripcion, fecha, hora"
            + "FROM agenda";

    private static final String SQL_SELECT_BY_ID = "SELECT , ID_User, id_agenda, descripcion, fecha, hora"
            + "FROM agenda WHERE id_agenda = ?";

    private static final String SQL_INSERT = "INSERT INTO agenda(descripcion,fecha,hora)"
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE agenda"
            + " SET descripcion=?, fecha=?, hora=? WHERE id_agenda=?";

    private static final String SQL_DELETE = "DELETE FROM agenda WHERE id_agenda = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id_agenda");
                int idAgenda = rs.getInt("id_agenda");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");

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

            String descripcion = rs.getString("descripcion");
            String fecha = rs.getString("fecha");
            String hora = rs.getString("hora");

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

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(0, cliente.getDescripcion());
            stmt.setString(1, cliente.getFecha());
            stmt.setString(2, cliente.getHora());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

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
    
    public int eliminar(Cliente cliente){
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
