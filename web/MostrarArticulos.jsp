<%-- 
    Document   : MostrarArticulos
    Created on : 14/08/2019, 12:31:15 PM
    Author     : jorge.lopez
--%>

<%@page import="Datos.ArticulosD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
        
        ArticulosD articulos = (ArticulosD)request.getAttribute("id");
        %>
        <table>
        <tr>
            <th>ID </th>
            <th>NOMBRE </th>
            <th>DESCRIPCION </th>
            <th>MARCA</th>
        <tr>
        <tr>
              <td><%=articulos.getIdArticulos() %></td>
              <td><%=articulos.getNombre() %></td>
              <td><%=articulos.getDescripcion() %></td>
              <td><%=articulos.getMarca() %></td>
              
        </tr>    
            
            
        </table>    
        
        
        
    </body>
</html>
