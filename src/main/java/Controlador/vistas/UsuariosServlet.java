/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.vistas;

import Controlador.AccontsUsercontroller;
import Controlador.Accontscotroller;
import Controlador.Usercontroller;
import Modelo.Acconts;
import Modelo.AccontsUsers;
import Modelo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositorios.IAccontsUser;
import repositorios.IAconts;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

    String nombre_usuario;
    String boton_buscar;
    String boton_mostrar;
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
        
        User ref_user;
        Acconts ref_acconts;
        AccontsUsers ref_accontsUsser;
        nombre_usuario = request.getParameter("nombre");
        boton_buscar = request.getParameter("buscar");
        boton_mostrar = request.getParameter("todo");
        

        IAconts cuentas = new Accontscotroller();
        IUser usuarios = new Usercontroller();
        IAccontsUser relacion = new AccontsUsercontroller();

        List<User> lista_usuarios = usuarios.users();
        Iterator<User> iterador_lista_usuarios = lista_usuarios.iterator();

        List<AccontsUsers> lista_relaciones = relacion.users();
        Iterator<AccontsUsers> iterador_lista_tablas = lista_relaciones.iterator();
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if (boton_buscar != null) {
                 while (iterador_lista_tablas.hasNext()) {//Recorre la tabla relacionada de cuentas usuario
                    ref_accontsUsser = iterador_lista_tablas.next();//Asigna un registro de la tabala cuentas usuario
                    ref_user = usuarios.findbyId(ref_accontsUsser.getAccontsUsersPK().getUserId());//Obtiene el usuario relacionado con la cuenta
//                    if(ref_user.getName().equals(split[0]) || ref_user.getLname().equals(split[1]) || ref_user.getSlastname().equals(split[2])){
                    if(nombre_usuario.equals(ref_user.getName()+" "+ref_user.getLname()+" "+ref_user.getSlastname())){
                        ref_acconts = cuentas.findbyId(ref_accontsUsser.getAccontsUsersPK().getAccountId());//obtiene la cuenta relacionada con el usuario
                    int id_usuario = ref_user.getIdUser();
                    int id_cuenta = ref_acconts.getIdAccont();
                    out.print("<tr>\n"
                            + "                                <th scope=\"row\"><label>" + ref_user.getName() + "</label></th>\n"
                            + "                                <td>" + ref_user.getLname() + "</td>\n"
                            + "                                <td>" + ref_user.getSlastname() + "</td>\n"
                            + "                                <td>" + ref_user.getBdate() + "</td>\n"
                            + "                                <td>" + ref_acconts.getEmail() + "</td>\n"
                            + "                                <td>" + ref_acconts.getPhone() + "</td>\n"
                            + "                                <td>" + ref_acconts.getRol() + "</td>\n"
                            + "                                <td>\n"
                            + "                                    <button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"ActualizarUsuario.jsp?id_u=" + id_usuario + "&id_cuenta=" + id_cuenta + "\">Actualizar</a></button>\n"
                            + "                                    <button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"EliminarUsuarioCuenta?id_u=" + id_usuario + "&id_cuenta=" + id_cuenta + "\">Eliminar</a></button>\n"
                            + "                                </td>\n"
                            + "                            </tr> ");
                    }
                }
            } else if (boton_mostrar != null) {
                while (iterador_lista_tablas.hasNext()) {//Recorre la tabla relacionada de cuentas usuario
                    ref_accontsUsser = iterador_lista_tablas.next();//Asigna un registro de la tabala cuentas usuario
                    ref_user = usuarios.findbyId(ref_accontsUsser.getAccontsUsersPK().getUserId());//Obtiene el usuario relacionado con la cuenta
                    ref_acconts = cuentas.findbyId(ref_accontsUsser.getAccontsUsersPK().getAccountId());//obtiene la cuenta relacionada con el usuario
                    int id_usuario = ref_user.getIdUser();
                    int id_cuenta = ref_acconts.getIdAccont();
                    out.print("<tr>\n"
                            + "                                <th scope=\"row\"><label>" + ref_user.getName() + "</label></th>\n"
                            + "                                <td>" + ref_user.getLname() + "</td>\n"
                            + "                                <td>" + ref_user.getSlastname() + "</td>\n"
                            + "                                <td>" + ref_user.getBdate() + "</td>\n"
                            + "                                <td>" + ref_acconts.getEmail() + "</td>\n"
                            + "                                <td>" + ref_acconts.getPhone() + "</td>\n"
                            + "                                <td>" + ref_acconts.getRol() + "</td>\n"
                            + "                                <td>\n"
                            + "                                    <button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"ActualizarUsuario.jsp?id_u=" + id_usuario + "&id_cuenta=" + id_cuenta + "\">Actualizar</a></button>\n"
                            + "                                    <button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"EliminarUsuarioCuenta?id_u=" + id_usuario + "&id_cuenta=" + id_cuenta + "\">Eliminar</a></button>                               \n"
                            + "                                </td>\n"
                            + "                            </tr> ");
                }
            } 
                while (iterador_lista_tablas.hasNext()) {
                    ref_accontsUsser = iterador_lista_tablas.next();
                    ref_user = usuarios.findbyId(ref_accontsUsser.getAccontsUsersPK().getUserId());
                    ref_acconts = cuentas.findbyId(ref_accontsUsser.getAccontsUsersPK().getAccountId());
                    int id_usuario = ref_user.getIdUser();
                    int id_cuenta = ref_acconts.getIdAccont();
                    out.print("<tr>\n"
                            + "                                <th scope=\"row\"><label>" + ref_user.getName() + "</label></th>\n"
                            + "                                <td>" + ref_user.getLname() + "</td>\n"
                            + "                                <td>" + ref_user.getSlastname() + "</td>\n"
                            + "                                <td>" + ref_user.getBdate() + "</td>\n"
                            + "                                <td>" + ref_acconts.getEmail() + "</td>\n"
                            + "                                <td>" + ref_acconts.getPhone() + "</td>\n"
                            + "                                <td>" + ref_acconts.getRol() + "</td>\n"
                            + "                                <td>\n"
                            + "                                    <button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"ActualizarUsuario.jsp?id_u=" + id_usuario + "&id_cuenta=" + id_cuenta + "\">Actualizar</a></button>\n"
                            + "                                    <button class=\"btn btn-outline-secondary\" type=\"submit\"><a href=\"EliminarUsuarioCuenta?id_u=" + id_usuario + "&id_cuenta=" + id_cuenta + "\">Eliminar</a></button>                               \n"
                            + "                                </td>\n"
                            + "                            </tr> ");
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
