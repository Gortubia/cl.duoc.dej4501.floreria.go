/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.controller;


import cl.duoc.dej4501.floreria.go.entity.Usuario;

import cl.duoc.dej4501.floreria.go.persistencia.UsuarioDAO;
import java.util.List;

/**
 *
 * @author adolf
 */
public class UsuarioController {
    
    private final UsuarioDAO objUsuarioDAO;

    public UsuarioController() {
        this.objUsuarioDAO= new UsuarioDAO();
    }
    
    public Usuario compruebaUsuario(String login,String pass){
        return this.objUsuarioDAO.compruebaUsuario(login, pass);
    }
    
        public List<Usuario> readElementos(){
        return this.objUsuarioDAO.readElementos();
    }
      
     public boolean agregarUsuario(Usuario objUsuario) {
        return this.objUsuarioDAO.addElemento(objUsuario);
    }
     public boolean editarUsuario(Usuario objUsuario) {
        return this.objUsuarioDAO.updateElemento(objUsuario);
    }
     
      public boolean eliminar(int codigoEliminar) {
        return this.objUsuarioDAO.deleteElemento(codigoEliminar);
    }
}
