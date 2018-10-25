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
public class Articulo implements Serializable{
    private int id_articulo;
    private String descrip_articulo;
    private int precio;
    private int stock;
    private int id_tipoarticulo;
    private String descrip_tipoArticulo;

 

    public Articulo() {
    }

    public Articulo(int id_articulo, String descrip_articulo, int precio, int stock, int id_tipoarticulo) {
        this.id_articulo = id_articulo;
        this.descrip_articulo = descrip_articulo;
        this.precio = precio;
        this.stock = stock;
        this.id_tipoarticulo = id_tipoarticulo;
    }

    public Articulo(String descrip_articulo, int precio, int stock, int id_tipoarticulo) {
        this.descrip_articulo = descrip_articulo;
        this.precio = precio;
        this.stock = stock;
        this.id_tipoarticulo = id_tipoarticulo;
    }

    public Articulo(int id_articulo, String descrip_articulo, int precio, int stock, int id_tipoarticulo, String descrip_tipoArticulo) {
        this.id_articulo = id_articulo;
        this.descrip_articulo = descrip_articulo;
        this.precio = precio;
        this.stock = stock;
        this.id_tipoarticulo = id_tipoarticulo;
        this.descrip_tipoArticulo = descrip_tipoArticulo;
    }
    
    

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescrip_articulo() {
        return descrip_articulo;
    }

    public void setDescrip_articulo(String descrip_articulo) {
        this.descrip_articulo = descrip_articulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_tipoarticulo() {
        return id_tipoarticulo;
    }

    public void setId_tipoarticulo(int id_tipoarticulo) {
        this.id_tipoarticulo = id_tipoarticulo;
    }
    
       public String getDescrip_tipoArticulo() {
        return descrip_tipoArticulo;
    }

    public void setDescrip_tipoArticulo(String descrip_tipoArticulo) {
        this.descrip_tipoArticulo = descrip_tipoArticulo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id_articulo=" + id_articulo + ", descrip_articulo=" + descrip_articulo + ", precio=" + precio + ", stock=" + stock + ", id_tipoarticulo=" + id_tipoarticulo + ", descrip_tipoArticulo=" + descrip_tipoArticulo + '}';
    }
 
    
    
}
