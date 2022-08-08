<%-- 
    Document   : AltaRoles
    Created on : 7 ago. 2022, 8:00:20
    Author     : Alejandro Couoh Haas
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
        
        <% HttpSession sesion = request.getSession(); %>
        
        <div class="container-sm">
            <h1><strong>Alta de nuevos roles de usuario.</strong></h1>
        </div>
        <div class="container-sm">
            <form method="post" action="RolesServlet">
                
                <div class="mt-5">
                    <label class="form-label">Nombre del rol:</label>
                    <input type="text" class="form-control" name="name_user" aria-label="name_rol" placeholder="Ejemplo Invitado">
                </div>
                <br/>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        Alta
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                    <label class="form-check-label" for="flexCheckChecked">
                        Modificar
                    </label>
                </div>               
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                    <label class="form-check-label" for="flexCheckChecked">
                        Eliminar
                    </label>
                </div>           
                                               
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary" name="Alta" >Crear Usuario</button>
                    <% 
                        sesion.setAttribute("rol","name_rol");
                        if(request.getParameter("Alta")!= null)
                        response.sendRedirect("RolesServlet");
                        out.println((String)sesion.getAttribute("etiqueta"));
                    %>
                    </div>
            </form>
        </div>
    </body>
</html>
