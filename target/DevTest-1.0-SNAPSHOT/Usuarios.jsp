<%-- 
    Document   : Usuarios
    Created on : 16 ago. 2022, 18:00:41
    Author     : Alejandro Couoh Haas <your.name at your.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>

        <%
            HttpSession sesion = request.getSession();
            sesion.getAttribute("loguin");
            sesion.getAttribute("cuenta");
            sesion.getAttribute("usuario");
            sesion.getAttribute("rol");
            sesion.getAttribute("nav");
            sesion.getMaxInactiveInterval();
        %>
        
        <div class="container-sm">
            <h1>Datos de Usuarios.</h1>
            <div class="mt-3">
                <a href="AltaUsuarios.jsp"> <button type="submit" class="btn btn-primary" name="Alta" >Crear Usuario</button></a>
                <a href="home.jsp"> <button type="submit" class="btn btn-primary" name="Alta" >Regresar</button></a>
            </div>
                <br/>
                <form method="post" action="Usuarios.jsp" >
                    
                    <table class="table">
                        <thead>
                            <tr>                            
                                <th scope="col"><strong></strong></th>
                                <th scope="col"><strong></strong></th>
                                <th scope="col"><strong><input type="text" name="nombre" class="form-control" placeholder="buscar"/></strong></th>
                                <th scope="col"><strong><input type="submit" name="buscar" class="form-control btn btn-primary" value="Buscar"/></strong></th>
                                <th scope="col"><strong><input type="submit" name="todo" class="form-control btn btn-primary" value="Mostrar Todo"/></strong></th>
                                <th scope="col"><strong></strong></th>
                                <th scope="col"><strong></strong></th>
                                <th scope="col"><strong></strong></th>
                            </tr>
                            <tr>                            
                                <th scope="col"><strong>Nombre (s)</strong></th>
                                <th scope="col"><strong>Apellido Paterno</strong></th>
                                <th scope="col"><strong>Apellido Materno</strong></th>
                                <th scope="col"><strong>Fecha Nacimiento</strong></th>
                                <th scope="col"><strong>Email</strong></th>
                                <th scope="col"><strong>Celular</strong></th>
                                <th scope="col"><strong>Rol</strong></th>
                                <th scope="col"><strong>Acciones</strong></th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <jsp:include page="UsuariosServlet"/> 
                        </tbody>
                    </table>
                </form>
                    </div>
    </body>
</html>
