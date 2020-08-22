/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpersistenciarmicservidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import model.ServicioPaciente;

/**
 *
 * @author crist
 */
public class HospitalPersistenciaRMICServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServicioPaciente model = new ServicioPaciente();
           
            
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//192.168.1.83/ServidorHola", model);
           
            System.out.println("Servidor Hola operando");
        }catch(Exception e){
            System.out.println("Error!" + e);
            //192.168.1.67
        }  
    }
    
}
