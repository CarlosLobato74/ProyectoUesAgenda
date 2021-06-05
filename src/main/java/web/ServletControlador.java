package web;

import datos.*;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dominio.Cliente;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    LoginDaoJDBC dao = new LoginDaoJDBC();
    Login l = new Login();
    int r;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Cliente prueba = new Cliente(1);
                List<Cliente> clientes = new ClienteDaoJDBC().listar();
                System.out.println("Clientes = " + clientes); 
                request.setAttribute("clientes", clientes);
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
//        String accion = request.getParameter("accion");
//        ClienteDaoJDBC oId = new ClienteDaoJDBC();
//        if (accion.equals("Ingresar")) {
//            String us = request.getParameter("userId");
//            String ps = request.getParameter("password");
//            l.setUser(us);
//            l.setPassword(ps);
//            
//            r = dao.validar(l);
//            if (r == 1) {
//                
//                Cliente prueba = new Cliente(1);
//                List<Cliente> clientes = new ClienteDaoJDBC().listar();
//                System.out.println("Clientes = " + clientes); 
//                request.setAttribute("clientes", clientes);
//                request.getRequestDispatcher("clientes.jsp").forward(request, response);
//                //int idcliente = Integer.parseInt(request.getParameter("ID_User"));
//               
//            }else if(r == 0){
//                 request.getRequestDispatcher("index.jsp").forward(request, response);
//            }
//
//        }
//
    }

}
