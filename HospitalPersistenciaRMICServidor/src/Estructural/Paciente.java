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
public class Paciente implements Serializable {
    
    private String nombre,documento,correo,telefono, genero;
    int id;
    public Paciente() {
      
    }
    
   

    public Paciente(int id,String documento, String nombre, String correo, String telefono, String genero) {
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", documento=" + documento + ", correo=" + correo + ", telefono=" + telefono + ", sexo=" + genero + '}';
    }

   
}
