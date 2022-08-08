<%-- 
    Document   : menu
    Created on : 5 ago. 2022, 7:12:02
    Author     : Alejandro Couoh Haas
--%>

<%@page import="Modelo.RolUser"%>
<%@page import="Modelo.User"%>
<%@page import="Modelo.Acconts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Configuracion.SessionServlet"%>
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
        <%
            HttpSession sesion = request.getSession();
            Acconts cuenta = (Acconts) sesion.getAttribute("cuenta");
            User usuario = (User) sesion.getAttribute("usuario");
            RolUser rol_usuario = (RolUser) sesion.getAttribute("rol");
            String menu = (String) sesion.getAttribute("nav");
                    
        %>

         <div class="container-sm">
             <%  %>
             <nav class="navbar bg-light">
                 <form class="container-fluid justify-content-start">
                     <% out.println(menu); %>
                     <button class="btn btn-outline-success me-2" type="button" name="cerrar"><a href="index.jsp">Cerrar Sesion</a></button>
                     <% if(request.getParameter("cerrar")!=null)
                            sesion.invalidate();
                     %>
                 </form>
             </nav>
            
         </div>
        
                     <div class="container-sm">
                         <h1>
                                 <label> Hola <% out.println(usuario.getName() + " " + usuario.getLname()
                        + " " + usuario.getSlastname());%>, !Bienvenido¡ </label>
                             <br>
                         </h1>
                     </div>
    </body>
</html>
