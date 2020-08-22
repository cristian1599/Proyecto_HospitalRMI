/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructural;

import model.*;
import java.io.Serializable;

/**
 *
 * @author crist
 */
public class Enfermedad implements Serializable{
   int codigo;
   String nombre;
   String tipo;

    public Enfermedad() {
    }

    public Enfermedad(int codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Enfermedades{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + '}';
    }
   
   
     
    
}
