package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT  ID_User, ID_agenda, Descripcion, Fecha, Hora FROM agenda WHERE ID_User = ?";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_User, ID_agenda, Descripcion, Fecha, Hora"
            + "FROM agenda WHERE ID_Agenda = ?";

    private static final String SQL_INSERT = "INSERT INTO agenda(Descripcion,Fecha,Hora)"
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE agenda"
            + " SET Descripcion=?, Fecha=?, Hora=? WHERE ID_Agenda=?";

    private static final String SQL_DELETE = "DELETE FROM agenda WHERE ID_Agenda = ?";

    Login idNew = new Login();

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(0, 1);
            rs = stmt.executeQuery();
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
