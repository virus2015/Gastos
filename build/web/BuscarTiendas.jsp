<%-- 
    Document   : BuscarTiendas
    Created on : 13/08/2019, 10:44:12 AM
    Author     : jorge.lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <form action ="ServBuscarTiendas" method="POST">
            
            
         <label>ID TIENDAS</label><br>
         <input type ="text" name ="idTiendas">  <br> <br>
         <input type="submit" name ="enviar">   
            
        </form>
        
        
    </body>
</html>
