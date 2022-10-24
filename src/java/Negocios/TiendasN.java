/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datos.TiendasD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author jorge.lopez
 */
public class TiendasN {
    
    Conexion con = new Conexion();
    Connection conecta = con.conectar();
    String sql;
    

    public static void main(String[] args) {
         TiendasN ss = new TiendasN();
        
        ss.selecAllTiendas();
    }
    
    public void insertar(TiendasD tienda){
        
        try {
            PreparedStatement ps ;
            sql="insert into tiendasg2(nombre,ciudad,colonia,calle,telefono,web)values(?,?,?,?,?,?)";
            
            ps = conecta.prepareStatement(sql);
            ps.setString(1,tienda.getNombre());
            ps.setString(2,tienda.getCiudad());
            ps.setString(3,tienda.getColonia());
            ps.setString(4,tienda.getCalle());
            ps.setString(5,tienda.getTelefono());
            ps.setString(6,tienda.getWeb());
            
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    
    
    }
    
    public void actualizar(TiendasD tienda){
        
        try {
            PreparedStatement ps ;
            sql="update tiendasg2 set nombre=?,ciudad=?,colonia=?,calle=?,telefono=?,web=? where idTiendas=?  ";
            
            ps = conecta.prepareStatement(sql);
            ps.setString(1,tienda.getNombre());
            ps.setString(2,tienda.getCiudad());
            ps.setString(3,tienda.getColonia());
            ps.setString(4,tienda.getCalle());
            ps.setString(5,tienda.getTelefono());
            ps.setString(6,tienda.getWeb());
            ps.setInt(7, tienda.getIdTiendas());
            
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    
    
    }
    ///////////////////////eliminar tienda///////////////////
    
    public void eliminar(int codigo){
       sql="delete from tiendasg2 where idTiendas=?"; 
      try{
          PreparedStatement ps;
          ps = conecta.prepareStatement(sql);
          ps.setInt(1, codigo);
          ps.executeUpdate();
                  
      
      }catch(SQLException ex){
          
        ex.printStackTrace();
      }
    
    
    }
    
    public ArrayList selecAllTiendas(){
        ResultSet rs;
          sql="  select * from tiendasg2";
        try {
          
            ArrayList <TiendasD> listaTiendas = new ArrayList();
            PreparedStatement st = conecta.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
              TiendasD tienda = new TiendasD();
              tienda.setIdTiendas(rs.getInt("idTiendas"));
              tienda.setNombre(rs.getString("nombre"));
              tienda.setCiudad(rs.getString("ciudad"));
              tienda.setColonia(rs.getString("colonia"));
              tienda.setCalle(rs.getString("calle"));
              tienda.setTelefono(rs.getString("telefono"));
              tienda.setWeb(rs.getString("web"));
            listaTiendas.add(tienda);
            System.out.println(listaTiendas);
            }
            
            return listaTiendas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
           
        }
    
        
        
    }
    public ArrayList selecAllTiendasA1(){
        ResultSet rs;
          sql="  select * from tiendasg2 y\n" +
"where y.idtiendas in (select x.frk_idtiendas from articulosg2 x\n" +
"                              where   x.frk_categorias in (select x.idcategorias from categoriasg2 x where frk_idgastosfijos=1\n" +
"                                                                    ))";
        try {
          
            ArrayList <TiendasD> listaTiendas = new ArrayList();
            PreparedStatement st = conecta.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
              TiendasD tienda = new TiendasD();
              tienda.setIdTiendas(rs.getInt("idTiendas"));
              tienda.setNombre(rs.getString("nombre"));
              tienda.setCiudad(rs.getString("ciudad"));
              tienda.setColonia(rs.getString("colonia"));
              tienda.setCalle(rs.getString("calle"));
              tienda.setTelefono(rs.getString("telefono"));
              tienda.setWeb(rs.getString("web"));
            listaTiendas.add(tienda);
            }
            
            return listaTiendas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
           
        }
    
        
        
    }
     public ArrayList selecAllTiendasA2(){
        ResultSet rs;
          sql="  select * from tiendasg2 y\n" +
"where y.idtiendas in (select x.frk_idtiendas from articulosg2 x\n" +
"                              where   x.frk_categorias in (select x.idcategorias from categoriasg2 x where frk_idgastosfijos=2\n" +
"                                                                    )) ";
        try {
          
            ArrayList <TiendasD> listaTiendas = new ArrayList();
            PreparedStatement st = conecta.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
              TiendasD tienda = new TiendasD();
              tienda.setIdTiendas(rs.getInt("idTiendas"));
              tienda.setNombre(rs.getString("nombre"));
              tienda.setCiudad(rs.getString("ciudad"));
              tienda.setColonia(rs.getString("colonia"));
              tienda.setCalle(rs.getString("calle"));
              tienda.setTelefono(rs.getString("telefono"));
              tienda.setWeb(rs.getString("web"));
            listaTiendas.add(tienda);
            }
            
            return listaTiendas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
           
        }
    
        
        
    }
      public ArrayList selecAllTiendasA3(){
        ResultSet rs;
          sql="   select * from tiendasg2 y\n" +
"where y.idtiendas in (select x.frk_idtiendas from articulosg2 x\n" +
"                              where   x.frk_categorias in (select x.idcategorias from categoriasg2 x where frk_idgastosfijos=3\n" +
"                                                                    )) ";
        try {
          
            ArrayList <TiendasD> listaTiendas = new ArrayList();
            PreparedStatement st = conecta.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
              TiendasD tienda = new TiendasD();
              tienda.setIdTiendas(rs.getInt("idTiendas"));
              tienda.setNombre(rs.getString("nombre"));
              tienda.setCiudad(rs.getString("ciudad"));
              tienda.setColonia(rs.getString("colonia"));
              tienda.setCalle(rs.getString("calle"));
              tienda.setTelefono(rs.getString("telefono"));
              tienda.setWeb(rs.getString("web"));
            listaTiendas.add(tienda);
            }
            
            return listaTiendas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
           
        }
    
        
        
    }
    /////////////listar un solo elemento/////////
    public TiendasD selecOneTienda(int codigo){
        ResultSet rs;
       sql="select * from tiendasg2 where idTiendas="+codigo;
       TiendasD tienda=null;
    
        try {
            Statement ps = conecta.createStatement();
            rs =ps.executeQuery(sql);
            while(rs.next()){
            tienda = new TiendasD(rs.getInt("idTiendas"),rs.getString("nombre"),rs.getString("ciudad"),
                    rs.getString("colonia"),rs.getString("calle"),rs.getString("telefono"),rs.getString("web"));
            
            }       
            return tienda;
        } catch (SQLException ex) {
           ex.printStackTrace();
           return null;
      
    }
    }
}