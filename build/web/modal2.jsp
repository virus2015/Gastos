<%-- 
    Document   : modal
    Created on : 16/08/2019, 04:44:30 PM
    Author     : jorge.lopez
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="Styles/css.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        
        
        
        
   <div id="openModal" class="modalDialog">
    
    
    
    
	<div>
            
		<a href="#close" title="Close" class="close"></a>
		
                   
                              
             
                <% 
                   int id = Integer.parseInt(request.getParameter("id"));
        
        Conexion con = new Conexion ();
        Connection conectar = con.conectar();
        ResultSet resultado;
        
        String sql ="select * from articulosg where idArticulos="+id;
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
                     
                     
                 
                %>
                
              
                <form action ="/Gastos/IngresarGastos" method ="POST">
                <label>Articulos</label><br>
                <input type="text" name ="id" value="<%=resultado.getString("idArticulos") %>" ><br>
                
                <label>Nombre</label><br>
                <input type="text" name ="nombre" value="<%=resultado.getString("nombre") %>" ><br>
                
                <label>Descripcion</label><br>
                <input type="text" name ="descripcion"  value="<%=resultado.getString("descripcion") %>"><br>

                <label>Marca</label><br>
                <input type="text" name ="marca" value="<%=resultado.getString("marca") %>" ><br><br>
                <%}%>
                <input type = "submit" value="aceptar">
                </form>    
                
                
	</div>
</div>
    </body>
</html>
