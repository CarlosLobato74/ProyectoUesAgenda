package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dominio.Cliente;


@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Cliente prueba = new Cliente(1);
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes = " + clientes);
        
      request.setAttribute("clientes", clientes);
      request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
    }
    
   
}
