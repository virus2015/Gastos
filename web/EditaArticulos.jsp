<%-- 
    Document   : EditaArticulos
    Created on : 14/08/2019, 10:19:56 AM
    Author     : jorge.lopez
--%>

<%@page import="Datos.TiendasD"%>
<%@page import="Negocios.TiendasN"%>
<%@page import="Datos.GastosFijosD"%>
<%@page import="Negocios.GastosfIjosN"%>
<%@page import="Datos.CategoriasD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Negocios.CategoriasN"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
               
        <div id="agrupar">   
        <header id ="cabecera">
        
        <h1>Este es el título Princiapal de la Página Web</h1>
        <p class="titulo3">Este es un parrafo llamado titulo</p>
        
        
        
    </header>
        <nav id ="menu">
            <ul>
                  <li><a  href="index.jsp">Principal</a></li>
                <li><a  href="IngresarGastos.jsp">Ingresar Gastos</a></li>
               <li><a  href="articulos3.jsp">Articulos</a></li>
               <li><a  href="categorias.jsp">Categorias</a></li>
               <li><a  href="tiendas.jsp">Tiendas</a></li>
            </ul>    
        </nav>      
        
    <section id ="seccion">
        <article>
        <%
        int id = Integer.parseInt(request.getParameter("id"));
        
        Conexion con = new Conexion ();
        Connection conectar = con.conectar();
        ResultSet resultado;
        
        String sql ="select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as"
                + " marca,a.frk_categorias AS idCategorias from articulosg a"
                + "   inner join categoriasg c on  a.frk_categorias= c.idCategorias where idArticulos="+id;
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
  
        %>
        
        
       
        <form action ="/Gastos/ServEditarArticulos2" method ="POST">
        <label>ID ARTICULOS</label><BR>    
        <input type ="text" name ="idarticulos" value="<%=resultado.getString("idarticulos") %>"><br>  
        <label>NOMBRE</label><BR>    
        <input type ="text" name ="nombre" value="<%=resultado.getString("nombre") %>"><br>
        <label>DESCRIPCION</label><br>
        <input type ="text" name ="descripcion" value="<%=resultado.getString("descripcion") %>"><br>
        <label>MARCA</label><br>
        <input type ="text" name ="marca" value="<%=resultado.getString("marca") %>"><br><br>
         <label>Seleccione una categoria</label><br>
             <select name ="idCategorias" >
                
                                 <%
                   //CategoriasD cad = new CategoriasD();
                   CategoriasN can = new CategoriasN();
                 ArrayList <CategoriasD> cad = can.consultarTodos();
                   for(int i=0;i<cad.size();i++){
                %>
                    
                <option value="<%=cad.get(i).getIdCategorias() %>"><%=cad.get(i).getDescripcion() %>  </option>
                   <% }%>  
                </select><br><br>
         
          
               
                  <label>Seleccione una tienda</label><br>
             <select name ="idtiendas" >
                
                                 <%
                   //CategoriasD cad = new CategoriasD();
                   TiendasN tin = new TiendasN();
                 ArrayList <TiendasD> tid = tin.selecAllTiendas();
                   for(int i=0;i<tid.size();i++){
                %>
                    
                <option value="<%=tid.get(i).getIdTiendas() %>"><%=tid.get(i).getNombre() %>  </option>
                   <% }%>  
                </select><br><br>
          
        
        <input type ="submit">    
        
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
