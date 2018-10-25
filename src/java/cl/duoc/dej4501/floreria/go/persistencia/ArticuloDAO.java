/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.persistencia;

import cl.duoc.dej4501.floreria.go.entity.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List; 

/**
 *
 * @author adolf
 */
public class ArticuloDAO implements ICrud{

    public ArticuloDAO() {
    }
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Crud">
    /**
     * Método que permite agregar un objeto a una tabla
     * @param objetoInsert objeto corresponde al registro a insertar
     * @return true/false dependiendo del resultado de la transacción
     */

    @Override
    public boolean addElemento(Object objetoInsert) {
        Articulo objArticulo;
        objArticulo = (Articulo) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query;
            query = "INSERT INTO articulo(descrip_articulo, precio, stock, id_tipoarticulo) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query); 
            ps.setString(1, objArticulo.getDescrip_articulo());
            ps.setInt(2, objArticulo.getPrecio());    
            ps.setInt(3, objArticulo.getStock());
            ps.setInt(4, objArticulo.getId_tipoarticulo());
            
            try {
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                System.out.println("error al insertar");
                return false;
            }
        } catch (ConexionException | SQLException e) {
            System.out.println("Error al Insertar en la BD" + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List listadoArticulos = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT a.id_articulo, a.descrip_articulo, a.precio, a.stock, a.id_tipoarticulo ,t.descrip_tipoArticulo\n" +
                "FROM articulo a JOIN tipoarticulo t \n" +
                "ON (a.id_tipoarticulo = t.id_tipoArticulo)";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Articulo objArticulo = new Articulo(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getInt(5), rs.getString(6));
                listadoArticulos.add(objArticulo);
            }
        } catch (ConexionException | SQLException e) {
            System.out.println("error al conectar la BD" + e.getMessage());
        }
        return listadoArticulos;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Articulo objArticulo = (Articulo) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "update articulo set descrip_articulo=?,precio=?,Stock=? ,id_tipoarticulo=? where id_articulo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objArticulo.getDescrip_articulo());
            ps.setInt(2, objArticulo.getPrecio());    
            ps.setInt(3, objArticulo.getStock());
            ps.setInt(4, objArticulo.getId_tipoarticulo()); 
            try {
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                System.out.println(e.getMessage()+ "Problemas al updatear");
            }
        } catch (ConexionException | SQLException e) {
            System.out.println("No se pudo updatear la base de datos"+ e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
       try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM articulo WHERE id_articulo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                System.out.println("Error al Eliminar el registro" + e.getMessage());
            }
        } catch (ConexionException | SQLException e) {
            System.out.println("Error al borrar los registro" + e.getMessage());
        }
        return false;
    }
    
     //</editor-fold>
    
}
