/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.vistas;

import Controlador.RolUsercontroller;
import Modelo.RolUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "RolServlet", urlPatterns = {"/RolServlet"})
public class RolServlet extends HttpServlet {

    private HttpSession sesion;
    private IRolUser rolusuario;
    private List<RolUser> rolusers;
    private String user;
    private RolUser rol_user;
    private String html_etiqueta;
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
        rolusuario = new RolUsercontroller();
        rolusers = rolusuario.rol_users();
        Iterator<RolUser> iterador = rolusers.iterator();
        user = request.getParameter("nameuser");
        rol_user = new RolUser();
        
        try ( PrintWriter out = response.getWriter()) {

            if (request.getParameter("Alta") != null) {
                if (user.isEmpty() || user == null) {
                    html_etiqueta = "<div class=\"alert alert-warning\" role=\"alert\"><label>Ingrese un nombre de rol.</label></div>";
//                    response.sendRedirect("AltaRoles.jsp");
                    while (iterador.hasNext()) {
                        rol_user = iterador.next();
                        out.println("<tr>\n"
                                + "<th scope=\"row\"><label>" + rol_user.getIdRoll() + "</label></th>\n"
                                + "<td>" + rol_user.getRolName() + "</td>\n"
                                + "<td>\n"
                                + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"Asignacion3.jsp?id=" + rol_user.getIdRoll() + "\">Asignar Permisos</a></button>\n"
                                + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"ActualizarRo.jspl?id=" + rol_user.getIdRoll() + "\">Actualizar</a></button>"
                                + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"EliminarRol?id=" + rol_user.getIdRoll() + "\">Eliminar</a></button>\n"
                                + "\n"
                                + "</td>\n"
                                + "\n"
                                + "</tr> ");
                    }
                } else {
                    rol_user.setRolName(user);
                    rolusuario.save(rol_user);
                    html_etiqueta = "<div class=\"alert alert-success\" role=\"alert\"><label>Rol " + rol_user.getRolName() + ", !Ingresado¡</label></div>";
                    sesion.setAttribute("etiqueta", html_etiqueta);
                    while (iterador.hasNext()) {
                        rol_user = iterador.next();
                        out.println("<tr>\n"
                                + "<th scope=\"row\"><label>" + rol_user.getIdRoll() + "</label></th>\n"
                                + "<td>" + rol_user.getRolName() + "</td>\n"
                                + "<td>\n"
                                + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"Asignacion3.jsp?id=" + rol_user.getIdRoll() + "\">Asignar Permisos</a></button>\n"
                                + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"ActualizarRo.jspl?id=" + rol_user.getIdRoll() + "\">Actualizar</a></button>"
                                + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"EliminarRol?id=" + rol_user.getIdRoll() + "\">Eliminar</a></button>\n"
                                + "\n"
                                + "</td>\n"
                                + "\n"
                                + "</tr> ");
                    }
//                    response.sendRedirect("AltaRoles.jsp");
                }
            } else {
                while (iterador.hasNext()) {
                    rol_user = iterador.next();
                    out.println("<tr>\n"
                            + "<th scope=\"row\"><label>" + rol_user.getIdRoll() + "</label></th>\n"
                            + "<td>" + rol_user.getRolName() + "</td>\n"
                            + "<td>\n"
                            + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"Asignacion3.jsp?id=" + rol_user.getIdRoll() + "\">Asignar Permisos</a></button>\n"
                            + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"ActualizarRol.jsp?id=" + rol_user.getIdRoll() + "\">Actualizar</a></button>"
                            + "<button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"EliminarRol?id=" + rol_user.getIdRoll() + "\">Eliminar</a></button>\n"
                            + "\n"
                            + "</td>\n"
                            + "\n"
                            + "</tr> ");
                }
            }
            

            /* TODO output your page here. You may use following sample code. */
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
