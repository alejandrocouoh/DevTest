/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Configuracion;

import Controlador.RolUsercontroller;
import Controlador.Usercontroller;
import Modelo.Acconts;
import Modelo.RolUser;
import Modelo.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositorios.IRolUser;
import repositorios.IUser;

/**
 *
 * @author Towhi
 */
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class SessionServlet extends HttpServlet {

    private HttpSession sesion;
    private Acconts cuenta;
    private IUser users;
    private User usuario;
    private IRolUser interface_rol_usuario;
    private RolUser rol_usuario;
    private String menu;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        sesion = request.getSession(); //Se obtiene la sesion
        cuenta = (Acconts) sesion.getAttribute("cuenta");//se recibe la cuenta como parametro
        
        users = new Usercontroller();//Apertura de BD para buscar un usuario
        usuario = users.findbyId(cuenta.getIdAccont());//hace la consulta con el identioficador de usuario designado
        
        interface_rol_usuario = new RolUsercontroller();
        rol_usuario = interface_rol_usuario.findbyId(usuario.getIdUser());
        
        if(rol_usuario.getRolName().equals("Administrador")) 
            menu = "<button class=\"btn btn-sm btn-outline-secondary\" type=\"button\"><a rel=\"stylesheet\" href=\"AltaUsuarios.jsp\"/>Crear Usuario</a></button>"
                    + "<button class=\"btn btn-sm btn-outline-secondary\" type=\"button\"><a rel=\"stylesheet\" href=\"AltaRoles.jsp\"/>Crear Rol de Usuario</a></button>";
        if(rol_usuario.getRolName().equals("Empleado"))
            menu = "<button class=\"btn btn-sm btn-outline-secondary\" type=\"button\"><link rel=\"stylesheet\" href=\"url\"/>Buscar</button>";
        if(rol_usuario.getRolName().equals("Invitado"))
            menu = "<button class=\"btn btn-sm btn-outline-secondary\" type=\"button\"><link rel=\"stylesheet\" href=\"url\"/>Buscar</button>";
            
        
        sesion.setAttribute("loguin", "1");//Atributios de sesion definido para loguerse.
        sesion.setAttribute("cuenta", cuenta);//Atributios de sesion definido para las cuentas de usuario.
        sesion.setAttribute("usuario", usuario);//Atributios de sesion definido para los usuario.
        sesion.setAttribute("rol", rol_usuario);//Atributios de sesion definido para los roles de usuario.
        sesion.setAttribute("nav", menu);
        sesion.setMaxInactiveInterval(cuenta.getSession());//Tienpo maximo de sesion inactiva  definina al usuario.
        
        System.out.println(menu);
        
        if(sesion.getAttribute("logueado") == null ||sesion.getAttribute("logueado").equals("0")){
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("home.jsp");
        }
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servidor at " + request.getContextPath() + "</h1>");
            out.println("<label>se a conectado.</label>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
