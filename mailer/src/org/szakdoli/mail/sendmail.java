/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.szakdoli.mail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class sendmail {
    

   public static void sendmail(String hova) throws MessagingException{
                     final String from ="hkszakdoli22@gmail.com";
             final String pw = "Szakdoli2022";
 
             
             Properties pros = new Properties();
             pros.put("mail.smtp.host", "smtp.gmail.com");
             pros.put("mail.smtp.socketFactory.port", "465");
             pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
             pros.put("mail.smtp.auth", "true");
             pros.put("mail.smtp.port", "465");
             
            Session ses;
        ses = javax.mail.Session.getInstance(pros,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,pw); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        Message msg = prepareMessage(ses,from,hova);
        
        Transport.send(msg);
        JOptionPane.showMessageDialog(null, "Sikeres regisztráció!");
    }
    
   private static Message prepareMessage(Session ses, String myEmail, String hova){
        try{
            Message msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(myEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(hova));
            msg.setSubject("Regisztráció");
            msg.setText("Tisztelt Felhasználó!\n Köszönjük, hogy a mi könyvtárunkat választotta. \n További kérdéseit kérjük erre az emailcímre írányítsa. \n Üdvözlettel,\n HK TesztKönyvtár.");
            return msg;
          }catch(MessagingException e){ 
        }
        return null;
    }


public static void mailborrowed(String hova,String user,String könyv) throws MessagingException{
     final String from ="hkszakdoli22@gmail.com";
             final String pw = "Szakdoli2022";
 
             
             Properties pros = new Properties();
             pros.put("mail.smtp.host", "smtp.gmail.com");
             pros.put("mail.smtp.socketFactory.port", "465");
             pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
             pros.put("mail.smtp.auth", "true");
             pros.put("mail.smtp.port", "465");
             
            Session ses;
        ses = javax.mail.Session.getInstance(pros,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,pw); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        Message msg = prepareMessageB(ses,from,hova,user,könyv);
        
        Transport.send(msg);
        JOptionPane.showMessageDialog(null, "Sikeres kölcsönzés!");
}

private static Message prepareMessageB(Session ses, String myEmail, String hova,String user,String könyv){
        try{
            Message msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(myEmail));
            	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	System.out.println(formatter.format(date));
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 30);
            Date visszahozni = c.getTime();
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(hova));
            msg.setSubject("Kölcsönzés");
            msg.setText("Tisztelt "+user+"! \n"
                    + " Köszönjük, hogy a mi könyvtárunkat választotta. \n "
                    + "Sikeresen kikölcsönözte a következő könyvet:"+könyv+" \n "
                            + "Kérjük, a mai dátumtól ("+formatter.format(date)+") számítva 30 napon belül hozza vissza ("+formatter.format(visszahozni)+") a kikölcsönzött művet!\n"
                            + "Üdvözlettel,\n HK TesztKönyvtár.");
            
            
            return msg;
            
            
                    
                    
          }catch(MessagingException e){
            
        }
        return null;
    }

private static Message prepareMessageReturn(Session ses, String myEmail, String hova,String user,String könyv,String datum){
        try{
            Message msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(myEmail));
        
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(hova));
            msg.setSubject("Kölcsönzési határidő");
            msg.setText("Tisztelt "+user+" !\n Ezzel az e-maillel szeretnénk emlékeztetni,hogy az ön által kikölcsönözött "+könyv+""
                    + " kölcsönzési határideje "+datum+" -al lejár.\n "
                    
                
                            + "Üdvözlettel,\n HK TesztKönyvtár.");
            
            
            return msg;
            
            
                    
                    
          }catch(MessagingException e){
            
        }
        return null;
    }

public static void mailreminder(String hova,String user,String könyv,String datum) throws MessagingException{
     final String from ="hkszakdoli22@gmail.com";
             final String pw = "Szakdoli2022";
 
             
             Properties pros = new Properties();
             pros.put("mail.smtp.host", "smtp.gmail.com");
             pros.put("mail.smtp.socketFactory.port", "465");
             pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
             pros.put("mail.smtp.auth", "true");
             pros.put("mail.smtp.port", "465");
             
            Session ses;
        ses = javax.mail.Session.getInstance(pros,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,pw); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        Message msg = prepareMessageReturn(ses,from,hova,user,könyv,datum);
        
        Transport.send(msg);
        JOptionPane.showMessageDialog(null, "Üzenet elküldve!");
}


}