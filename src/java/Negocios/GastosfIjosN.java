/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.util.ArrayList;
import Datos.Conexion;
import java.sql.Connection;
import Datos.GastosFijosD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge.lopez
 */
public class GastosfIjosN {
    
Conexion co = new Conexion();
Connection conecta = co.conectar();
String sql;    

public void Insertar(GastosFijosD fijo){
    try {
        sql="insert into gastosfijos (descripcion)values(?)";
        
        PreparedStatement psmt ;
        
        psmt = conecta.prepareStatement(sql);
       
        psmt.setString(1, fijo.getDescripcion());
        
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }


    
}    
 
public void Editar(GastosFijosD fijo){
 try {
        sql="update  gastosfijos set descripcion=? where IdGastosFijos=?";
        
        PreparedStatement psmt ;
        
        psmt = conecta.prepareStatement(sql);
       
        psmt.setString(1, fijo.getDescripcion());
         psmt.setInt(2, fijo.getIdGastosFijos());
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
} 
public void Eliminar(int codigo){
try {
        sql="delete  gastosfijos  where IdGastosFijos=?";
        
        PreparedStatement psmt ;
        
        psmt = conecta.prepareStatement(sql);
              
        psmt.setInt(2, codigo);
        psmt.executeUpdate();
        
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
} 
public ArrayList  ListarGastosFijos(){

    try {
        sql="select * from gastosfijos";
        PreparedStatement stm ;
        ResultSet resultado;
        ArrayList <GastosFijosD> liga = new ArrayList();
        
        stm = conecta.prepareStatement(sql);
        resultado = stm.executeQuery();
        while(resultado.next()){
            
        GastosFijosD ga = new GastosFijosD();
        
        ga.setIdGastosFijos(resultado.getInt("idgastosfijos"));
        ga.setDescripcion(resultado.getString("descripcion"));
        liga.add(ga);
        }
        
        return liga;
    } catch (SQLException ex) {
         ex.printStackTrace();
         return null ;
    }
} 
    
    
}
