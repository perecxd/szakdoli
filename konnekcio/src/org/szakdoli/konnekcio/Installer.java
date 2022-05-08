/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/moduleInstall.java to edit this template
 */
package org.szakdoli.konnekcio;

import javax.swing.JFileChooser;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
      

}
     public static String fajl(){
     JFileChooser jfc = new JFileChooser();
     int response = jfc.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
            String File = jfc.getSelectedFile().getAbsolutePath().replace('\\','/');
            
            return File;
            }
            return null;
 }  
    
}