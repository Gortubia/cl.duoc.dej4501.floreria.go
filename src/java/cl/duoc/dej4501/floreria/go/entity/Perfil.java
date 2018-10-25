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
public class Perfil implements Serializable{
    
    private int id_perfil;
    private String tipo_perfil;

    public Perfil() {
    }

    public Perfil(int id_perfil, String tipo_perfil) {
        this.id_perfil = id_perfil;
        this.tipo_perfil = tipo_perfil;
    }

    public Perfil(String tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(String tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }

    @Override
    public String toString() {
        return "Perfil{" + "id_perfil=" + id_perfil + ", tipo_perfil=" + tipo_perfil + '}';
    }
    
    

    
}
