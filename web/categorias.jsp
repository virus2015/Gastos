<%-- 
    Document   : index
    Created on : 6/08/2019, 12:10:33 PM
    Author     : jorge.lopez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datos.CategoriasD"%>
<%@page import="Negocios.CategoriasN"%>
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

        
        
        
            <label >CATEGORIAS</label>
        
        <table id="table">
            <tr>
                <th> ID</th>
                <th>DESCRIPCION</th>
                <th>DETALLES</th>   
                <th>GASTO FIJO</th>   
                <th>ELIMNAR</th>
                <TH>EDITAR</TH>
                        <%   
        
          Conexion con = new Conexion ();
        Connection conectar = con.conectar();
        ResultSet resultado;
        
        String sql ="select g.idcategorias as categorias,g.DESCRIPCION "
                + "as descripcion,g.DETALLES"
                + " as detalles,f.DESCRIPCION as gastofijo from categoriasg2 g inner "
                + "join gastosfijos f on f.IDGASTOSFIJOS= g.frk_idgastos ";
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            
                 
        %>
            </tr>
            
            <tr>
                <td><%=resultado.getString("categorias")%></td>
                <td><%=resultado.getString("descripcion")%></td>
                <td><%=resultado.getString("detalles")%></td>
                <td><%=resultado.getString("gastofijo")%></td>
                <td> <a href="/Gastos/ServElimina?id=<%=resultado.getString("categorias")%>">Elimnar </a>  </td>
                <td> <a href="/Gastos/Editar.jsp?id=<%=resultado.getString("categorias")%>" >Editar </a>  </td>
                
            </tr>
          
                
            
            <% }%> 
            <tr>
                 <td> <a href="/Gastos/Nuevo.jsp">Nuevo </a>  </td>
            </tr>    
             <tr>
                 <td> <a href="/Gastos/Buscar.jsp">Buscar </a>  </td>
            </tr> 
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
