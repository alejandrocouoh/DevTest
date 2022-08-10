<%-- 
    Document   : Asignacion
    Created on : 8 ago. 2022, 22:37:36
    Author     : Alejandro Couoh Haas <your.name at your.org>
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Controlador.RolUsercontroller"%>
<%@page import="repositorios.IRolUser"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.RolUser"%>
<%@page import="Controlador.Privilegioscontroller"%>
<%@page import="repositorios.IPrivilegios"%>
<%@page import="Modelo.Privilegios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                try {
                    String id = (String) request.getParameter("id");
                    int valor = Integer.valueOf(id);
                    IPrivilegios ipermisos = new Privilegioscontroller();
                    List<Privilegios> lprivilegios = ipermisos.privilegios();
                    IRolUser iru = new RolUsercontroller();
                    RolUser ru = iru.findbyId(valor);   
        %>
        <div class="container-sm">
            <h1><strong>Asignacion de modulos.</strong></h1>
        </div>
        
        <div class="container-sm">
            <form method="get" action="PermisosServlet">
                <div class="mt-5">
                    <label class="form-label">Nombre del rol:  <% out.println(ru.getRolName()); %></label>
                </div>
                <br/>  

                <%
                    String[] selector = new String[lprivilegios.size()+1];
                    int i = 0;
                    /* Ciclo para pintar las opciones en el navegador */
                    for (Privilegios p : lprivilegios) {
                    selector[i] = p.getPrivilegio();
                    
                %>   
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="<%=selector[i]%>" id="flexCheckDefault" name="<%=selector[i]%>">
                        <label class="form-check-label" for="flexCheckDefault">
                            <% out.println(p.getPrivilegio()); i++; %>
                        </label>
                    </div> 
                            <%  }   %>            
                <div class="mt-3">
                    <button type="submit" class="btn btn-primary" name="Alta" >Guardar cambios</button>
                </div>
                
                            <%   
                                int j = 0;
                                        List<Privilegios> permisos_asignados = new ArrayList<>();
                                        if (request.getParameter("Alta") != null) {// Se verifica si se hace click en el boton
                                            for (Privilegios privelege : lprivilegios) {//Se recorre  la lista de opciones ya asigandas
                                                if (selector != null) {
                                                    if (request.getParameter(selector[j]) != null) {//Se verifica si las cajas de opciones estan seleccionadas
                                                        permisos_asignados.add(privelege);//Se agrega a la lista nueva de permisos seleccionados
                                                    }
                                                }
                                                j++;
                                            }
                                            sesion.setAttribute("permisos", permisos_asignados);//se envian los permisos al servlet
                                            sesion.setAttribute("identificador", ru);// se envian los roles al servlet
                                        }
                                        
                                    } catch (Exception e) {
                                        out.println(e.getMessage());
                                    }
                        //sesion.setAttribute("rol", "valor");
                            %>

            </form>
        </div>
                            <div class="mt-3">
                                <div class="alert alert-warning" role="alert">
                                    <label><% 
                                            //String mensaje = request.getParameter("mensaje");
                                            String mensaje =  (String) sesion.getAttribute("mensaje");
                                            if(mensaje!=null) out.println(mensaje);
                                        %></label><br>
                               </div>
                            </div>
    </body>
</html>
