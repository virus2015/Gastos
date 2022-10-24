<%-- 
    Document   : GastosPorCategoria_re
    Created on : 27/08/2019, 12:44:55 PM
    Author     : jorge.lopez
--%>
<%@page import="Negocios.CategoriasN"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="Negocios.GastosN"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table>
           <tr>  
          <th>DESCRIPCION</th>
          <th>MONTO</th>
          </tr>
                   <% 
               Date fecha1 = Date.valueOf(request.getParameter("fecha1"));
               Date fecha2 = Date.valueOf(request.getParameter("fecha2"));
         
             CategoriasN ca = new CategoriasN();
                 List<String> listado = ca.recuperaCategorias(fecha1, fecha2);
              for(int i =0;i<listado.size();i++){

            %>
            
        
          <tr>  
              <td><%=listado.get(i) %></td>
              <td><% %></td>                        
          <% } 
            
          
          %>     
          </tr>
         </table> 
    </body>
</html>
