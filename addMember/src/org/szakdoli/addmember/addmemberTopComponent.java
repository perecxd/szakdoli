/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/templateTopComponent637.java to edit this template
 */
package org.szakdoli.addmember;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.szakdoli.konnekcio.sqlkonnekcio;


import org.szakdoli.mail.sendmail;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.szakdoli.addmember//addmember//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "addmemberTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.szakdoli.addmember.addmemberTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_addmemberAction",
        preferredID = "addmemberTopComponent"
)
@Messages({
    "CTL_addmemberAction=addmember",
    "CTL_addmemberTopComponent=addmember Window",
    "HINT_addmemberTopComponent=This is a addmember window"
})
public final class addmemberTopComponent extends TopComponent {

    public addmemberTopComponent() {
        initComponents();
        setName(Bundle.CTL_addmemberTopComponent());
        setToolTipText(Bundle.HINT_addmemberTopComponent());

    }
    Connection conn;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfTSZ = new java.awt.TextField();
        tFName = new java.awt.TextField();
        tfLC = new java.awt.TextField();
        tfISZ = new java.awt.TextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnregister = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfmail = new java.awt.TextField();
        jLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(600, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfTSZ.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTSZ.setText(org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.tfTSZ.text")); // NOI18N
        jPanel1.add(tfTSZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 290, 30));

        tFName.setText(org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.tFName.text")); // NOI18N
        jPanel1.add(tFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 330, -1));

        tfLC.setText(org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.tfLC.text")); // NOI18N
        jPanel1.add(tfLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 330, -1));

        tfISZ.setText(org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.tfISZ.text")); // NOI18N
        jPanel1.add(tfISZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 330, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 330, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLabel1.text")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 200, 30));

        jLName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLName, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLName.text")); // NOI18N
        jPanel1.add(jLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 46, 90, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLabel3.text")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLabel4.text")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLabel5.text")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 170, 30));

        btnregister.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnregister, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.btnregister.text")); // NOI18N
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 330, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLabel2.text")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 40, -1));

        tfmail.setText(org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.tfmail.text")); // NOI18N
        jPanel1.add(tfmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 330, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(addmemberTopComponent.class, "addmemberTopComponent.jLabel6.text")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 200, 30));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

 
    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
             try {
             sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
             String sqlS ="INSERT INTO members(idmembers, nev, lakcim, igazolvany, telszam, szuldate,mail) VALUES (?,?,?,?,?,?,?) ";
             String sqlC ="SELECT max(idmembers) from members;";
            
             PreparedStatement pstC = conn.prepareStatement(sqlC);
             PreparedStatement pst = conn.prepareStatement(sqlS);
          
             ResultSet rsC = pstC.executeQuery();
         
             String telefon = tfTSZ.getText();
             String nev = tFName.getText();
             String lakcim = tfLC.getText();
             String igszam = tfISZ.getText();
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             
             
             int tagid = 0;
             
                     
             if(rsC.next()){
                tagid =rsC.getInt(1);
             }
             
                 if ((telefon.equals("")||nev.equals("")||lakcim.equals("")||igszam.equals("")||jDateChooser1.getDate()==null)) {
                     JOptionPane.showMessageDialog(null, "Az űrlap egyik mezőjét üresen hagytad!");
                 }
               else  if (!telefon.matches("[0-9]+")) {
                     JOptionPane.showMessageDialog(null, "Kérlek csak számokat használj a telefonszám megadásához!");
                     tfTSZ.setText("");
                 }else{
                   String Date = sdf.format(jDateChooser1.getDate());
                      pst.setInt(1, tagid+1);
             pst.setString(2, nev);
             pst.setString(3, lakcim);
             pst.setString(4, igszam);
            
             pst.setString(5, telefon);
                 
             pst.setString(6, Date);
               String to =tfmail.getText();
                     if (to.equals("")) {
                         JOptionPane.showMessageDialog(null, "Nem adtál meg e-mail címet!");
                     }else{
                
                
                
                 try {
                     sendmail.sendmail(to);
                 } catch (MessagingException ex) {
                     Exceptions.printStackTrace(ex);
                 }
                 pst.setString(7, to);
               pst.execute();
                 }
             
              
               }
             
             
          
  
           
            
             
            
             
          
             pst.close();
             pstC.close();
             
             conn.close();
             
             //emailküldés
             

             
             
        } catch (SQLException ex) {
                 if (ex.getErrorCode()==1062) {
                     JOptionPane.showMessageDialog(null, "EZ az igazolványszám már az adatbázisban van, kérlek ellenőrizd amit írtál!");
                 }
            Exceptions.printStackTrace(ex);
        }
           
    }//GEN-LAST:event_btnregisterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregister;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextField tFName;
    private java.awt.TextField tfISZ;
    private java.awt.TextField tfLC;
    private java.awt.TextField tfTSZ;
    private java.awt.TextField tfmail;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
