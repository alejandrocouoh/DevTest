/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.vistas;

import Controlador.AccontsUsercontroller;
import Controlador.Accontscotroller;
import Controlador.Usercontroller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositorios.IAccontsUser;
import repositorios.IAconts;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
@WebServlet(name = "EliminarUsuarioCuenta", urlPatterns = {"/EliminarUsuarioCuenta"})
public class EliminarUsuarioCuenta extends HttpServlet {

    private String html_etiqueta;
    private HttpSession sesion;
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
        sesion = request.getSession();
        String id_usuario = (String) request.getParameter("id_u");
        String id_cuenta = (String) request.getParameter("id_cuenta");
        int valor_usuario = Integer.valueOf(id_usuario);
        int valor_cuenta = Integer.valueOf(id_cuenta);
        IUser iru = new Usercontroller();
        IAconts cuenta = new Accontscotroller();
        IAccontsUser relacion_tabla = new AccontsUsercontroller();
        String mensaje = "cuenta eliminada";
        iru.delete(valor_usuario);

        cuenta.delete(valor_cuenta);
        relacion_tabla.delete(valor_usuario);
                iru.closeSession();
                cuenta.closeSesion();
                relacion_tabla.close();
        html_etiqueta = "<div class=\"alert alert-danger\" role=\"alert\"><label>" + mensaje + ", !ELIMINADO¡</label></div>";
        sesion.setAttribute("etiqueta", html_etiqueta);
        response.sendRedirect("Usuarios.jsp");
        //response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarUsuarioCuenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarUsuarioCuenta at " + request.getContextPath() + "</h1>");
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
