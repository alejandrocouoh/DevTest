<%-- 
    Document   : index
    Created on : 5 ago. 2022, 5:03:24
    Author     : Alejandro Couoh Haas
--%>

<%@page import="Configuracion.Seguridad"%>
<%@page import="Controlador.Accontscotroller"%>
<%@page import="repositorios.IAconts"%>
<%@page import="Modelo.Acconts"%>
<%@page import="java.util.List"%>
<%@page import="Configuracion.SessionServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" 
               integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  </head>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>

        <div class="container-md">

            <div class="container-md">
                <img src="Images/imagen_usuario.png" class="rounded mx-auto d-block" alt="imagen_usuario"/>
            </div>

            <form method="post">
                <div class="mt-5">
                    <label for="exampleInputEmail1" class="form-label">Login con email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="usuario" aria-describedby="emailHelp" placeholder="ejemplo@correo.com">
                </div>
                <div class="mt-5">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="*******">
                </div>
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary" name="loging" >Login</button>
                    <div class="mt-5">
                        <%
                            if (request.getParameter("loging") != null) {
                        %>


                        <% if (request.getParameter("usuario").equals("")) { %>
                        <div class="alert alert-warning" role="alert">
                            <label><% out.println("Llene el campo de usuario con un email valido.");
                                }%> </label><br>
                        </div>
                        
                           <%  if (request.getParameter("password").equals("")) { %>
                           <div class="container-sm">
                               <div class="alert alert-warning" role="alert">
                                   <label>El Campo Password esta vacio.</label><br>
                               </div>
                           </div>
                        <%   }
                            IAconts acconts = new Accontscotroller();//Accede a la Bd
                            Acconts accont = acconts.findbyEmail(request.getParameter("usuario"));//obtener la cuenta solicitada
                            Seguridad cadena_encriptada = new Seguridad();
                        %>
                         
                        <% 
                              /*verifica si la cuenta existe*/  
                            if (accont == null) { %>
                        <div class="alert alert-danger" role="alert">
                            <label> <% out.println("La cuenta no existe.");
                                } %> </label><br>
                        </div>
                        
                        <%           
                            String pass_cuenta = accont.getPassword();
                            String pass_formulario = request.getParameter("password");
                            String pass_formulario_enc = cadena_encriptada.encriptarMD5(pass_formulario);
                            //if (accont.getPassword().equals(request.getParameter("password"))) { 
                            if(pass_cuenta.equals(pass_formulario_enc)){
                                HttpSession sesion = request.getSession();//Abre una nueva sesion con atributos de session
                                sesion.setAttribute("logueado", "1");
                                sesion.setAttribute("cuenta", accont);
                                response.sendRedirect("Servidor");//llamada de servlet de loguin
                            } else { %>
                            <div class="container-sm">
                                <div class="alert alert-danger" role="alert">
                                    <label> La contraseña no es correcta.</label><br>
                                </div>
                            </div>
                            <% } %>                
                        <%    } %>
                    </div>
                                    </div>
            </form>
        </div>

    </body>
</html>

