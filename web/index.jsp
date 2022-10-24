<%-- 
    Document   : Gastos
    Created on : 15/08/2019, 01:59:48 PM
    Author     : jorge.lopez
--%>

<%@page import="java.util.Calendar"%>
<%@page import="Datos.TiendasD"%>
<%@page import="Negocios.TiendasN"%>
<%@page import="Datos.ArticulosD"%>
<%@page import="Negocios.ArticulosN"%>
<%@page import="Datos.CategoriasD"%>
<%@page import="Negocios.CategoriasN"%>
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
        
        <link href="Styles/mod.css" rel="stylesheet" type="text/css"/>
        
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
            
          
 
            <form action ="/Gastos/ServInsertarGastos" method ="POST">
                <fieldset>
                   
             <legend>Gastos </legend>
             
                       
              <label>Seleccione una categoria</label><br>
             <select name ="idCategorias" >
                 
                 
                                 <%
                   //CategoriasD cad = new CategoriasD();
                   CategoriasN can = new CategoriasN();
                               
                 ArrayList <CategoriasD> cad = can.consultarTodosG();
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
                               
                 ArrayList <ArticulosD> ard = ar.ListarTodosD();
                   for(int i=0;i<ard.size();i++){
                %>
                    
                    <option value="<%=ard.get(i).getIdArticulos() %>">  <%=ard.get(i).getNombre() %>  <%=ard.get(i).getDescripcion() %></option>
                    
                   <% }%>  
                </select><br>
                <label   >Seleccione una tienda</label><br>
                <select name="idTiendas" >
                    
                    
                    <% 
                       TiendasN tin = new TiendasN(); 
                    ArrayList <TiendasD> ti = tin.selecAllTiendasA2();
                         for(int i2=0;i2<ti.size();i2++){
                         
                                             

                    %>
                    
                    <option value ="<%=ti.get(i2).getIdTiendas() %>"> <%=ti.get(i2).getNombre() %>   </option>
                 
                    <%}%>
                    
                </select><br>
                
                <label>Cantidad </label><br>
                
                
                <input type ="number" name ="cantidad" min ="1" max ="20" ><br>
                
                <label>Monto </label><br>
                
                
                <input type ="number" name ="monto"  ><br>
                
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
                
                <input type ="submit">
                
                </fieldset>
                
                
            </form>
     
          
        
        </article>
        
        <article>
       <fieldset>
         <table >
           <tr>  
          <th>ID</th>
        <th>CANTIDAD</th>
        <th>PRODUCTO</th>
          <th>DESCRIPCION</th>
          <th>MONTO</th>
          <th>MARCA</th>
          <th>TIENDA</th>  
          <th>CATEGORIA</th> 
          <th>FECHA</th>
          <th>ELIMINAR</th>
          <th>EDITAR</th>
          
          
          
          </tr>
               <%
                  
        Conexion con = new Conexion ();
        Connection conectar = con.conectar();
        ResultSet resultado;
        int monto=0;
        String sql =" select gg.IDGASTOS as id,gg.cantidad as cantidad, "
                + "aa.nombre as producto,aa.DESCRIPCION as   descripcion,gg.monto as monto,"
                + " aa.MARCA as marca,tt.NOMBRE as tienda,cg.descripcion as categoria,gg.fecha as fecha  "
                + " from gastosg gg  inner join articulosg aa   on aa.idarticulos = gg.frk_idarticulos  "
                + "    inner join categoriasg cg     on cg.idcategorias= gg.frk_idcategorias  "
                + "   inner join tiendasg tt         on tt.idTiendas = gg.frk_idTiendas   "
                + " where gg.fecha= to_char(sysdate,'DD-MM-YY')  AND cg.frk_idgastosfijos=2  "; 
        PreparedStatement psmt = conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            
               
                %>
          
          <tr>  
              <td><%=resultado.getString("id")  %></td>
              <td><%=resultado.getString("cantidad")  %></td>
               <td><%=resultado.getString("producto")  %></td>
                <td><%=resultado.getString("descripcion")  %></td>
                <td><%=resultado.getString("monto")  %></td>
                 <td><%=resultado.getString("marca")  %></td>
                 <td><%=resultado.getString("tienda")  %></td>  
                 <td><%=resultado.getString("categoria")  %></td>  
                    <td><%=resultado.getDate("fecha")  %></td>
                    <td><A href="/Gastos/ServEliminarGastos?id=<%=resultado.getString("id") %>">ELIMINAR</A></td>
                    <td><A href="EditarGastos.jsp?id=<%=resultado.getString("id")  %>">EDITAR</A></td>
                    
                    
                    
          </tr>
            
            <% 
                
               }
            %>
            
               <%
                  
        Conexion con2 = new Conexion ();
        Connection conectar2 = con2.conectar();
        ResultSet resultado2;
      
        String sql2 ="select sum(gg.monto) as monto from gastosg gg"
                + " inner join articulosg aa"
                + " on aa.idarticulos = gg.frk_idarticulos"
                + " inner join categoriasg cg"
                + " on cg.idcategorias= gg.frk_idcategorias  "
                + "inner join tiendasg tt  "
                + "on tt.idTiendas = gg.frk_idTiendas "
                + " where gg.fecha= to_char(sysdate,'DD-MM-YY') AND cg.frk_idgastosfijos=2   ";
        PreparedStatement psmt2 = conectar2.prepareStatement(sql2);
        resultado2 = psmt2.executeQuery();
        while(resultado2.next()){
            
               
                %>
            
            <tr>
                <td> TOTAL $ <%=resultado2.getString("monto") %>   </td>
           </tr> 
            <%}%>
         </table>   
         </fieldset>
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
