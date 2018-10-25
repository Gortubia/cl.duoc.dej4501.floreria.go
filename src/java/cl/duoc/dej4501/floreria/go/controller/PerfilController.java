/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.controller;

import java.util.List;
import cl.duoc.dej4501.floreria.go.entity.Perfil;
import cl.duoc.dej4501.floreria.go.persistencia.PerfilDAO;

/**
 *
 * @author adolf
 */
public class PerfilController {
    
    PerfilDAO objPerfilDAO;

    public PerfilController() {
        this.objPerfilDAO= new PerfilDAO();
    }
    
    public List<Perfil> getAllPerfil(){
        return this.objPerfilDAO.readElementos();
    }
    
    public Perfil getPerfilXCodigo(int codigoPerfil){
        return this.objPerfilDAO.buscaPerfilPOrID(codigoPerfil);
    }
    
    public boolean addPerfil(Perfil objperfil){
        return this.objPerfilDAO.addElemento(objperfil);
    }
 
     public boolean editarUsuario(Perfil objperfil) {
        return this.objPerfilDAO.updateElemento(objperfil);
    }
     
      public boolean eliminar(int codigoEliminar) {
        return this.objPerfilDAO.deleteElemento(codigoEliminar);
    }
}
