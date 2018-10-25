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
public class DetalleVenta implements Serializable{
    private int id_detalleVenta;
    private int id_venta;
    private int id_articulo;
    private int cantidad_articulo;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalleVenta, int id_venta, int id_articulo, int cantidad_articulo) {
        this.id_detalleVenta = id_detalleVenta;
        this.id_venta = id_venta;
        this.id_articulo = id_articulo;
        this.cantidad_articulo = cantidad_articulo;
    }

    public DetalleVenta(int id_venta, int id_articulo, int cantidad_articulo) {
        this.id_venta = id_venta;
        this.id_articulo = id_articulo;
        this.cantidad_articulo = cantidad_articulo;
    }
    
    

    public int getId_detalleVenta() {
        return id_detalleVenta;
    }

    public void setId_detalleVenta(int id_detalleVenta) {
        this.id_detalleVenta = id_detalleVenta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getCantidad_articulo() {
        return cantidad_articulo;
    }

    public void setCantidad_articulo(int cantidad_articulo) {
        this.cantidad_articulo = cantidad_articulo;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id_detalleVenta=" + id_detalleVenta + ", id_venta=" + id_venta + ", id_articulo=" + id_articulo + ", cantidad_articulo=" + cantidad_articulo + '}';
    }
    
    
    
}
