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

/**
 *
 * @author HOME
*/

public class sqlkonnekcio {
   Connection conn = null;
   

   


 public static Connection connect() throws SQLException {
      
    try{
      
        
       
   
        Class.forName("org.sqlite.JDBC");  
      Connection conn = DriverManager.getConnection("jdbc:sqlite::resource:org/szakdoli/konnekcio/szakdolidb.db");
      return conn;

        
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(sqlkonnekcio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    

 
}
}
