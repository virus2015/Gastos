<%-- 
    Document   : Gastos
    Created on : 15/08/2019, 01:59:48 PM
    Author     : jorge.lopez
--%>

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
               <li><a  href="index.jsp">Gastos Diarios</a></li>
                 <li><a  href="GastosFijos.jsp">Gastos Fijos</a></li>
                  <li><a  href="GastosVariables.jsp">Gastos Varios</a></li>                
               <li><a  href="articulos3.jsp">Articulos</a></li>
               <li><a  href="categorias.jsp">Categorias</a></li>
               <li><a  href="tiendas.jsp">Tiendas</a></li>
               <li><a  href="GastosPorCategoria.jsp">Gastos por Categoria</a></li>
            </ul>    
        </nav>      
        
    <section id ="seccion">
        <article>
            <label>Articulos</label>
            <table id ="tabled" >
               <tr>
               <th>ID ARTICULOS</th>
               <th>NOMBRE</th>
               <th>DESCRIPCION</th>
               <th>MARCA</th>
                <th>CATEGORIAS</th>
                <th>TIPO GASTO</th>
                <th>TIENDA</th>
               <th>ELIMINAR</th>
               <th>EDITAR</th>
               
               
                <%   
          Conexion con = new Conexion ();
        Connection conectar = con.conectar();
        ResultSet resultado;
        
        String sql ="  select a.idarticulos as id, a.NOMBRE as nombre,a.DESCRIPCION as "
                + "descripcion,a.MARCA as marca ,g.DESCRIPCION as categoria,g.frk_idgastos as"
                + " gastofijo,t.nombre as tienda from articulosg2 a      inner join categoriasg2 g    "
                + "   on  g.idCategorias= a.frk_idcategorias   inner join tiendasg2 t      on t.idtiendas = g.frk_idtiendas  ";
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            
        
       
        %>
               
               </tr>
               <tr>
               <td><%=resultado.getString("id")  %></td>  
               <td><%=resultado.getString("nombre")  %></td>   
               <td><%=resultado.getString("descripcion")  %></td> 
               <td><%=resultado.getString("marca")  %></td> 
               <td><%=resultado.getString("categoria")  %></td> 
               <td><%=resultado.getString("gastofijo")  %></td> 
               <td><%=resultado.getString("tienda")  %></td> 
               <td><a href="/Gastos/ServEliminaArticulos2?id=<%=resultado.getString("id")  %>">Eliminar </a></td>  
               <td><a href="/Gastos/EditaArticulos.jsp?id=<%=resultado.getString("id")  %>">Editar </a></td>     
               
                  
               
               </tr> 
               <tr>
             
               </tr>    
                  <% } %>
               <td><a href="IngresarArticulos.jsp">Ingresar </a>  </td>
               <td><a href="/Gastos/BuscarArticulos.jsp">Buscar </a>  </td>
            </table>   

        
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
