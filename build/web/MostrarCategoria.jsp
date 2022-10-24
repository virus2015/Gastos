<%-- 
    Document   : MostrarCategoria
    Created on : 7/08/2019, 01:36:55 PM
    Author     : jorge.lopez
--%>

<%@page import="Negocios.CategoriasN"%>
<%@page import="Datos.CategoriasD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 

       CategoriasD ca = (CategoriasD)request.getAttribute("idCategorias");
  
       %>
        <table>
         <tr>
               <th>IDCATEOGORIAS</th>
               <th>DESCRIPCION</th>
               <th>DETALLES</th>
         </tr>
         <tr>
         <td><%=ca.getIdCategorias()%></td>
         <td><%=ca.getDescripcion()%></td>
         <td><%=ca.getDetalles() %></td>
         </tr>   
        </table>    
        
        
        
        
        
        
    </body>
</html>
