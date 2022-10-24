<%-- 
    Document   : IngresarArticulos
    Created on : 14/08/2019, 11:45:08 AM
    Author     : jorge.lopez
--%>

<%@page import="Datos.GastosFijosD"%>
<%@page import="Datos.TiendasD"%>
<%@page import="Negocios.TiendasN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Datos.CategoriasD"%>
<%@page import="Negocios.CategoriasN"%>
<%@page import ="Negocios.GastosfIjosN"%>
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

        
        
        
       <form action ="/Gastos/ServIngresaArticulos" method="POST" >
           
            <label>NOMBRE</label><BR>    
        <input type ="text" name ="nombre" ><br>
        <label>DESCRIPCION</label><br>
        <input type ="text" name ="descripcion" ><br>
        <label>MARCA</label><br>
        <input type ="text" name ="marca" ><br><br>
           
        <label>Seleccione una categoria</label><br>
             <select name ="idCategorias" >
                 
                  
                <%
                   //CategoriasD cad = new CategoriasD();
                   CategoriasN can = new CategoriasN();
                               
                 ArrayList <CategoriasD> cad = can.consultarTodos();
                   for(int i=0;i<cad.size();i++){
                   
                   
                   
                %>
                    
                    <option value="<%=cad.get(i).getIdCategorias() %>"><%=cad.get(i).getDescripcion() %>   </option>
                   <% }%>  
                </select><br><br>   
         
             <label>Seleccione una tienda</label><br>
             <select name ="idtienda" >
                 
                 
                <%
                   //CategoriasD cad = new CategoriasD();
                   TiendasN ti = new TiendasN();
                               
                 ArrayList <TiendasD> tid = ti.selecAllTiendas();
                   for(int i=0;i<tid.size();i++){
                   
                   
                   
                %>
                    
                    <option value="<%=tid.get(i).getIdTiendas() %>"><%=tid.get(i).getNombre() %>   </option>
                   <% }%>  
                </select><br><br>
        
        <input type ="submit">    
        
    
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
