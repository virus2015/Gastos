/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge.lopez
 */
public class Conexion {
    private String user="georgie";
    private String password= "2685594871";
    private String url="jdbc:oracle:thin:@192.168.0.81:1580:ORCL";
    
    
   
    public Connection conectar(){
        Connection con = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
       con = DriverManager.getConnection(this.url,this.user,this.password);
    
    }catch(ClassNotFoundException | SQLException e){
     JOptionPane.showConfirmDialog(null, e);
    }
   return con;


      }
    
}
