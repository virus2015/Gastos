/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author jorge.lopez
 */
public class GastosFijosD {

private int idGastosFijos;
private String descripcion;


public GastosFijosD(){

}
    
public GastosFijosD(int pidGastosFijos, String pdescripcion){
this.idGastosFijos=pidGastosFijos;
this.descripcion= pdescripcion;
}    

    /**
     * @return the idGastosFijos
     */
    public int getIdGastosFijos() {
        return idGastosFijos;
    }

    /**
     * @param idGastosFijos the idGastosFijos to set
     */
    public void setIdGastosFijos(int idGastosFijos) {
        this.idGastosFijos = idGastosFijos;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
