<%-- 
    Document   : MostrarGastosFecha2
    Created on : 28/08/2019, 01:03:54 PM
    Author     : jorge.lopez
--%>

<%@page import="Datos.GastosD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          
         <% 

       GastosD ca = (GastosD)request.getAttribute("fecha");
  
       %>
        <table>
         <tr>
               <th>IDCATEOGORIAS</th>
               <th>DESCRIPCION</th>
               <th>DETALLES</th>
         </tr>
         <tr>
         <td><%=ca.getIdCategorias()%></td>
         <td><%=ca.getFecha() %></td>
         <td><%=ca.getMonto() %></td>
         </tr>   
        </table>    
        
       
    </body>
</html>
