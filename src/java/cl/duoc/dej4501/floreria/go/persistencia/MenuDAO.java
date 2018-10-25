/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import cl.duoc.dej4501.floreria.go.entity.Menu;

/**
 *
 * @author adolf
 */
public class MenuDAO {
    public MenuDAO() {
    }
    
    /**
     * Método que retorna el listado de objetos menu  por codigo de perfil de usuario
     * @param perfil int , asociado al codigo del perfil del usuario conectado  
     * @return listado con los registros de la tabla menu, asociados al perfil de usuario
     *     
     */
    public List listadoMenuPorPerfil(int perfil){
        List listadoMenu= new LinkedList();
        try{
            
            Connection con= Conexion.getConexion();
            String query="SELECT * FROM menu WHERE id_perfil=? ORDER BY padre_menu";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, perfil);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Menu objMenu= new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
                listadoMenu.add(objMenu);
            }
        }catch(SQLException | ConexionException e){
            System.out.println("Problemas en la extracción de información"+e.getMessage());
        }
        return listadoMenu;
    }
    
}
