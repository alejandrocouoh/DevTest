/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.vistas;

import Controlador.RolUsercontroller;
import Modelo.RolUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositorios.IRolUser;

/**
 *
 * @author Alejandro Couoh Haas
 */
@WebServlet(name = "RolesServlet", urlPatterns = {"/RolesServlet"})
public class RolesServlet extends HttpServlet {

    private HttpSession sesion;
    private String html_etiqueta;
    private String verificar_valor;
    private IRolUser irol_user;
    private RolUser rol_user;
    
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
        
        verificar_valor = (String) sesion.getAttribute("rol");
        
        irol_user = new RolUsercontroller();
        
        rol_user = new RolUser();
        rol_user.setRolName(verificar_valor);
        irol_user.save(rol_user);
        html_etiqueta = "<div class=\"alert alert-success\" role=\"alert\"><label>Rol " + irol_user.save(rol_user).getRolName() + ", !Ingresado¡</label></div>";
        sesion.setAttribute("etiqueta", html_etiqueta);
        response.sendRedirect("AltaRoles.jsp");
        

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RolesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RolesServlet at " + request.getContextPath() + "</h1>");
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
