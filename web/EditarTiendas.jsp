<%-- 
    Document   : EditarGastos
    Created on : 12/08/2019, 11:42:56 AM
    Author     : jorge.lopez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Negocios.TiendasN"%>
<%@page import="Datos.TiendasD"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
             <div id="agrupar">        
    <header id ="cabecera">
        
        <h1>Este es el título Princiapal de la Página Web</h1>
        <p class="titulo3">Este es un parrafo llamado titulo</p>
        <link href="Styles/css.css" rel="stylesheet" type="text/css"/>
        
    </header>
        <nav id ="menu">
            <ul>
                <li><a  href="index.jsp">Principal</a></li>
                <li><a  href="IngresarGastos.jsp">Ingresar Gastos</a></li>
               <li><a  href="articulos3.jsp">Articulos</a></li>
               <li><a  href="categorias.jsp">Categorias</a></li>
               <li><a  href="tiendas.jsp">Tiendas</a></li>
               <li><a  href="GastosPorCategoria.jsp">Gastos por Categoria</a></li>
            </ul>    
        </nav>         
        
    <section id ="seccion">
        <article>

        
        
       <%
       
      int id = Integer.parseInt(request.getParameter("id"));
           
       Conexion con = new Conexion();
       Connection conecta = con.conectar();
       
       
       String sql="select * from tiendasg where idTiendas="+id;
       PreparedStatement prep = conecta.prepareStatement(sql);
       ResultSet resultado = prep.executeQuery();
       
       while(resultado.next()){
       
          

       %>
        
        <form action ="/Gastos/ServEditarTiendas2" method ="POST" >
            <label>ID TIENDAS</label><br>
            <input type = "text" name ="idTiendas"  value="<%=resultado.getString("idTiendas") %>"><br>
            
            <label>NOMBRE</label><br>
            <input type = "text" name ="nombre" value="<%=resultado.getString("nombre") %>"  ><br>
            
            <label>CIUDAD</label><br>
            <input type = "text" name ="ciudad" value="<%=resultado.getString("ciudad") %>"   ><br>
            
            <label>COLONIA</label><br>
            <input type = "text" name ="colonia" value="<%=resultado.getString("colonia") %>"  ><br>
            
            <label>CALLE</label><br>
            <input type = "text" name ="calle" value="<%=resultado.getString("calle") %>" ><br>
            
            <label>TELEFONO</label><br>
            <input type = "text" name ="telefono" value="<%=resultado.getString("telefono") %>" ><br>
            
            <label>WEB</label><br>
            <input type = "text" name ="web" value="<%=resultado.getString("web") %>" ><br>
            <input type = "submit"><br>
              <%}%>          
        </form>
            
        
            
        
        
         </article>
        
      
    </section>
        
   
         <div id="agrupar2">      
             <h1> Nuestra direccion es</h1>
             <img src="imagenes/coca_cola3.jpg">
         </div>    
            <footer id="pie">
                <small> Derechos Reservados por el profe S.A DE C.V</small>
               <span>Amo la película <cite>Tentaciones</cite></span>
            </footer>
    </div>
        
    </body>
</html>
