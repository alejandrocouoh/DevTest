<%-- 
    Document   : ActualizarUsuario
    Created on : 17 ago. 2022, 2:04:10
    Author     : Alejandro Couoh Haas <your.name at your.org>
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.RolUser"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.RolUsercontroller"%>
<%@page import="repositorios.IRolUser"%>
<%@page import="Modelo.Acconts"%>
<%@page import="repositorios.IAconts"%>
<%@page import="Controlador.Accontscotroller"%>
<%@page import="Modelo.User"%>
<%@page import="repositorios.IUser"%>
<%@page import="Controlador.Usercontroller"%>
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
        
        <div class="container-sm">
            <h1><strong>Actualizar cuentas de usuario.</strong></h1>
        </div>
        <% 
            HttpSession sesion = request.getSession();
            sesion.getAttribute("loguin");
            sesion.getAttribute("cuenta");
            sesion.getAttribute("usuario");
            sesion.getAttribute("rol");
            sesion.getAttribute("nav");
            sesion.getMaxInactiveInterval();
            
            IUser iuser = new Usercontroller();
            IAconts iacconts = new Accontscotroller();
            String id_usuario = (String) request.getParameter("id_u");
            String id_cuenta = (String) request.getParameter("id_cuenta");
            int valor_usuario = Integer.valueOf(id_usuario);
            int valor_cuenta = Integer.valueOf(id_cuenta);
            User user = iuser.findbyId(valor_usuario);
            Acconts aconts = iacconts.findbyId(valor_cuenta);
            
            IRolUser rol = new RolUsercontroller();
            List<RolUser> roles = rol.rol_users();
            Iterator<RolUser> iterarRol = roles.iterator();
        %>
        <div class="container-sm">
            <form method="post" >
                
                <div class="mt-5" >
                    <label class="form-label">Nombre(s):</label>
                    <input type="text" class="form-control" id="validationCustom01" name="name_user" value="<% out.print(user.getName()); %>" aria-label="Username" oninvalid="setCustomValidity('Por favor ingresa solo letras')" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Apellido Paterno:</label>
                    <input type="text" class="form-control" name="lname_user" aria-label="Username" value="<% out.print(user.getLname()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Apellido Materno:</label>
                    <input type="text" class="form-control" name="sname_user" aria-label="Username" value="<% out.print(user.getSlastname()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Fecha de nacimiento: </label>
                    <input type="date" class="form-control" name="bdate" aria-label="Username" value="<% out.print(user.getBdate()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Direccion: </label>
                    <input type="text" class="form-control" name="adress" aria-label="Username" value="<% out.print(user.getAddress()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Ciudad: </label>
                    <input type="text" class="form-control" name="city" aria-label="Username" value="<% out.print(user.getCity()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Estado: </label>
                    <input type="text" class="form-control" name="state" aria-label="Username" value="<% out.print(user.getState()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">País: </label>
                    <input type="text" class="form-control" name="contry" aria-label="Username" value="<% out.print(user.getContry()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Loguing y Password </label>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Email: </label>
                    <input type="text" class="form-control" name="email" aria-label="Username" value="<% out.print(aconts.getEmail()); %>" required>
                </div>               
                
                <div class="mt-5">
                    <label class="form-label">Celular: </label>
                    <input type="tel" class="form-control" name="celular" aria-label="Username" value="<% out.print(aconts.getPhone()); %>" required="">
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Password: </label>
                    <input type="password" class="form-control" name="password" aria-label="Username" value="<% out.print(aconts.getPassword()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Repetir Password: </label>
                    <input type="password" class="form-control" name="rpassword" aria-label="Username" value="<% out.print(aconts.getPassword()); %>" required>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Rol Asignado: </label>
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="lista_desplegable" required>
                <!--        <option selected>Open this select menu</option>  -->
                        <% 
                            while (iterarRol.hasNext()) {
                                        RolUser rol_usuario = iterarRol.next();
                        %>
                        <option value="<%=rol_usuario.getIdRoll() %>" selected="<% aconts.getRol(); %>" ><%=rol_usuario.getRolName() %></option>
                        <%
                                }
                        %>
                    </select>
                </div>
                
                <div class="mt-5">
                    <label class="form-label">Tiempo asignado de sesion: </label>
                    <input type="number" class="form-control" name="sesion" aria-label="Username" value="<% out.print(aconts.getSession()); %>" required>
                </div>
                
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary" name="Alta" >Actualizar Usuario</button>
                            <% 
                                if(request.getParameter("Alta")!= null){
                                    sesion.setAttribute("Idcuenta", id_cuenta);
                                    sesion.setAttribute("Iduser", id_usuario);
                                    sesion.setAttribute("nameuser", request.getParameter("name_user"));
                                    sesion.setAttribute("lnameuser", request.getParameter("lname_user"));
                                    sesion.setAttribute("snameuser", request.getParameter("sname_user"));
                                    sesion.setAttribute("fecha", request.getParameter("bdate"));
                                    sesion.setAttribute("direccion", request.getParameter("adress"));
                                    sesion.setAttribute("ciudad", request.getParameter("city"));
                                    sesion.setAttribute("Estado", request.getParameter("state"));
                                    sesion.setAttribute("pais", request.getParameter("contry"));
                                    sesion.setAttribute("correo", request.getParameter("email"));
                                    sesion.setAttribute("movil", request.getParameter("celular"));
                                    sesion.setAttribute("contrasenya", request.getParameter("password"));
                                    sesion.setAttribute("rcontrasenya", request.getParameter("rpassword"));
                                    sesion.setAttribute("rol", request.getParameter("lista_desplegable"));
                                    sesion.setAttribute("timesession", request.getParameter("sesion"));
                                    response.sendRedirect("ActualizarUsuario");
                                }
                            %>
                    </div>
            </form>
                    <br/>
                     <a href="Usuarios.jsp"><button type="submit" class="btn btn-primary" name="back" >Regresar</button></a> 
        </div>         
    </body>
</html>
