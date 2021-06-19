package datos;

import dominio.Cliente;
import datos.LogsUsuario;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT  ID_User, ID_agenda, Descripcion, Fecha, Hora FROM agenda WHERE ID_User = ?";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_User, ID_agenda, Descripcion, Fecha, Hora FROM agenda WHERE ID_User = ? AND ID_Agenda = ?";

    private static final String SQL_INSERT = "INSERT INTO agenda(ID_User, Descripcion, Fecha, Hora) VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE agenda SET Descripcion=?, Fecha=?, Hora=? WHERE agenda.ID_Agenda=?";

    private static final String SQL_DELETE = "DELETE FROM agenda WHERE agenda.ID_Agenda = ?";

    private static final String SQL_SELECT_BY_USER = "SELECT * FROM login WHERE ID_User = ?";

    private static final String INSERT_ENTRADA = "INSERT INTO log (ID_User,Entradas,Salidas) VALUES (?,?,?)";

    private static final String SQL_SELECT_LOG = "SELECT Entradas, Salidas FROM log WHERE ID_User = ?";

    Login l = new Login();

    private int us = l.getUserId();

    //Crea una lista de las agenda del usuario
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
            System.out.println("---------------#Error al crear la lista de usuarios");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return clientes;
    }

    //Crea una lista de la informacion del usuario
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

                log = new Login(id_User, User, pass, fName, lasName, phone, address);
                userInfo.add(log);

            }
        } catch (SQLException ex) {
            System.out.println("---------------#Error en listar la informacion del usuario");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return userInfo;
    }

    //Encuentra una lista especifica para modificarla
    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, this.us);
            stmt.setInt(2, cliente.getIdAgenda());
            rs = stmt.executeQuery();
            while (rs.next()) {

                String descripcion = rs.getString("Descripcion");
                String fecha = rs.getString("Fecha");
                String hora = rs.getString("Hora");

                cliente.setDescripcion(descripcion);
                cliente.setFecha(fecha);
                cliente.setHora(hora);
            }

        } catch (SQLException ex) {
            System.out.println("---------------#Error al buscar por id");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    //Inserta los datos de una agenda
    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, this.us);
            stmt.setString(2, cliente.getDescripcion());
            stmt.setString(3, cliente.getFecha());
            stmt.setString(4, cliente.getHora());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("---------------#Error al Insertar datos en una agenda");
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //Actualiza los datos de la agenda
    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getDescripcion());
            stmt.setString(2, cliente.getFecha());
            stmt.setString(3, cliente.getHora());

            stmt.setInt(4, cliente.getIdAgenda());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("---------------#Error al actualizar datos de la agenda");
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //Elimina un evento agregado en la agenda
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
            System.out.println("---------------#Error al eliminar un evento de la agenda");
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //Agrega a la informacion de la entrada y salida del usuario
    public int insertarArchivo(LogsUsuario logsU) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT_ENTRADA);
            stmt.setInt(1, this.us);
            stmt.setString(2, logsU.getEntradas());
            stmt.setString(3, logsU.getSalidas());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("---------------#Error al agregar entrada y salida en el Log");
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //Crea una lista de las entradas y salidas del usuario
    public List<LogsUsuario> listarLog() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LogsUsuario logusuario = null;
        List<LogsUsuario> logsUs = new ArrayList<>();

        try {

            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT_LOG);
            stmt.setInt(1, this.us);
            rs = stmt.executeQuery();
            /*Genera una lista con los datos que encuentra por la sentencia del sql*/
            while (rs.next()) {

                String entrada = rs.getString("Entradas");
                String salida = rs.getString("Salidas");

                logusuario = new LogsUsuario(entrada, salida);

                logsUs.add(logusuario);

            }
        } catch (SQLException ex) {
            System.out.println("---------------#Error al crear la lista entrada y salida del usuario");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return logsUs;
    }

}
