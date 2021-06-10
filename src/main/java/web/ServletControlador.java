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

        if (accion != null) {
            switch (accion) {
                case "Ingresar": {
                    this.iniciarSesion(request, response);
                }
                break;
                case "registrar": {
                    this.registrarse(request, response);

                    break;
                }
                case "agregarEvento": {
                    this.agregarEvento(request, response);
                    break;
                }
                default: {

                    response.sendRedirect("index.jsp");
                }

            }
        } else {

            response.sendRedirect("index.jsp");
        }

    }

    /*METODOS DE USUARIO*/

 /*Accion default Para respuesta del JSP*/
    public void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Info de la agenda*/
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        request.setAttribute("clientes", clientes);
        /*info del usuario*/
        List<Login> userInfo = new ClienteDaoJDBC().listarUsuario();
        request.setAttribute("logins", userInfo);

        request.getRequestDispatcher("WEB-INF/paginas/cliente/clientes.jsp").forward(request, response);

    }

    /*Iniciar Sesion*/
    public void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Pasa parametros ingresados a atributos y los manda a validad*/
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

    /*Hace el registro hacia la base de datos de sesion*/
    public void registrarse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Recuperar valores del formulario*/
        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String contra = request.getParameter("contrasenia");
        String apellido = request.getParameter("contrasenia");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        l.setUser(usuario);
        r = dao.verSiExiste(l);
        if (r > 0) {
            /*AQUI SE MANDARA EL MENSAJE DE NO DISPONIBLE*/
            System.out.println("NO SE AGREGARA");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (r == 0) {
            System.out.println("CREO QUE LO VOY A REGISTRAR ");
            Login registrarse = new Login(usuario, contra, nombre, apellido, telefono, direccion);
            /*Insertamos en la base de datos*/
            int registrandose = new LoginDaoJDBC().insertar(registrarse);
            System.out.println("registros ingresados: " + registrandose);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }

    }

    /*Editandar Usuario*/
    public void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /*Eliminar Usuario*/
    public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /*METODOS DE EVENTOS*/
 /*Agregar nueva evento*/
    public void agregarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        Cliente cliente = new Cliente(descripcion, fecha, hora);
        int agregando = new ClienteDaoJDBC().insertar(cliente);
        this.accionDefault(request, response);
        
    }
 /*Editar evento*/
 /*Eliminar evento*/
 /*METODO DEL LOG*/
 /*Insertar*/
 /*Limpiar*/
}
