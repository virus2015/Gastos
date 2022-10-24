<%-- 
    Document   : MostrarTienda
    Created on : 13/08/2019, 11:03:48 AM
    Author     : jorge.lopez
--%>

<%@page import="Datos.TiendasD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%   
           
           TiendasD tin =(TiendasD) request.getAttribute("idTiendas");
        
          //CategoriasD ca = (CategoriasD)request.getAttribute("idCategorias");
        %>
        <table >
            <tr>
             <th>IDTIENDAS</th>
             <th>NOMBRE</th>
             <th>CIUDAD</th>
             <th>COLONIA</th>
             <th>CALLE</th>
             <th>TELEFONO</th>
             <th>WEB</th>
            
             </tr>
             <tr>
             <td><%=tin.getIdTiendas() %></td>
             <td><%=tin.getNombre() %></td>
             <td><%=tin.getCiudad() %></td>
             <td><%=tin.getColonia() %></td>
             <td><%=tin.getCalle() %></td>
             <td><%=tin.getTelefono() %></td>
             <td><%=tin.getWeb() %></td>
             
             </tr>    

            
            
        </table>
        
        
        
    </body>
</html>
