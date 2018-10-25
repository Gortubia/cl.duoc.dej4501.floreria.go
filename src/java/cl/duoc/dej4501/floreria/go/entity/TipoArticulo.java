/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.entity;

import java.io.Serializable;

/**
 *
 * @author adolf
 */
public class TipoArticulo implements Serializable{
    private int id_tipoArticulo;
    private String descrip_tipoArticulo;

    public TipoArticulo() {
    }

    public TipoArticulo(int id_tipoArticulo, String descrip_tipoArticulo) {
        this.id_tipoArticulo = id_tipoArticulo;
        this.descrip_tipoArticulo = descrip_tipoArticulo;
    }

    public TipoArticulo(String descrip_tipoArticulo) {
        this.descrip_tipoArticulo = descrip_tipoArticulo;
    }
    
    
 
    public int getId_tipoArticulo() {
        return id_tipoArticulo;
    }

    public void setId_tipoArticulo(int id_tipoArticulo) {
        this.id_tipoArticulo = id_tipoArticulo;
    }

    public String getDescrip_tipoArticulo() {
        return descrip_tipoArticulo;
    }

    public void setDescrip_tipoArticulo(String descrip_tipoArticulo) {
        this.descrip_tipoArticulo = descrip_tipoArticulo;
    }

    @Override
    public String toString() {
        return "TipoArticulo{" + "id_tipoArticulo=" + id_tipoArticulo + ", descrip_tipoArticulo=" + descrip_tipoArticulo + '}';
    }
    
    
}
