/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author crist
 */
public class Conexion {
    
    Connection con;
    public Connection getConnection()
    {
     String url = "jdbc:oracle:thin:@localhost:1521:orcl";
     String user = "HOSPITAL";
     String pass = "HOSPITAL";
    
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,user,pass);
           /*if(con != null)
           {
               System.out.println("conexion exitosa");
           }else{
               System.out.println("conexion fallida");
           }*/
               
                    
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Errado" + e.getMessage());
        }
        return con;
    }
    
    /*public static void main(String[] args)
    {
        Conexion c = new Conexion();
        c.getConnection();
    }*/

}
