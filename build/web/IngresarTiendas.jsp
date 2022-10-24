<%-- 
    Document   : IngresarTiendas
    Created on : 12/08/2019, 03:34:06 PM
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
            
        <div id="agrupar">        
    <header id ="cabecera">
        
        <h1>Este es el título Princiapal de la Página Web</h1>
        <p class="titulo3">Este es un parrafo llamado titulo</p>
        <link href="Styles/css.css" rel="stylesheet" type="text/css"/>
    </header>
        <nav id ="menu">
            <ul>
                <li><a  href="index.jsp">Principal</a></li>
              
               <li><a  href="articulos3.jsp">Articulos</a></li>
               <li><a  href="categorias.jsp">Categorias</a></li>
               <li><a  href="tiendas.jsp">Tiendas</a></li>
               <li><a  href="GastosPorCategoria.jsp">Gastos por Categoria</a></li>
            </ul>    
        </nav>         
        
    <section id ="seccion">
        <article>

        
        
        
            <label >INGRESAR TIENDAS</label>
        <form action ="/Gastos/ServIngresarTiendas2" method="POST">
        
       
        
        <label>NOMBRE</label>    <br> 
        <input type ="text" name ="nombre">   <br> 
        
        <label>CIUDAD</label>    <br> 
        <input type ="text" name ="ciudad">   <br> 
        
        <label>COLONIA</label>    <br> 
        <input type ="text" name ="colonia">   <br> 
        
        <label>CALLE</label>    <br> 
        <input type ="text" name ="calle"><br> 
        
        <label>TELEFONO</label>    <br> 
        <input type ="text" name ="telefono">  <br>  
        
        <label>WEB</label>    <br> 
        <input type ="text" name ="web">   <br> <br>
        
        <input type ="submit"><br>
  
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
