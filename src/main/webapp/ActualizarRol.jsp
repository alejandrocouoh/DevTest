<%-- 
    Document   : ActualizarRol
    Created on : 21 ago. 2022, 23:18:39
    Author     : Alejandro Couoh Haas <your.name at your.org>
--%>

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
        <% 
            HttpSession sesion = request.getSession();
            String nombre_rol = request.getParameter("id"); 
            sesion.setAttribute("edt", nombre_rol);
        %>
        <div class="container-sm">
            <form name="Actualizar" action="ActualizarRol" method="POST">
                <div class="mt-5">
                    <h1><label><strong>ID Rol:</strong> <%out.print(nombre_rol); %></label></h1>
                    <br/>
                    <input type="text" name="name-rol" class="form-control" placeholder="Nuevo nombre del rol"/>
                    <br/>
                    <input type="submit" class="btn btn-primary" value="Actualizar Rol" name="btn-Actualizar"/>
                </div>
            </form>
        </div>
                    
         <div class="container-sm">
             <label><% sesion.getAttribute("etiqueta"); %></label>
        </div>    
        
        <div class="container-sm">
            <a href="AltaRoles.jsp"><input type="submit" class="btn btn-primary" value="Regresar" name="btn-back"/></a>        </div>  
        
    </body>
</html>
