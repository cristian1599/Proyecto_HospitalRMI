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
public class HistorialClinico implements Serializable{
    int codigo;
    int numeroHistoria;
    String nombreDoctor;
    String fk_paciente;
    int fk_enfermedad;
    
    public HistorialClinico()
    {
        
    }
    

    public HistorialClinico(int codigo, int numeroHistoria, String nombreDoctor, String fk_paciente, int fk_enfermedad) {
        this.codigo = codigo;
        this.numeroHistoria = numeroHistoria;
        this.nombreDoctor = nombreDoctor;
        this.fk_paciente = fk_paciente;
        this.fk_enfermedad = fk_enfermedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(int numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getFk_paciente() {
        return fk_paciente;
    }

    public void setFk_paciente(String fk_paciente) {
        this.fk_paciente = fk_paciente;
    }

    public int getFk_enfermedad() {
        return fk_enfermedad;
    }

    public void setFk_enfermedad(int fk_enfermedad) {
        this.fk_enfermedad = fk_enfermedad;
    }

    @Override
    public String toString() {
        return "HistorialClinico{" + "codigo=" + codigo + ", numeroHistoria=" + numeroHistoria + ", nombreDoctor=" + nombreDoctor + ", fk_paciente=" + fk_paciente + ", fk_enfermedad=" + fk_enfermedad + '}';
    }
    
    
    
    
    
}
