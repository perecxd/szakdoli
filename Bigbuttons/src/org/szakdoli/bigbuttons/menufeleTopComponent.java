/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/templateTopComponent637.java to edit this template
 */
package org.szakdoli.bigbuttons;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.szakdoli.bigbuttons//menufele//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "menufeleTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.szakdoli.bigbuttons.menufeleTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_menufeleAction",
        preferredID = "menufeleTopComponent"
)
@Messages({
    "CTL_menufeleAction=menufele",
    "CTL_menufeleTopComponent=menufele Window",
    "HINT_menufeleTopComponent=This is a menufele window"
})
public final class menufeleTopComponent extends TopComponent {

    public menufeleTopComponent() {
        initComponents();
        setName(Bundle.CTL_menufeleTopComponent());
        setToolTipText(Bundle.HINT_menufeleTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBook = new javax.swing.JButton();
        btnKolcson = new javax.swing.JButton();
        btnmanager = new javax.swing.JButton();
        btnTag = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBook.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnBook, org.openide.util.NbBundle.getMessage(menufeleTopComponent.class, "menufeleTopComponent.btnBook.text")); // NOI18N
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        jPanel1.add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 210, 60));

        btnKolcson.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnKolcson, org.openide.util.NbBundle.getMessage(menufeleTopComponent.class, "menufeleTopComponent.btnKolcson.text")); // NOI18N
        btnKolcson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKolcsonActionPerformed(evt);
            }
        });
        jPanel1.add(btnKolcson, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 210, 60));

        btnmanager.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnmanager, org.openide.util.NbBundle.getMessage(menufeleTopComponent.class, "menufeleTopComponent.btnmanager.text")); // NOI18N
        btnmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmanagerActionPerformed(evt);
            }
        });
        jPanel1.add(btnmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 210, 60));

        btnTag.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnTag, org.openide.util.NbBundle.getMessage(menufeleTopComponent.class, "menufeleTopComponent.btnTag.text")); // NOI18N
        btnTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagActionPerformed(evt);
            }
        });
        jPanel1.add(btnTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 210, 60));

        btnRead.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnRead, org.openide.util.NbBundle.getMessage(menufeleTopComponent.class, "menufeleTopComponent.btnRead.text")); // NOI18N
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        jPanel1.add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 210, 60));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmanagerActionPerformed
       WindowManager.getDefault().findTopComponent("ManagerTopComponent").open(); 
        WindowManager.getDefault().findTopComponent("ManagerTopComponent").requestActive(); 
       
    }//GEN-LAST:event_btnmanagerActionPerformed

    private void btnKolcsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKolcsonActionPerformed
        WindowManager.getDefault().findTopComponent("borrowBooksTopComponent").open(); 
        WindowManager.getDefault().findTopComponent("borrowBooksTopComponent").requestActive(); 
    }//GEN-LAST:event_btnKolcsonActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
         WindowManager.getDefault().findTopComponent("addbooksTopComponent").open(); 
        WindowManager.getDefault().findTopComponent("addbooksTopComponent").requestActive(); 
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
         WindowManager.getDefault().findTopComponent("pdfolvasoTopComponent").open(); 
        WindowManager.getDefault().findTopComponent("pdfolvasoTopComponent").requestActive(); 
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagActionPerformed
         WindowManager.getDefault().findTopComponent("addmemberTopComponent").open(); 
        WindowManager.getDefault().findTopComponent("addmemberTopComponent").requestActive(); 
    }//GEN-LAST:event_btnTagActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnKolcson;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnTag;
    private javax.swing.JButton btnmanager;
    private javax.swing.JPanel jPanel1;
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