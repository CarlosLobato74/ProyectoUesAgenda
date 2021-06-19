package web;

import datos.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dominio.Cliente;
import javax.servlet.RequestDispatcher;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    LoginDaoJDBC dao = new LoginDaoJDBC();
    Login l = new Login();
    String fechaEntrada;
    String fechaSalida;
    int r;
    LogsUsuario archivo = new LogsUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editarAgenda": {
                    this.editarEvento(request, response);
                    break;
                }
                case "eliminarEvento": {
                    
                    this.eliminarEvento(request, response);
                    break;
                }
                case "cerrarSesion": {
                   
                    Date salida = new Date();
                    String salidas = salida.toString() + "";
                    this.fechaSalida = salidas;
                    this.capturarEntrada();
                    HttpSession sesion = request.getSession();
                    sesion.invalidate();
                }
                default: {

                    response.sendRedirect("index.jsp");
                }

            }
        } else {

            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "Ingresar": {
                    this.iniciarSesion(request, response);
                    break;
                }
                case "registrar": {
                    this.registrarse(request, response);
                    break;
                }
                case "agregarEvento": {
                    this.agregarEvento(request, response);
                    break;
                }
                case "modificarEvento": {
                    this.actualizarEvento(request, response);
                    break;
                }

                default: {

                    response.sendRedirect("index.jsp");

                }

            }
        } else {

            this.accionDefault(request, response);
        }

    }

    //METODOS DE USUARIO

    /*Accion default Para respuesta del JSP*/
    public void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();

        Date entrada = new Date();

        String fecha = entrada.toString() + "";
        this.fechaEntrada = fecha;

        /*Info de la agenda*/
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        sesion.setAttribute("clientes", clientes);
        /*info del usuario*/
        List<Login> userInfo = new ClienteDaoJDBC().listarUsuario();
        sesion.setAttribute("logins", userInfo);
        /*info de entradas y salidas del usuario*/
        List<LogsUsuario> logsInfo = new ClienteDaoJDBC().listarLog();
        sesion.setAttribute("logs", logsInfo);

        response.sendRedirect("clientes.jsp");

        /*request.getRequestDispatcher("WEB-INF/paginas/cliente/clientes.jsp").forward(request, response);*/
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
            String noSeEncontro = "No se encontro el usuario";
            request.setAttribute("noSeEncontro", noSeEncontro);

            //response.sendRedirect("index.jsp");
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
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        l.setUser(usuario);
        r = dao.verSiExiste(l);
        if (r > 0) {
            /*AQUI SE MANDARA EL MENSAJE DE NO DISPONIBLE*/

            String nodisponible = "El usuario no esta disponible";
            request.setAttribute("nodisponible", nodisponible);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (r == 0) {

            Login registrarse = new Login(usuario, contra, nombre, apellido, telefono, direccion);
            String registrado = "Se a registrado el usuario con exito";
            request.setAttribute("registrado", registrado);
            /*Insertamos en la base de datos*/
            int registrandose = new LoginDaoJDBC().insertar(registrarse);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }

    //METODOS DE EVENTOS
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
    public void editarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idAgenda = Integer.parseInt(request.getParameter("idAgenda"));

        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idAgenda));

        request.setAttribute("cliente", cliente);

        String jspEditarAgenda = "/WEB-INF/paginas/cliente/actualizarAgenda.jsp";
        request.getRequestDispatcher(jspEditarAgenda).forward(request, response);

    }

    /*Actualizar Evento*/
    public void actualizarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idAgenda = Integer.parseInt(request.getParameter("idAgenda"));
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        Cliente cliente = new Cliente(idAgenda, descripcion, fecha, hora);
        int agregando = new ClienteDaoJDBC().actualizar(cliente);
        this.accionDefault(request, response);

    }

    /*Eliminar evento*/
    public void eliminarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idAgenda = Integer.parseInt(request.getParameter("idAgenda"));
        Cliente cliente = new Cliente(idAgenda);
        int agregando = new ClienteDaoJDBC().eliminar(cliente);
        this.accionDefault(request, response);

    }

    /*METODO DEL LOG*/
 /*Insertar Registro al log*/
    public void capturarEntrada() {

        LogsUsuario cap = new LogsUsuario(fechaEntrada, fechaSalida);
        int agregando = new ClienteDaoJDBC().insertarArchivo(cap);

    }

}
