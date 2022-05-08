/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.szakdoli.konnekcio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.openide.modules.OnStart;

/**
 *
 * @author HOME
*/

public class sqlkonnekcio {
   Connection conn = null;
   
  public static String File = Installer.fajl();
   


 public static Connection connect() throws SQLException {
      
    try{
      
        
       
   
        Class.forName("org.sqlite.JDBC");  
      Connection conn = DriverManager.getConnection("jdbc:sqlite:"+File);
      return conn;
    
          
       //jdbc:sqlite:C:/Users/HOME/Documents/NetBeansProjects/szakdoga1/konnekcio/szakdolidb.db
        
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(sqlkonnekcio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    

 
}
}
