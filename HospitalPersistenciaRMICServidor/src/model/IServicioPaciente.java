/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import Estructural.HistorialClinico;
import Estructural.Paciente;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author crist
 */
public interface IServicioPaciente extends Remote
{
    public int agregarPaciente(Paciente paciente) throws RemoteException;
    
    public List listar() throws RemoteException;
    
    public List listarPorParametro(String nombre) throws RemoteException;
    
    public Paciente buscarPaciente(String Documento) throws RemoteException;
    
    public HistorialClinico buscarHistorial (int numero) throws RemoteException;
    
    public HistorialClinico buscarHistorialPorDosParametros (int numero,String documento) throws RemoteException;
    
    public int modificarPaciente(Paciente paciente, String Documento) throws RemoteException;
    
    public int modificarHistorial(HistorialClinico historial, int numero) throws RemoteException;
    
    public void eliminarPaciente(String Documento) throws RemoteException;
    
    public void eliminarHistorial(int numero) throws RemoteException;
    
    public int agregarHistorial(HistorialClinico historial) throws RemoteException;
    
    public List listarEnfermedades() throws RemoteException;
    
    public List listarHistorial () throws RemoteException;
    
    public List listarHistorialPorParametro (String nombre) throws RemoteException;
    
    public String contarEnfermedades(String documento) throws RemoteException;
    
    //public Paciente asignar() throws RemoteException;
    
   
    
   // public ResultSet buscarPaciente(String documento) throws RemoteException;
}
