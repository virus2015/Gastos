/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.ArticulosD;
import Datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge.lopez
 */
public class ArticulosN {

Conexion con = new Conexion();
Connection conectar = con.conectar();
String sql;
public void Insertar(ArticulosD articulos){
    
    
    try {
        PreparedStatement psmt;
        sql="insert into articulosg(nombre,descripcion,marca,frk_categorias,frk_idtiendas)values(?,?,?,?,?)";        
        psmt = conectar.prepareStatement(sql);
        
        psmt.setString(1,articulos.getNombre());
        psmt.setString(2,articulos.getDescripcion());
        psmt.setString(3,articulos.getMarca());
        psmt.setInt(4, articulos.getIdcategorias());      
   
        psmt.setInt(5, articulos.getIdtiendas());
        
        
        psmt.executeUpdate();
        
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    

}
public void Insertar2(ArticulosD articulos){
    
    
    try {
        PreparedStatement psmt;
        sql="insert into articulosg(nombre,descripcion,marca,frk_categorias,frk_idtiendas)values(?,?,?,?,?)";        
        psmt = conectar.prepareStatement(sql);
        
        psmt.setString(1,articulos.getNombre());
        psmt.setString(2,articulos.getDescripcion());
        psmt.setString(3,articulos.getMarca());
        psmt.setInt(4, articulos.getIdcategorias());      
   
        psmt.setInt(5, articulos.getIdtiendas());
        
        
        psmt.executeUpdate();
        
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    

}
public void Editar(ArticulosD articulos){
  try {
        PreparedStatement psmt;
        sql="update articulosg  set nombre=?,descripcion=?,marca=?,frk_categorias=?,frk_idtiendas=? where idArticulos=?";        
        psmt = conectar.prepareStatement(sql);
        
        psmt.setString(1,articulos.getNombre());
        psmt.setString(2,articulos.getDescripcion());
        psmt.setString(3,articulos.getMarca());
        psmt.setInt(4, articulos.getIdcategorias());  
        psmt.setInt(5, articulos.getIdtiendas());        
        psmt.setInt(6, articulos.getIdArticulos());
        
        psmt.executeUpdate();
        
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    
}
public void Editar2(ArticulosD articulos){
  try {
        PreparedStatement psmt;
        sql="update articulosg  set nombre=?,descripcion=?,marca=?,frk_categorias=?,frk_idtiendas=? where idArticulos=?";        
        psmt = conectar.prepareStatement(sql);
        
        psmt.setString(1,articulos.getNombre());
        psmt.setString(2,articulos.getDescripcion());
        psmt.setString(3,articulos.getMarca());
        psmt.setInt(4, articulos.getIdcategorias());  
        psmt.setInt(5, articulos.getIdtiendas());        
        psmt.setInt(6, articulos.getIdArticulos());
        
        psmt.executeUpdate();
        
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    
}
public void Eliminar(int codigo){
        PreparedStatement psmt;
        sql="delete  articulosg where idArticulos=?";
    
    try {
    
        psmt= conectar.prepareStatement(sql);
        psmt.setInt(1,codigo);
        
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    
    
}

public ArrayList ListarTodos(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"                marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"                  inner join categoriasg c     on  a.frk_categorias= c.idCategorias  WHERE a.FRK_IGGASTOSFIJOS=2 ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}
public ArrayList ListarTodosD(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="  select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"             marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"              inner join categoriasg c   \n" +
"              on  a.frk_categorias= c.idCategorias  WHERE c.frk_idgastosfijos=2    ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}

public ArrayList ListarTodosGF(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="  select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"             marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"              inner join categoriasg c   \n" +
"              on  a.frk_categorias= c.idCategorias  WHERE c.frk_idgastosfijos=1    ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}
public ArrayList ListarTodosGV(){
    ResultSet resultado;
    ArrayList <ArticulosD> articulos = new ArrayList();
    
    try {
        PreparedStatement psmt ;
        sql="  select a.idarticulos as idarticulos, a.NOMBRE as nombre,a.DESCRIPCION as descripcion,a.MARCA as\n" +
"             marca,a.frk_categorias AS idCategorias from articulosg a\n" +
"              inner join categoriasg c   \n" +
"              on  a.frk_categorias= c.idCategorias  WHERE c.frk_idgastosfijos=3    ";
        psmt= conectar.prepareStatement(sql);
        resultado = psmt.executeQuery();
        while(resultado.next()){
            ArticulosD arti = new ArticulosD();
            arti.setIdArticulos(resultado.getInt("idArticulos"));
            arti.setNombre(resultado.getString("nombre"));
            arti.setDescripcion(resultado.getString("descripcion"));
            arti.setMarca(resultado.getString("marca"));
            arti.setIdcategorias(resultado.getInt("idCategorias"));
            articulos.add(arti);
        
        }
        return articulos;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }

    
    
    
}
public ArticulosD ListarUno(int id){
     Statement stm ;
     ResultSet resultado;
     sql="select * from articulosg where idArticulos="+id;   
     ArticulosD arti=null ;
     try {
       
        
             
        stm = conectar.createStatement();
        resultado = stm.executeQuery(sql);
        while(resultado.next()){
       arti = new ArticulosD(resultado.getInt("idArticulos"),resultado.getString("nombre"),resultado.getString("descripcion"),
               resultado.getString("marca"),resultado.getInt("frk_categorias"),resultado.getInt("frk_iggastosfijos"), resultado.getInt("frk_idtiendas")  );
        }
        return arti;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
    }


}

    
    
    
    
    
    
    
    
}
