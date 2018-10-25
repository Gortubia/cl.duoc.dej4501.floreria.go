/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.controller;

import java.util.List;
import cl.duoc.dej4501.floreria.go.entity.Menu;
import cl.duoc.dej4501.floreria.go.persistencia.MenuDAO;

/**
 *
 * @author adolf
 */
public class MenuController {
      private final MenuDAO objMenuDAO;

    public MenuController() {
        this.objMenuDAO= new MenuDAO();
    }
    
    public List<Menu> cargarMenuPorPerfil(int id_perfil){
        return this.objMenuDAO.listadoMenuPorPerfil(id_perfil);
    }
}
