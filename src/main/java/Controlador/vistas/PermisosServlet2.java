/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.vistas;

import Controlador.PrivRolController;
import Controlador.Privilegioscontroller;
import Controlador.RolUsercontroller;
import Modelo.Privilegios;
import Modelo.RolPrivilegio;
import Modelo.RolUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositorios.IPrivRol;
import repositorios.IPrivilegios;
import repositorios.IRolUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
@WebServlet(name = "PermisosServlet2", urlPatterns = {"/PermisosServlet2"})
public class PermisosServlet2 extends HttpServlet {

    private Privilegios privilegio;
    private Privilegios privilegioc;
    private List<RolPrivilegio> lista_pRol;

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

        HttpSession sesion = request.getSession();
        sesion.getAttribute("loguin");
        sesion.getAttribute("cuenta");
        sesion.getAttribute("usuario");
        sesion.getAttribute("rol");
        sesion.getAttribute("nav");
        sesion.getMaxInactiveInterval();

        String id = (String) request.getParameter("id");
        int valor = Integer.valueOf(id);
        IRolUser iru = new RolUsercontroller();
        RolUser ru = iru.findbyId(valor);

        IPrivRol pr = new PrivRolController();//Interfaz con los metos para salvar los privilegios de los roles
        RolPrivilegio opr = new RolPrivilegio();////Tabla relacional, contiene los id de los privelegios asignados a los roles

        List<RolPrivilegio> lista_rol_P = pr.findbyIdRol(ru.getIdRoll());//Trae la lista de privilegios asignados a ese rol.
        Iterator<RolPrivilegio> iterador_lista_rol_P = lista_rol_P.iterator();

        IPrivilegios iprivilegios = new Privilegioscontroller();
        List<Privilegios> privilegios = iprivilegios.privilegios();

        String[] seleccion = request.getParameterValues("option");
        String atributo = " ";

//        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("Alta")!= null){//Se verifica si el botón se preciono
                
//                for(String opciones : seleccion){
//                     out.print(opciones);
//                }
                if (lista_rol_P.isEmpty()) {//Se verifica si, el rol ya tiene asignadoos modulos.
                    for (String opciones : seleccion) {
                        int value = Integer.valueOf(opciones);
                        opr.setIdPrivilegio(value);
                        opr.setIdRol(valor);
                        pr.save(opr);
                        response.sendRedirect("Asignacion3.jsp");
                    }

                } else {
                    for (String opciones : seleccion) {
                        int value = Integer.valueOf(opciones);
                        opr.setIdPrivilegio(value);
                        opr.setIdRol(valor);
                        pr.edit(opr);
                        response.sendRedirect("Asignacion3.jsp");
                    }
                }

            }

            for (Privilegios p : privilegios) {
                for (RolPrivilegio rp : lista_rol_P) {
                    if (p.getIdPrivilegio() == rp.getIdPrivilegio()) {
                        atributo = "checked";
                    }
                }
                out.println("<div class=\"form-check\"><input class=\"form-check-input\" type=\"checkbox\" value=\"" + p.getIdPrivilegio() + "\" id=\"flexCheckDefault\" name=\"option\" " + atributo + "/>");
                out.print("<label class=\"form-check-label\" for=\"flexCheckDefault\">" + p.getPrivilegio() + "</label></div>");
            }
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
