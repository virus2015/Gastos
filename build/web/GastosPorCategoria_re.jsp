<%-- 
    Document   : GastosPorCategoria_re
    Created on : 27/08/2019, 12:44:55 PM
    Author     : jorge.lopez
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Date"%>
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
    </head>
    <body>
         <table>
           <tr>  
          <th>DESCRIPCION</th>
          <th>MONTO</th>
          </tr>
                   <% 
               Date fecha1 = Date.valueOf(request.getParameter("fecha1"));
               Date fecha2 = Date.valueOf(request.getParameter("fecha2"));
               
         Conexion cn = new Conexion();
                Connection conect =cn.conectar();
                PreparedStatement psmt ;
              // List<String> listado = new ArrayList<String>();
            String sql ="select cg.descripcion,sum(gg.monto) as monto from gastosg gg\n" +
"inner join articulosg aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"\n" +
"\n" +
"where gg.fecha between '"+fecha1+"' and '"+fecha2+"' and gg.monto is not null\n" +
"group by cg.descripcion order by cg.descripcion";
                    
                  
            
              try {
                  psmt = conect.prepareStatement(sql);
                  
                  ResultSet rs = psmt.executeQuery();
                     while(rs.next()){
                         psmt.setString(1, rs.getString("descripcion"));
                         psmt.setString(2, rs.getString("monto"));
            %>
            
        
          <tr>  
              <td><%=rs.getString("descripcion")%></td>
              <td></td>                        
          <% } 
            }catch(SQLException ex){
              ex.printStackTrace();
}        
          
          %>     
          </tr>
         </table> 
    </body>
</html>
