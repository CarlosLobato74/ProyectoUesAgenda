package web;

import datos.*;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        
        /*Pasa parametros ingresados a atributos y los manda a validad*/
        if (accion.equals("Ingresar")) {
            String us = request.getParameter("userId");
            String ps = request.getParameter("password");
            l.setUser(us);
            l.setPassword(ps);

            r = dao.validar(l);
            /*Compureba el resultado de la validacion si encontro al usuario sera mayor a 0*/
            if (r >= 1) {

                this.accionDefault(request, response);

            } else if (r == 0) {

                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        }

    }

    /*accion default Para respuesta del JSP*/
    public void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Info de la agenda*/
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        request.setAttribute("clientes", clientes);
        /*info del usuario*/
        List<Login> userInfo = new ClienteDaoJDBC().listarUsuario();
        request.setAttribute("logins", userInfo);
        System.out.println("usuario = " + userInfo);

        request.getRequestDispatcher("WEB-INF/paginas/cliente/clientes.jsp").forward(request, response);

    }

}
