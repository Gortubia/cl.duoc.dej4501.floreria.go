/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.controller;

import cl.duoc.dej4501.floreria.go.entity.Articulo;
import cl.duoc.dej4501.floreria.go.persistencia.ArticuloDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author adolf
 */
public class ArticuloController implements Serializable{
     private final ArticuloDAO objArticuloDAO;

    public ArticuloController() {
        this.objArticuloDAO= new ArticuloDAO();
    }
       
 
    public List<Articulo> readElementos(){
        return this.objArticuloDAO.readElementos();
    }
      
     public boolean agregarTipoArticulo(Articulo objArticulo) {
        return this.objArticuloDAO.addElemento(objArticulo);
    }
     public boolean editarTipoArticulo(Articulo objArticulo) {
        return this.objArticuloDAO.updateElemento(objArticulo);
    }
     
      public boolean eliminar(int codigoEliminar) {
        return this.objArticuloDAO.deleteElemento(codigoEliminar);
    }
    
}
