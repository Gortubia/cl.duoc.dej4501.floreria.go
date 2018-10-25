/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.controller;

import cl.duoc.dej4501.floreria.go.entity.TipoArticulo;
import cl.duoc.dej4501.floreria.go.persistencia.TipoArticuloDAO;
import java.util.List;

/**
 *
 * @author adolf
 */
public class TipoArticuloController {
     private TipoArticuloDAO objTipoArticuloDAO;

    public TipoArticuloController() {
        this.objTipoArticuloDAO= new TipoArticuloDAO();
    }
 
    public List readElementos(){
        return this.objTipoArticuloDAO.readElementos();
    }
      
     public boolean agregarTipoArticulo(TipoArticulo objTipoArticulo) {
        return this.objTipoArticuloDAO.addElemento(objTipoArticulo);
    }
     public boolean editarTipoArticulo(TipoArticulo objTipoArticulo) {
        return this.objTipoArticuloDAO.updateElemento(objTipoArticulo);
    }
     
      public boolean eliminar(int codigoEliminar) {
        return this.objTipoArticuloDAO.deleteElemento(codigoEliminar);
    }
}
