<%-- 
    Document   : AltaRoles
    Created on : 7 ago. 2022, 8:00:20
    Author     : Alejandro Couoh Haas
--%>

<%@page import="java.lang.Exception"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.RolUser"%>
<%@page import="java.util.List"%>
<%@page import="repositorios.IRolUser"%>
<%@page import="Controlador.RolUsercontroller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
        <% HttpSession sesion = request.getSession(); %>
        
        <div class="container-sm">
            <h1><strong>Alta de nuevos roles de usuario.</strong></h1>
        </div>
        <div class="container-sm">
            <form method="post" >
                
                <div class="mt-5">
                    <label class="form-label">Nombre del rol:</label>
                    <input type="text" class="form-control" name="nameuser" aria-label="name_rol" placeholder="Ejemplo Invitado">
                </div>
                <br/>      
                                               
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary" name="Alta" >Crear Rol de Usuario</button>
                    </div>
            </form>
            <div class="container-sm">
                <br/>
                    <%
                        if (request.getParameter("Alta") != null) {
                                if (request.getParameter("nameuser").equals("") || request.getParameter("nameuser") == null) {
                                    out.println("<div class=\"alert alert-warning\" role=\"alert\"><label>Ingrese un nombre de rol.</label></div>");
                                } else {
                                    sesion.setAttribute("rol", request.getParameter("nameuser"));
                                    response.sendRedirect("RolesServlet");
                                }
                            }
                            out.println((String)sesion.getAttribute("etiqueta"));
                    %>
            </div>
            
                    <% 

                    %>
            
            <div class="container-sm">
                <br/>
                <form method="post" >
                    <table class="table">
                        <thead>
                            <tr>                            
                                <th scope="col"><strong>ID</strong></th>
                                <th scope="col"><strong>Nombre del Rol</strong></th>
                                <th scope="col"><strong></strong></th>
                                <th scope="col"><strong></strong></th>
                                <th scope="col"><strong></strong></th>
                            </tr>
                        </thead>
                        <tbody>

                            <%                                
                                IRolUser rolusuario = new RolUsercontroller();
                                List<RolUser> rolusers = rolusuario.rol_users();
                                ArrayList<String> properti = new ArrayList<>();
                                
                                for (RolUser r : rolusers) { 
                                    String id = String.valueOf(r.getIdRoll());
                            %>
                            <tr>
                                <th scope="row"><label><% out.println(r.getIdRoll()); %></label></th>
                                <td> <% out.println(r.getRolName()); %> </td>
                                <td>
                                    <button class="btn btn-outline-secondary" type="submit"><a href="Asignacion.jsp?id=<%=id %>">Asignar Permisos</a></button>
                                    <button class="btn btn-outline-secondary" type="submit"><a href="Asignacion.jsp?id=<%=id %>">Actualizar</a></button>
                                    <button class="btn btn-outline-secondary" type="submit"><a href="Asignacion.jsp?id=<%=id %>">Eliminar</a></button><!--  -->
                                    <%                                   
                                    }
                                %>
                                
                                </td>
                                
                            </tr> 
                            
                        </tbody>
                    </table>
                </form>
            </div>
                                <button class="btn btn-outline-secondary" type="submit" name="back"><a href="home.jsp">Regresar</a></button>
        </div>
    </body>
</html>
