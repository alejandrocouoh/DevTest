<%-- 
    Document   : Asignacion3
    Created on : 19 ago. 2022, 2:20:49
    Author     : Alejandro Couoh Haas <your.name at your.org>
--%>

<%@page import="Controlador.RolUsercontroller"%>
<%@page import="Modelo.RolUser"%>
<%@page import="repositorios.IRolUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            sesion.getAttribute("loguin");
            sesion.getAttribute("cuenta");
            sesion.getAttribute("usuario");
            sesion.getAttribute("rol");
            sesion.getAttribute("nav");
            sesion.getMaxInactiveInterval();
            
            String id = (String) request.getParameter("id");//Id del rol de usuario
            int valor = Integer.valueOf(id);//Se convierte en un número entero
            IRolUser iru = new RolUsercontroller();
            RolUser ru = iru.findbyId(valor);//Obtiene El rol de usuario según el Id
        %>

        <div class="container-sm">
            <h1><strong>Asignacion de modulos.</strong></h1>
        </div>


        <div class="container-sm">

            <a href="AltaRoles.jsp"><button type="submit" class="btn btn-primary" name="back" >Regresar</button></a>

            <form method="post"  >

                <div class="mt-3">
                    <button type="submit" class="btn btn-primary" name="Alta" >Guardar cambios</button>                   
                </div>
                
                <div class="mt-5">
                    <label class="form-label"><h2>Nombre del rol:<strong> <% out.println(ru.getRolName());%> </strong></h2> </label>
                </div>

                    <jsp:include page="PermisosServlet2"/>

            </form>
            <br/>
        </div>
    </body>
</html>
