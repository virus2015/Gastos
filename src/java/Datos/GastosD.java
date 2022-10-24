/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author jorge.lopez
 */
public class GastosD {
    
private int idGastos;    
private int idArticulos;  
private int idCategorias;  
private int idTiendas;  
private int cantidad;
private Date fecha;
private int monto;
    
public GastosD(){


}    

public GastosD(int pidGastos,int pidArticulos,int pidCategorias ,int pidTiendas,int pcantidad,Date pfecha,int pmonto){
this.idGastos=pidGastos;
this.idArticulos=pidArticulos;
this.idCategorias=pidCategorias;
this.idTiendas=pidTiendas;
this.cantidad=pcantidad;
this.fecha=pfecha;
this.monto=pmonto;
} 

    /**
     * @return the idGastos
     */
    public int getIdGastos() {
        return idGastos;
    }

    /**
     * @param idGastos the idGastos to set
     */
    public void setIdGastos(int idGastos) {
        this.idGastos = idGastos;
    }

    /**
     * @return the idArticulos
     */
    public int getIdArticulos() {
        return idArticulos;
    }

    /**
     * @param idArticulos the idArticulos to set
     */
    public void setIdArticulos(int idArticulos) {
        this.idArticulos = idArticulos;
    }

    /**
     * @return the idCategorias
     */
    public int getIdCategorias() {
        return idCategorias;
    }

    /**
     * @param idCategorias the idCategorias to set
     */
    public void setIdCategorias(int idCategorias) {
        this.idCategorias = idCategorias;
    }

    /**
     * @return the idTiendas
     */
    public int getIdTiendas() {
        return idTiendas;
    }

    /**
     * @param idTiendas the idTiendas to set
     */
    public void setIdTiendas(int idTiendas) {
        this.idTiendas = idTiendas;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }














    
}
