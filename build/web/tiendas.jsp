<%-- 
    Document   : tiendas
    Created on : 8/08/2019, 05:04:46 PM
    Author     : jorge.lopez
--%>

<%@page import="Datos.TiendasD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Negocios.TiendasN"%>
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

        
        
        
            <label >TIENDAS</label>
        
        
        
     <table id ="mitabla">
         <tr>
             <th>IDTIENDAS</th>
             <th>NOMBRE</th>
             <th>CIUDAD</th>
             <th>COLONIA</th>
             <th>CALLE</th>
             <th>TELEFONO</th>
             <th>WEB</th>
             <th>ELIMINAR </th>
             <th>EDITAR</th>     
                      
           <%
           TiendasN ti = new TiendasN();   
           ArrayList <TiendasD> tienda = ti.selecAllTiendas();
           
         for (int i =0;i<tienda.size();i++){
           %>
             
         </tr>
         <tr>
             <td> <%=tienda.get(i).getIdTiendas() %> </td>
             <td> <%=tienda.get(i).getNombre() %> </td>
             <td> <%=tienda.get(i).getCiudad() %> </td>
             <td><%=tienda.get(i).getColonia() %>  </td>
             <td><%=tienda.get(i).getCalle() %>  </td>
             <td><%=tienda.get(i).getTelefono() %> </td>
             <td><%=tienda.get(i).getWeb() %> </td>
             <td><a href="/Gastos/ServEliminaTiendas?id=<%=tienda.get(i).getIdTiendas() %>"> Eliminar</a> </td>
             <td><a href="/Gastos/EditarTiendas.jsp?id=<%=tienda.get(i).getIdTiendas() %>"> Editar</a> </td>
           
         </tr>
          <% }%>
         <tr>
        <td> <a href="IngresarTiendas.jsp">Ingresar </a></td> 
        <td> <a href="BuscarTiendas.jsp">Buscar </a></td> 
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
