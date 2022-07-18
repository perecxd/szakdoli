/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/templateTopComponent637.java to edit this template
 */
package org.szakdoli.addbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.szakdoli.konnekcio.sqlkonnekcio;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.szakdoli.addbook//addbooks//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "addbooksTopComponent",
        iconBase = "org/szakdoli/addbook/bookicon.png",
        persistenceType = TopComponent.PERSISTENCE_NEVER
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.szakdoli.addbook.addbooksTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_addbooksAction",
        preferredID = "addbooksTopComponent"
)
@Messages({
    "CTL_addbooksAction=addbooks",
    "CTL_addbooksTopComponent=addbooks Window",
    "HINT_addbooksTopComponent=This is a addbooks window"
})
public final class addbooksTopComponent extends TopComponent {
Connection conn = null;
    public addbooksTopComponent() {
        initComponents();
        setName(Bundle.CTL_addbooksTopComponent());
        setToolTipText(Bundle.HINT_addbooksTopComponent());
       

    }
    
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlLink = new javax.swing.JLabel();
        tfLink = new java.awt.TextField();
        btnFile = new javax.swing.JButton();
        jbtnAddBook = new javax.swing.JButton();
        jlKiadasEv = new javax.swing.JLabel();
        tFCim = new java.awt.TextField();
        tfSzerzo = new java.awt.TextField();
        jlSzerzo = new javax.swing.JLabel();
        tfEv = new java.awt.TextField();
        jlKiado = new javax.swing.JLabel();
        tfKiado = new java.awt.TextField();
        jlCim = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.Color.green);
        setMaximumSize(new java.awt.Dimension(400, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLink.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlLink, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jlLink.text_1")); // NOI18N
        jPanel1.add(jlLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        tfLink.setText(org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.tfLink.text")); // NOI18N
        jPanel1.add(tfLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 320, -1));

        btnFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnFile, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.btnFile.text")); // NOI18N
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jbtnAddBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jbtnAddBook, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jbtnAddBook.text_1")); // NOI18N
        jbtnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddBookActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 320, 30));

        jlKiadasEv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlKiadasEv, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jlKiadasEv.text_1")); // NOI18N
        jPanel1.add(jlKiadasEv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        tFCim.setText(org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.tFCim.text")); // NOI18N
        jPanel1.add(tFCim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 320, -1));

        tfSzerzo.setText(org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.tfSzerzo.text")); // NOI18N
        jPanel1.add(tfSzerzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 320, 20));

        jlSzerzo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlSzerzo, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jlSzerzo.text_1")); // NOI18N
        jPanel1.add(jlSzerzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        tfEv.setText(org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.tfEv.text")); // NOI18N
        jPanel1.add(tfEv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 320, -1));

        jlKiado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlKiado, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jlKiado.text_1")); // NOI18N
        jPanel1.add(jlKiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        tfKiado.setText(org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.tfKiado.text")); // NOI18N
        jPanel1.add(tfKiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 320, -1));

        jlCim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlCim, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jlCim.text_1")); // NOI18N
        jPanel1.add(jlCim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/addbook/information-icon-6102.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jLabel1.text")); // NOI18N
        jLabel1.setToolTipText(org.openide.util.NbBundle.getMessage(addbooksTopComponent.class, "addbooksTopComponent.jLabel1.toolTipText")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 40, 40));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddBookActionPerformed
        try {
         sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect();
             
             String sqlS ="INSERT INTO konyvek(idkonyvek, cim, szerzo, kiado, kiadaseve, pdflink,konyvszam,isKolcsonozve) VALUES (?,?,?,?,?,?,1,0) ";
             String sqlC ="SELECT max(idkonyvek) from konyvek;";
             String sqlCim = "select idkonyvek from konyvek where cim like ? ";
             String sqlU= "update konyvek set konyvszam=konyvszam+1 where idkonyvek=?";
             PreparedStatement pstC = conn.prepareStatement(sqlC);
             PreparedStatement pst = conn.prepareStatement(sqlS);
             PreparedStatement pstcim = conn.prepareStatement(sqlCim);
             PreparedStatement pstU = conn.prepareStatement(sqlU);
             ResultSet rsC = pstC.executeQuery();
             pstcim.setString(1, tFCim.getText());
             ResultSet rscim = pstcim.executeQuery();

             int konyvid = 0;
             int cimid =0;
                     
             if(rsC.next()){
                konyvid =rsC.getInt(1);
             }
             
             if(rscim.next()){
                cimid =rscim.getInt(1);
             }
                
             if (cimid==0) {
                 pst.setInt(1, konyvid+1);
             pst.setString(2, tFCim.getText());
             pst.setString(3, tfSzerzo.getText());
             pst.setString(4, tfKiado.getText());
             pst.setInt(5, Integer.valueOf(tfEv.getText()));
             pst.setString(6, tfLink.getText());
               pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sikeresen hozzáadtad a könyvet!");
            }else if(cimid>0){
                pstU.setInt(1, rscim.getInt(1));
                    pstU.executeUpdate();
            }
            
             pstcim.close();
             pstU.close();
             pst.close();
             pstC.close();
             
             conn.close();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
           
    }//GEN-LAST:event_jbtnAddBookActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
      JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF fájlok", "pdf");
              fileChooser.setFileFilter(filter);
      int response = fileChooser.showOpenDialog(null);
     
        if (response == JFileChooser.APPROVE_OPTION) {
            String File = fileChooser.getSelectedFile().getAbsolutePath().replace('\\','/');
            tfLink.setText(File);
        }
    }//GEN-LAST:event_btnFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnAddBook;
    private javax.swing.JLabel jlCim;
    private javax.swing.JLabel jlKiadasEv;
    private javax.swing.JLabel jlKiado;
    private javax.swing.JLabel jlLink;
    private javax.swing.JLabel jlSzerzo;
    private java.awt.TextField tFCim;
    private java.awt.TextField tfEv;
    private java.awt.TextField tfKiado;
    private java.awt.TextField tfLink;
    private java.awt.TextField tfSzerzo;
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
