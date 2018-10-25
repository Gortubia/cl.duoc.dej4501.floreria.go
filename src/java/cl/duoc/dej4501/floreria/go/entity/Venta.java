/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author adolf
 */
public class Venta implements Serializable{
    private int id_venta;
    private Date fecha_venta;
    private int total;
    private int id_usuario;

    public Venta() {
    }

    public Venta(int id_venta, Date fecha_venta, int total, int id_usuario) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.id_usuario = id_usuario;
    }

    public Venta(Date fecha_venta, int total, int id_usuario) {
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.id_usuario = id_usuario;
    }
    
    

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", fecha_venta=" + fecha_venta + ", total=" + total + ", id_usuario=" + id_usuario + '}';
    }
    
    
    
}
