/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.ArticulosD;
import Datos.CategoriasD;
import Datos.Conexion;
import Datos.GastosD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge.lopez
 */
public class GastosN {
    
Conexion con = new Conexion();
Connection conectar = con.conectar();
String sql;
    
public void Ingresar(GastosD gastos){
    
        
    try {       
        PreparedStatement psmt ;
         sql="insert into gastosg(FRK_IDARTICULOS,frk_idCategorias,frk_idTiendas,cantidad,fecha,monto)values(?,?,?,?,?,?)";
        psmt = conectar.prepareStatement(sql);
        psmt.setInt(1,gastos.getIdArticulos());
        psmt.setInt(2, gastos.getIdCategorias());
        psmt.setInt(3, gastos.getIdTiendas());
        psmt.setInt(4, gastos.getCantidad());
        psmt.setDate(5, gastos.getFecha());
        psmt.setInt(6, gastos.getMonto());
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
         ex.printStackTrace();
    }
    
}    
    
public void Editar(GastosD gastos){
      try {       
        PreparedStatement psmt ;
         sql="update gastosg set frk_idArticulos=?,frk_idcategorias=?,frk_idtiendas=?, cantidad=?,fecha=? ,monto =? where idGastos=? ";
        psmt = conectar.prepareStatement(sql);
        
        psmt.setInt(1, gastos.getIdArticulos()); 
        psmt.setInt(2, gastos.getIdCategorias()); 
        psmt.setInt(3, gastos.getIdTiendas()); 
        psmt.setInt(4, gastos.getCantidad());        
        psmt.setDate(5, gastos.getFecha());
        psmt.setInt(6, gastos.getMonto());
        psmt.setInt(7,gastos.getIdGastos());
        
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
         ex.printStackTrace();
    } 
    

}
public void Eliminar(int codigo){
    try {
        sql ="delete gastosg where idGastos=?";       
        PreparedStatement psmt ;
        psmt = conectar.prepareStatement(sql);
        psmt.setInt(1, codigo);
        psmt.executeUpdate();        
    } catch (SQLException ex) {
         ex.printStackTrace();
    }
}
public GastosD consultarDostres(String fecha2) {
    try {    
        ResultSet resultado;
        Conexion con = new Conexion();
        Connection conecta = con.conectar();
        GastosD ga=null;
        Statement pr;
        pr= conecta.createStatement();
        
        resultado = pr.executeQuery("select * from gastosg gg where gg.fecha between '01/08/2019' and '"+fecha2+"'");
        
        while(resultado.next()){
            
            ga=  new GastosD(resultado.getInt("IDGASTOS"),resultado.getInt("FRK_IDARTICULOS"),resultado.getInt
        ("FRK_IDCATEGORIAS"),resultado.getInt("FRK_IDTIENDAS"),resultado.getInt("CANTIDAD"), resultado.getDate
        ("FECHA"),resultado.getInt("MONTO"));
            
        }
       
        
        return ga;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }
            
      
     }
public GastosD consultarDostresid(int id) {
    try {    
        ResultSet resultado;
        Conexion con = new Conexion();
        Connection conecta = con.conectar();
        GastosD ga=null;
        Statement pr;
        pr= conecta.createStatement();
        
        resultado = pr.executeQuery("select * from gastosg gg where gg.idgastos= '"+id+"' ");
        
        while(resultado.next()){
            
            ga=  new GastosD(resultado.getInt("IDGASTOS"),resultado.getInt("FRK_IDARTICULOS"),resultado.getInt("FRK_IDCATEGORIAS"),resultado.getInt("FRK_IDTIENDAS"),resultado.getInt("CANTIDAD"), resultado.getDate("FECHA"),resultado.getInt("MONTO"));
            
        }
       
        
        return ga;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }
            
      
     }
public ArrayList SeleccionarTodo(){
    try {
     //   List <String> listado = new ArrayList<String>();
        sql="select gg.IDGASTOS as idGastos,gg.cantidad as cantidad, aa.nombre as producto,aa.DESCRIPCION as descripcion,aa.MARCA as marca,tt.NOMBRE as tienda,\n" +
"tt.CIUDAD as ciudad,tt.COLONIA as colonia,tt.CALLE as calle,tt.TELEFONO as telefono,tt.WEB as web,gg.fecha as fecha from gastosg gg\n" +
"inner join articulosg aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"order by tienda,ciudad";
         ArrayList  listaprincipal = new ArrayList();
        Statement stm;
        ResultSet resultado ;        
        stm = conectar.createStatement();
        resultado = stm.executeQuery(sql);
        
        while(resultado.next()){
             ArrayList  lista = new ArrayList(10);
       int idGastos = resultado.getInt("idGastos");
       int cantidad = resultado.getInt("cantidad");
       String producto = resultado.getString("producto");
       String descripcion= resultado.getString("descripcion");
       String marca= resultado.getString("marca");
       String tienda= resultado.getString("tienda");
       String ciudad= resultado.getString("ciudad");
       String colonia = resultado.getString("colonia");
       String calle=  resultado.getString("calle");
       String telefono = resultado.getString("telefono");
       String web = resultado.getString("web");
       Date fecha= resultado.getDate("fecha");
        
        lista.set(1, idGastos);
        lista.set(2, cantidad);
        lista.set(3, producto);
        lista.set(4, descripcion);
        lista.set(5, marca);
        lista.set(6, tienda);
        lista.set(7, ciudad);
        lista.set(8, colonia);
        lista.set(9, calle);
        lista.set(10, telefono);
        lista.set(11, web);
        lista.set(12, fecha);
        
        listaprincipal.add(lista);
                 }
        return listaprincipal;
        
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }
}
    
    public void SeleccionarTodo2(){
    try {
     //   List <String> listado = new ArrayList<String>();
        sql="select gg.IDGASTOS as idGastos,gg.cantidad as cantidad, aa.nombre as producto,aa.DESCRIPCION as descripcion,aa.MARCA as marca,tt.NOMBRE as tienda,\n" +
"tt.CIUDAD as ciudad,tt.COLONIA as colonia,tt.CALLE as calle,tt.TELEFONO as telefono,tt.WEB as web,gg.fecha as fecha from gastosg gg\n" +
"inner join articulosg aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"order by tienda,ciudad";
        Statement stm;
        ResultSet resultado ;
        
        stm = conectar.createStatement();
        
        
        resultado = stm.executeQuery(sql);
        
        while(resultado.next()){
            
        int idGastos = resultado.getInt("idGastos");
        int cantidad = resultado.getInt("cantidad");
       String producto = resultado.getString("producto");
       String descripcion= resultado.getString("descripcion");
       String marca= resultado.getString("marca");
       String ciudad= resultado.getString("ciudad");
       String colonia = resultado.getString("colonia");
       String calle=  resultado.getString("calle");
       String telefono = resultado.getString("telefono");
       String web = resultado.getString("web");
       Date fecha= resultado.getDate("fecha");
        
        
         
        }
       

        
    } catch (SQLException ex) {
         ex.printStackTrace();
            }
    

}
}
