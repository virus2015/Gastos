<%-- 
    Document   : Editar
    Created on : 6/08/2019, 02:08:05 PM
    Author     : jorge.lopez
--%>

<%@page import="Datos.GastosFijosD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Negocios.GastosfIjosN"%>
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
               <li><a  href="GastosPorCategoria.jsp">Gastos por Categoria</a></li>
            </ul>    
        </nav>         
        
    <section id ="seccion">
        <article>

        
       
        <%
        Conexion con = new Conexion();
        Connection conecta = con.conectar();
         
        int id = Integer.parseInt(request.getParameter("id"));
        String  sql="select * from categoriasg where idCategorias ="+id;
        PreparedStatement ps =  conecta.prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        while(resultado.next()){
        

        
        
        
        %>
        
        <form action ="/Gastos/ServEditar" method ="POST" >
         
              <select name ="idgasto" >
                 
                 
                <%
                   //CategoriasD cad = new CategoriasD();
                   GastosfIjosN gt = new GastosfIjosN();
                               
                 ArrayList <GastosFijosD> gg = gt.ListarGastosFijos();
                   for(int i=0;i<gg.size();i++){
                   
                   
                   
                %>
                    
                    <option value="<%=gg.get(i).getIdGastosFijos() %>"><%=gg.get(i).getIdGastosFijos() %> <%=gg.get(i).getDescripcion() %>   </option>
                   <% }%>  
                </select><br><br>    
            
            
        <label>IDCATEGORIAS</label><br>
        <input type ="text" name ="idCategorias"  value="<%=resultado.getString("idCategorias") %>"><br>
        <label>DESCRIPCION</label><br>
        <input type ="text" name ="descripcion" id ="descripcion" value="<%=resultado.getString("descripcion") %>"><br>
        <label>DETALLES</label><br>
        <input type ="text" name ="detalles" id ="detalles" value="<%=resultado.getString("detalles") %>"><br>
        <input type="submit" name ="editar">   <br><br>
            
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
