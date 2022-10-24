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
public class TiendasD {
    
   private int idTiendas ;
   private String nombre;
   private String ciudad;
   private String colonia;
   private String calle;
   private String telefono;
   private String web;
   
   public TiendasD(){
   
   }
   public TiendasD(int pidTiendas,String pnombre,String pciudad,String pcolonia,String pcalle,String ptelefono,String pweb){
   this.idTiendas=pidTiendas;
   this.nombre=pnombre;
   this.ciudad=pciudad;
   this.colonia=pcolonia;
   this.calle=pcalle;
   this.telefono=ptelefono;
   this.web=pweb;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }
   
   
    
    
    
}
