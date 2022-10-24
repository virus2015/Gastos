/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.Conexion;
import Datos.CategoriasD;
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
public class CategoriasN {
    
    Conexion con = new Conexion();
    Connection conecta = con.conectar();
    String sql ;
            
    
    
    
    public void guardar(CategoriasD cate){
    
    sql="insert into categoriasg2(descripcion,detalles,frk_idgastosfijos)values(?,?,?)";     
    try{
    PreparedStatement pr = conecta.prepareStatement(sql);
    pr.setString(1,cate.getDescripcion());
    pr.setString(2,cate.getDetalles());
    pr.setInt(3,cate.getIdgastosfijos());
    
     pr.executeUpdate();
    
    
    }catch(SQLException ex){
      ex.printStackTrace();
    }
     
        
    }
    
    public void actualizar(CategoriasD cate) throws SQLException{
    
    sql=" update  categoriasg2  set descripcion=?,detalles=?,frk_idGastosFijos=? where idCategorias=?";     
  
    PreparedStatement pr = conecta.prepareStatement(sql);
    pr.setString(1,cate.getDescripcion());
    pr.setString(2,cate.getDetalles());
    pr.setInt(3,cate.getIdgastosfijos());
    
    pr.setInt(4, cate.getIdCategorias());
    
     pr.executeUpdate();
    
    
     
        
    }
    
     public void eliminar(int id) throws SQLException{
    
    sql=" delete  categoriasg2   where idCategorias=?";   
    PreparedStatement pr = conecta.prepareStatement(sql);
    pr.setInt(1,id );
    
     pr.executeUpdate();
    
    
     
        
    }
     public  ArrayList consultarTodos(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select * from categoriasg2 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
               cn.setDetalles(resultado.getString("detalles"));
               cn.setIdgastosfijos(resultado.getInt("frk_idgastosfijos"));
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     } public  ArrayList consultarTodosrt(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList <CategoriasD> lista = new ArrayList();
            String sql="select idCategorias,descripcion from categoriasg2 ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
                CategoriasD cn = new CategoriasD();
               cn.setIdCategorias(resultado.getInt("idCategorias"));
               cn.setDescripcion(resultado.getString("descripcion"));
              
               lista.add(cn);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     public  ArrayList consultarTodosG(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList  lista = new ArrayList();
            String sql=" select a2.idcategorias,a2.descripcion,a2.detalles from categoriasg2 a2\n" +
"                  where a2.FRK_IDGASTOSFIJOS=2     ";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
            CategoriasD cate = new CategoriasD();
            cate.setIdCategorias(resultado.getInt("idCategorias"));
            cate.setDescripcion(resultado.getString("descripcion"));
            cate.setDetalles(resultado.getString("detalles"));
            
            lista.add(cate);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     
      public  ArrayList consultarTodosGF(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList  lista = new ArrayList();
            String sql="  select a2.idcategorias,a2.descripcion,a2.detalles from categoriasg2 a2\n" +
"                  where a2.FRK_IDGASTOSFIJOS=1";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
            CategoriasD cate = new CategoriasD();
            cate.setIdCategorias(resultado.getInt("idCategorias"));
            cate.setDescripcion(resultado.getString("descripcion"));
            cate.setDetalles(resultado.getString("detalles"));
            lista.add(cate);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
       public  ArrayList consultarTodosGFV(){
     ResultSet resultado;    
   
     Conexion con = new Conexion();
       Connection conecta = con.conectar();
        try {
            ArrayList  lista = new ArrayList();
            String sql="     select a2.idcategorias,a2.descripcion,a2.detalles from categoriasg2 a2\n" +
"                  where a2.FRK_IDGASTOSFIJOS=3";
            
            PreparedStatement pr;
            pr= conecta.prepareStatement(sql);
            
            resultado = pr.executeQuery();
            while(resultado.next()){
            CategoriasD cate = new CategoriasD();
            cate.setIdCategorias(resultado.getInt("idCategorias"));
            cate.setDescripcion(resultado.getString("descripcion"));
            cate.setDetalles(resultado.getString("detalles"));
            lista.add(cate);
                
            } 
           return lista; 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
     public static CategoriasD consultarUno(int id) throws SQLException{
     ResultSet resultado;    
   
        Conexion con = new Conexion();
        Connection conecta = con.conectar();
         CategoriasD cate=null;
                        
            
          Statement pr;
          pr= conecta.createStatement();
          
          resultado = pr.executeQuery("SELECT * from categoriasg2 where idCategorias='"+id+"'");
            
            
            while(resultado.next()){
           
           cate=  new CategoriasD(resultado.getInt("idCategorias"),resultado.getString("descripcion"),resultado.getString("detalles"),resultado.getInt("frk_idGastosfijos") );
      
          
                
            } 
            resultado.close();
           
           return cate;
            
      
     }

    public void ListarUno(Date fecha1,Date fecha2){
     Statement stm ;
     ResultSet resultado;
     sql="select cg.descripcion,sum(gg.monto) as monto from gastosg2 gg\n" +
"inner join articulosg2 aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg2 cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg2 tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"\n" +
"\n" +
"where gg.fecha between '"+fecha1+"' and '"+fecha2+"' and gg.monto is not null\n" +
"group by cg.descripcion order by cg.descripcion";   
    
     try {
       
        
             
        stm = conecta.createStatement();
        resultado = stm.executeQuery(sql);
        
        while(resultado.next()){
         resultado.getString("descripcion");
          resultado.getString("monto");
        }
       
    } catch (SQLException ex) {
         ex.printStackTrace();
         
    }


}
    
    
    public void recuperaCategorias(Date fecha1,Date fecha2)
    {      
    
                Conexion cn = new Conexion();
                Connection conect =cn.conectar();
                PreparedStatement psmt ;
              // List<String> listado = new ArrayList<String>();
            String sql ="select cg.descripcion,sum(gg.monto) as monto from gastosg2 gg\n" +
"inner join articulosg2 aa\n" +
"on aa.idarticulos = gg.frk_idarticulos\n" +
"inner join categoriasg2 cg\n" +
"on cg.idcategorias= gg.frk_idcategorias \n" +
"inner join tiendasg2 tt\n" +
"on tt.idTiendas = gg.frk_idTiendas\n" +
"\n" +
"\n" +
"where gg.fecha between '"+fecha1+"' and '"+fecha2+"' and gg.monto is not null\n" +
"group by cg.descripcion order by cg.descripcion";
                    
                  
            
              try {
                  psmt = conect.prepareStatement(sql);
                  
                  ResultSet rs = psmt.executeQuery(sql);
                     while(rs.next()){
                         
                        psmt.setString(1, rs.getString("descripcion"));
                         psmt.setString(2, rs.getString("monto"));
                         
                     }
                  
                  
              } catch (SQLException ex) {
                 ex.printStackTrace();
               
              }

          }
    
    }
    
