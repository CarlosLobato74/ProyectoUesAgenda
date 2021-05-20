package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT BookID, Title" + " FROM books";

    private static final String SQL_SELECT_BY_ID = "SELECT BookID, Title" + " FROM books WHERE  BookID = ?";

    private static final String SQL_INSERT = "INSERT INTO books(Title)" + " VALUES(?)";

    private static final String SQL_UPDATE = "UPDATE books" + "SET Title=? WHERE BookId=?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE bookId = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = ConexionDb.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int bookId = rs.getInt("BookId");
                String title = rs.getString("Title");
                cliente  = new Cliente (bookId,title);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionDb.close(rs);
            ConexionDb.close(stmt);
            ConexionDb.close(conn);
        }
        return clientes;    
    }
    
    
//    public Cliente encontrar(Cliente cliente){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Cliente Cliente = null;
//        List<Cliente> clientes = new ArrayList<>();
//        try {
//            conn = ConexionDb.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while(rs.next()){
//                int bookId = rs.getInt("BookId");
//                String title = rs.getString("Title");
//                cliente  = new Cliente (bookId,title);
//                clientes.add(cliente);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
//        finally{
//            ConexionDb.close(rs);
//            ConexionDb.close(stmt);
//            ConexionDb.close(conn);
//        }
//    }
}
