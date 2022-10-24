<%-- 
    Document   : Gastos
    Created on : 15/08/2019, 01:59:48 PM
    Author     : jorge.lopez
--%>

<%@page import="java.util.Calendar"%>
<%@page import="Datos.ArticulosD"%>
<%@page import="Negocios.ArticulosN"%>
<%@page import="Negocios.TiendasN"%>
<%@page import="Datos.TiendasD"%>
<%@page import="Negocios.CategoriasN"%>
<%@page import="Datos.CategoriasD"%>
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
        Conexion con = new Conexion ();
        Connection conectar = con.conectar();
         int id = Integer.parseInt(request.getParameter("id"));
        
        ResultSet resultado;
        
        String sql ="select * from gastosg where idgastos="+id;
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
                
                
                
                %>
          
            <form action ="ServEditarGastos2" method ="POST">
                <fieldset>
                   
             <legend>Gastos </legend>
              <label>id gastos </label><br>
           <input type ="text" name ="idgastos" value="<%=resultado.getString("idgastos")%>"><br>
 
                       
              <label>Seleccione una categoria</label><br>
             <select name ="idCategorias" >
                 
                 
                                 <%
                   //CategoriasD cad = new CategoriasD();
                   CategoriasN can = new CategoriasN();
                               
                 ArrayList <CategoriasD> cad = can.consultarTodosGF();
                   for(int i=0;i<cad.size();i++){
                   
                   
                   
                %>
                    
                    <option value="<%=cad.get(i).getIdCategorias() %>"><%=cad.get(i).getDescripcion() %>   </option>
                   <% }%>  
                </select><br>
                
                
                   <label>Seleccione un Articulo</label><br>
             <select name ="idArticulos" >
                 
                <%
                   //CategoriasD cad = new CategoriasD();
                   ArticulosN ar = new ArticulosN();
                               
                 ArrayList <ArticulosD> ard = ar.ListarTodosGF();
                   for(int i=0;i<ard.size();i++){
                %>
                    
                    <option value="<%=ard.get(i).getIdArticulos() %>">  <%=ard.get(i).getNombre() %>  <%=ard.get(i).getDescripcion() %></option>
                    
                   <% }%>  
                </select><br>
                <label   >Seleccione una tienda</label><br>
                <select name="idTiendas" >
                    
                    
                    <% 
                       TiendasN tin = new TiendasN(); 
                    ArrayList <TiendasD> ti = tin.selecAllTiendas();
                         for(int i2=0;i2<ti.size();i2++){
                         
                                             

                    %>
                    
                    <option value ="<%=ti.get(i2).getIdTiendas() %>"> <%=ti.get(i2).getNombre() %>   </option>
                 
                    <%}%>
                    
                </select><br>

                <label>Cantidad </label><br>
                
                
                <input type ="number" name ="cantidad" min ="1" max ="20" value="<%=resultado.getString("cantidad")%>"><br>
                
                <label>Monto </label><br>
                
                
                <input type ="number" name ="monto" value="<%=resultado.getString("monto")%>" ><br>
                

                                <%
// Quiero la fecha actual para ponerla por defecto 
Calendar ahora = Calendar.getInstance();
int anyo = ahora.get(Calendar.YEAR);
int mes = ahora.get(Calendar.MONTH) +1; 
int dia = ahora.get(Calendar.DAY_OF_MONTH);
String sAhora = "";
if (mes < 10) {
sAhora = anyo + "-0" + mes;
} else {
sAhora = anyo + "-" + mes;
}
if (dia < 10) {
sAhora += "-0" + dia;
} else {
sAhora += "-"+dia;
} 
%>
                
                <label>Fecha </label><br>
                <input type ="date" name ="fecha" value="<%=sAhora%>"><br>
                <%}%>
                <input type ="submit">
                
                </fieldset>
                
                
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