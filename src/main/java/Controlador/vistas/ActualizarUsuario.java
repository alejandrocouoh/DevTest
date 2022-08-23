/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.vistas;

import Controlador.Accontscotroller;
import Controlador.Relacion;
import Controlador.Usercontroller;
import Modelo.Acconts;
//import Modelo.AccontsUsers;
//import Modelo.AccontsUsersPK;
import Modelo.RolUser;
import Modelo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositorios.IAconts;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/ActualizarUsuario"})
public class ActualizarUsuario extends HttpServlet {

    private HttpSession sesion;
    private String nombres;
    private String apellidop;
    private String apellidom;
    private String fecha;
    private String direccion;
    private String ciudad;
    private String estado;
    private String pais;
    private String email;
    private String celular;
    private String password;
    private String rpassword;
    private String rol_asignado;
    private String tiempo_sesion;
    private String mensaje1, mensaje2, mensaje3, mensaje4, mensaje5, mensaje6, mensaje7, mensaje8, mensaje9, mensaje10, mensaje11,mensaje12, mensaje13, mensaje14;
    private String validar_password;
    private String id_cuenta;
    private String id_user;
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private int valor_idusuario;
    private int valor_idcuenta;
    
    private Acconts cuenta = new Acconts();
    private User usuario = new User();
    private RolUser rol_usuario = new RolUser();
//    private AccontsUsers CU = new AccontsUsers();
//    private AccontsUsersPK relacion_CU = new AccontsUsersPK();
    /*
    Objetos para nuevas cuentas de usuario y roles de usuario
    */
    private IAconts iacconts = new Accontscotroller();
    private IUser iusuario = new Usercontroller();
    private Relacion relacion;
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
            throws ServletException, IOException, ParseException {
        
        sesion = request.getSession();
        id_cuenta = (String) sesion.getAttribute("Idcuenta");
        id_user = (String) sesion.getAttribute("Iduser");
        nombres = (String) sesion.getAttribute("nameuser");
        apellidop = (String) sesion.getAttribute("lnameuser");
        apellidom = (String) sesion.getAttribute("snameuser");
        fecha = (String) sesion.getAttribute("fecha");
        direccion = (String) sesion.getAttribute("direccion");
        ciudad = (String) sesion.getAttribute("ciudad");
        estado = (String) sesion.getAttribute("Estado");
        pais = (String) sesion.getAttribute("pais");
        email = (String) sesion.getAttribute("correo");
        celular = (String) sesion.getAttribute("movil");
        password = (String) sesion.getAttribute("contrasenya");
        rpassword = (String) sesion.getAttribute("rcontrasenya");
        rol_asignado = (String) sesion.getAttribute("rol");
        tiempo_sesion = (String) sesion.getAttribute("timesession");
        valor_idcuenta = Integer.valueOf(id_cuenta);
        valor_idusuario = Integer.valueOf(id_user);
        
        if(nombres == null || nombres.equals("")){ 
            mensaje1 ="El campo Nombre(s) requiere ser llenado ";
            sesion.setAttribute("alerta", mensaje1);
            response.sendRedirect("AltaUsuarios.jsp");
        }else if(apellidop == null || apellidop.equals("")){ mensaje2 ="El campo Apellido Paterno requiere ser llenado ";
        }else if(apellidom == null || apellidom.equals(nombres)){ mensaje3 ="El campo Apellido Materno requiere ser llenado ";
        }else if(fecha == null || fecha.equals("")){ mensaje4 ="El campo fecha de nacimiento requiere ser llenado ";
        }else if(direccion == null || direccion.equals("")){ mensaje5 ="El campo dirección requiere ser llenado ";
        }else if(ciudad == null || ciudad.equals("")){ mensaje6 ="El campo ciudad requiere ser llenado ";
        }else if(estado == null || estado.equals("")){ mensaje7 ="El estado requiere ser llenado ";
        }else if(pais == null || pais.equals("")){ mensaje8 ="El campo pais requiere ser llenado ";
        }else if(email == null || email.equals("")){ mensaje9 ="El campo email requiere ser llenado ";
        }else if(celular == null || celular.equals("")){ mensaje10 ="El campo celular requiere ser llenado ";
        }else if(password == null || password.equals("")){ mensaje11 ="El campo password requiere ser llenado ";
        }else if(rpassword == null || rpassword.equals("")){ mensaje12 ="El campo validar password requiere ser llenado ";
        }else if(rol_asignado == null || rol_asignado.equals("")){ mensaje13 ="El campo rol requiere ser llenado ";
        }else if(tiempo_sesion == null || tiempo_sesion.equals("")) mensaje14 ="El campo tiempo de sesion requiere ser llenado ";

        /*
        Validacion de la contraseña
        */
       
        if(password.equals(rpassword)){
            usuario.setIdUser(valor_idusuario);
            usuario.setName(nombres);
            usuario.setLname(apellidop);
            usuario.setSlastname(apellidom);
            usuario.setBdate(formato.parse(fecha));
            usuario.setAddress(direccion);
            usuario.setCity(ciudad);
            usuario.setState(estado);
            usuario.setContry(pais);
            cuenta.setIdAccont(valor_idcuenta);
            cuenta.setEmail(email);
            cuenta.setPhone(celular);
            cuenta.setRol(rol_asignado);
            cuenta.setPassword(password);
            cuenta.setSession(Integer.valueOf(tiempo_sesion)*60);
            iacconts.edit(cuenta);
            iusuario.edit(usuario);
//            relacion = new Relacion();
//            relacion.establecer_relacion(cuenta.getEmail(), usuario);
            response.sendRedirect("Usuarios.jsp");
        }else{
            validar_password = "Las contraseñas no son iguales";
            sesion.setAttribute("alerta", validar_password);
            response.sendRedirect("AltaUsuarios.jsp");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarUsuario at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ActualizarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ActualizarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
