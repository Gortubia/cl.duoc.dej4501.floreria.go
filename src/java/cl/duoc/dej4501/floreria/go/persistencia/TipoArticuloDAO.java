/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.persistencia;

import cl.duoc.dej4501.floreria.go.entity.TipoArticulo;
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
public class TipoArticuloDAO implements ICrud{

    public TipoArticuloDAO() {
    }

    
    @Override
    public boolean addElemento(Object objetoInsert) {
       try {
            String query= "INSERT INTO tipoarticulo (descrip_tipoArticulo) VALUES(?)"; 
            TipoArticulo objTipoArticulo=(TipoArticulo)objetoInsert;
            Connection con = Conexion.getConexion();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1, objTipoArticulo.getDescrip_tipoArticulo()); 
            
            try {
                return  ps.executeUpdate() == 1;
            } catch (SQLException e) {
                System.out.println("error al insertar"+e.getMessage());
            }
            
        } catch (ConexionException | SQLException e) {
            System.out.println("error al insertar"+e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List listadoUsuarios = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from tipoarticulo";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TipoArticulo  objTipoArticulo = new TipoArticulo(rs.getInt(1), rs.getString(2) );
                listadoUsuarios.add(objTipoArticulo);
            }
        } catch (ConexionException | SQLException e) {
            System.out.println("error al conectar la BD" + e.getMessage());
        }
        return listadoUsuarios;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
