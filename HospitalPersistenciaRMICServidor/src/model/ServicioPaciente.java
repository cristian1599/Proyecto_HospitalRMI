/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Estructural.Enfermedad;
import Estructural.HistorialClinico;
import Estructural.Paciente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class ServicioPaciente extends UnicastRemoteObject implements IServicioPaciente {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public ServicioPaciente() throws RemoteException {
       
    }
    
    
    @Override
    public int agregarPaciente(Paciente paciente) throws RemoteException {
       String sql = "insert into paciente (ID,Documento,Nombre,Correo,Telefono,Genero) values(PACIENTE2_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getDocumento());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getCorreo());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getGenero());
            ps.executeUpdate();
          
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public List listar() throws RemoteException {
       List<Paciente> listaPacinte = new ArrayList<>();
        String sql = "select * from paciente";
       // "select * from paciente where NOMBRE = '"+ Nombre +"'"
        try {
            con = conectar.getConnection();
           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Paciente p = new Paciente();
                p.setId(rs.getInt(1));
                p.setDocumento(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setGenero(rs.getString(6));
                listaPacinte.add(p);
            }
        } catch (Exception e) {
            
        }
        
        return listaPacinte;
         
    }

    @Override
    public Paciente buscarPaciente(String Documento) throws RemoteException {
        Paciente p = null; 
        String documento;
        String nombre;
        String correo;
        String telefono;
        String genero;
        int id;
        String sql = "select * from paciente where DOCUMENTO = '"+ Documento +"'";
           try {
            con = conectar.getConnection(); 
            ps = con.prepareStatement(sql);
           //ps.setString(1, Documento);
            rs = ps.executeQuery();
             if(rs.next())
            {
                id= rs.getInt(1);
                documento = rs.getString(2);
                nombre = rs.getString(3);
                correo  = rs.getString(4);
                telefono = rs.getString(5);
                genero = rs.getString(6);
                p = new Paciente(id,documento,nombre,correo,telefono,genero);
            }
            
     } catch (Exception e) {
            
        }
       
        return p;
    } 

 
    @Override
    public int modificarPaciente(Paciente paciente, String Documento) throws RemoteException {
       String sql = "update paciente set DOCUMENTO=?, NOMBRE=?, CORREO=?, TELEFONO =?, GENERO =? where DOCUMENTO = '"+ Documento +"'";
       int m = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getDocumento());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getCorreo());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getGenero());
            m = ps.executeUpdate();
            if(m == 1)
            {
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
        }
        
        return  m;
    }

    @Override
    public void eliminarPaciente(String Documento) throws RemoteException {
        String sql = "delete from paciente where DOCUMENTO = '"+ Documento +"'";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }

    @Override
    public int agregarHistorial(HistorialClinico historial) throws RemoteException {
       String sql = "insert into HISTORIAL_CLINICO (IDHISTORIAL,NUMEROHISTORIA,NOMBRE_DOCTOR,FK_IDPACIENTE,FK_IDENFERMEDAD) VALUES(HISTORIAL_SEQ.NEXTVAL,?,?,?,?)";
       
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, historial.getNumeroHistoria());
            ps.setString(2,historial.getNombreDoctor());
            ps.setString(3, historial.getFk_paciente());
            ps.setInt(4, historial.getFk_enfermedad());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    
        return 1;
    }

    @Override
    public List listarEnfermedades() throws RemoteException {
            
     List<Enfermedad> listaEnfermedad = new ArrayList<>();
     String sql = "select * from enfermedad";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Enfermedad e = new Enfermedad();
                e.setCodigo(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setTipo(rs.getString(3));
                listaEnfermedad.add(e);
            }
        } catch (Exception e) {
        }
     return listaEnfermedad;
    }

    @Override
    public List listarHistorial() throws RemoteException {
        List<HistorialClinico> listaHistorial = new ArrayList<>();
        String sql = "select * from HISTORIAL_CLINICO";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           while(rs.next())
           {
               HistorialClinico h = new HistorialClinico();
               h.setCodigo(rs.getInt(1));
               h.setNumeroHistoria(rs.getInt(2));
               h.setNombreDoctor(rs.getString(3));
               h.setFk_paciente(rs.getString(4));
               h.setFk_enfermedad(rs.getInt(5));
               listaHistorial.add(h);
           }
        } catch (Exception e) {
            
        }
        return listaHistorial;
    }

    @Override
    public List listarPorParametro(String nombre) throws RemoteException {
        List<Paciente> listaParametro = new ArrayList<>();
        String sql = "select * from paciente where NOMBRE = '"+ nombre +"'";
       // "select * from paciente where NOMBRE = '"+ Nombre +"'"+
       
        try {
            con = conectar.getConnection();
           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Paciente p = new Paciente();
                p.setId(rs.getInt(1));
                p.setDocumento(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setGenero(rs.getString(6));
                listaParametro.add(p);
            }
        } catch (Exception e) {
            
        }
        
        return listaParametro;
    }

    @Override
    public HistorialClinico buscarHistorial(int pNumero) throws RemoteException {
       HistorialClinico h = null;
       int id;
       int numero;
       String nombre;
       String documento;
       int codigo;
       String sql = "select * from HISTORIAL_CLINICO  where NUMEROHISTORIA = '"+ pNumero +"'";
        try {
             con = conectar.getConnection(); 
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             if(rs.next())
             {
                 id = rs.getInt(1);
                 numero = rs.getInt(2);
                 nombre = rs.getString(3);
                 documento = rs.getString(4);
                 codigo = rs.getInt(5);
                 h = new HistorialClinico(id,numero,nombre,documento,codigo);
             }
        } catch (Exception e) {
        }
        
        return h;
    }

    @Override
    public void eliminarHistorial(int pNumero) throws RemoteException {
        String sql = "delete from HISTORIAL_CLINICO  where NUMEROHISTORIA = '"+ pNumero +"'" ;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public int modificarHistorial(HistorialClinico historial, int numero) throws RemoteException {
       String sql = "update HISTORIAL_CLINICO set NUMEROHISTORIA=?,NOMBRE_DOCTOR=?, FK_IDPACIENTE=?, FK_IDENFERMEDAD=? where NUMEROHISTORIA = '"+ numero +"'" ;
        int modificado = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, historial.getNumeroHistoria());
            ps.setString(2, historial.getNombreDoctor());
            ps.setString(3, historial.getFk_paciente());
            ps.setInt(4, historial.getFk_enfermedad());
            modificado = ps.executeUpdate();
            if(modificado == 1)
              
            {
                return 1;
            }else{
                return 0;
            }
            
              
        } catch (Exception e) {
        }
        return modificado;
    }

    @Override
    public HistorialClinico buscarHistorialPorDosParametros(int pNumero, String pDocumento) throws RemoteException {
       
       HistorialClinico h = null;
       int id;
       int numero;
       String nombre;
       String documento;
       int codigo;
       String sql = "select * from HISTORIAL_CLINICO  where NUMEROHISTORIA = '"+ pNumero +"' AND FK_IDPACIENTE = '"+ pDocumento +"'";
        try {
             con = conectar.getConnection(); 
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             if(rs.next())
             {
                 id = rs.getInt(1);
                 numero = rs.getInt(2);
                 nombre = rs.getString(3);
                 documento = rs.getString(4);
                 codigo = rs.getInt(5);
                 h = new HistorialClinico(id,numero,nombre,documento,codigo);
                 //JOptionPane.showMessageDialog(null, "Encontrado");
                 System.out.println("encontrado");
             }else{
                  //JOptionPane.showMessageDialog(null, "No Encontrado");
               System.out.println("Noooo encontrado");
             }
             
           
            
        } catch (Exception e) {
        }
        
        
        return h;
    }

    @Override
    public String contarEnfermedades(String documento) throws RemoteException {
      String sql = "select count(FK_IDENFERMEDAD) FROM HISTORIAL_CLINICO WHERE FK_IDPACIENTE = '"+ documento +"'";
      String resultado = null ;
        try {
           con = conectar.getConnection();
           
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
            {
                resultado = rs.getString(1);
            }
        } catch (Exception e) {
        }
      return resultado;
    }

    @Override
    public List listarHistorialPorParametro(String nombre) throws RemoteException {
         List<HistorialClinico> listaHistorial = new ArrayList<>();
        String sql = "select * from HISTORIAL_CLINICO WHERE NOMBRE_DOCTOR = '"+ nombre +"'";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           while(rs.next())
           {
               HistorialClinico h = new HistorialClinico();
               h.setCodigo(rs.getInt(1));
               h.setNumeroHistoria(rs.getInt(2));
               h.setNombreDoctor(rs.getString(3));
               h.setFk_paciente(rs.getString(4));
               h.setFk_enfermedad(rs.getInt(5));
               listaHistorial.add(h);
           }
        } catch (Exception e) {
            
        }
        return listaHistorial;
    }
    
    
}
