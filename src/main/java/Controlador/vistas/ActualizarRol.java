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
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
@WebServlet(name = "ActualizarRol", urlPatterns = {"/ActualizarRol"})
public class ActualizarRol extends HttpServlet {
    
    HttpSession sesion;
    private String nombre_rol;
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
        String id = (String) sesion.getAttribute("edt");//Se recupera el Id del rol de usuario.
        nombre_rol = request.getParameter("name-rol");//Captura el nuevo nombre del rol
        int valor = Integer.valueOf(id);
        IRolUser iru = new RolUsercontroller();
        RolUser ru = iru.findbyId(valor);
        
        if (nombre_rol == null) {//Se evalua si el campo esta vacio.
            String mensaje = "<div class=\"alert alert-warning\" role=\"alert\"><label>Ingrese un nombre de rol.</label></div>";
            sesion.setAttribute("etiqueta", mensaje);
            request.setAttribute("id", id);
            response.sendRedirect("ActualizarRol.jsp");
        } else {
            ru.setRolName(nombre_rol);
            iru.edit(ru);//Se actualiza el nuevo nombre del rol.
            request.setAttribute("id", id);
            String mensaje = "<div class=\"alert alert-success\" role=\"alert\"><label> Se Actualizo el rol. </label></div>";
            sesion.setAttribute("etiqueta", mensaje);
            response.sendRedirect("ActualizarRol.jsp");
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
