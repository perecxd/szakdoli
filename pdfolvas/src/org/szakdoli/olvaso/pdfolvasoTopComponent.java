/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/templateTopComponent637.java to edit this template
 */
package org.szakdoli.olvaso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.lib.awtextra.AbsoluteLayout;
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
        dtd = "-//org.szakdoli.olvaso//pdfolvaso//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "pdfolvasoTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_NEVER
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.szakdoli.olvaso.pdfolvasoTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_pdfolvasoAction",
        preferredID = "pdfolvasoTopComponent"
)
@Messages({
    "CTL_pdfolvasoAction=pdfolvaso",
    "CTL_pdfolvasoTopComponent=pdfolvaso Window",
    "HINT_pdfolvasoTopComponent=This is a pdfolvaso window"
})
public final class pdfolvasoTopComponent extends TopComponent {

    
    public pdfolvasoTopComponent() {
        initComponents();
        setName(Bundle.CTL_pdfolvasoTopComponent());
        setToolTipText(Bundle.HINT_pdfolvasoTopComponent());
        Object obj []= {"Cím","Szerző","Kiadó","Kiadáséve"};
        Object obj2[]= {"ID","Cím","Név","Telefonszám"};
         model.setColumnIdentifiers(obj);
        
        jTable1.setModel(model);
       
        openinapp.setText("Kiválasztott könyv olvasása");
        jButton2.setText("Megnyitás");

        updateT();
  //      updateT2();
    //    updateCB();

    }
    Connection conn;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jScrollPane1 = new JScrollPane();
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        openoutside = new javax.swing.JButton();
        openinapp = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        opennotinapp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtFilePath = new java.awt.TextField();
        btnFileC = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setName(""); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        openoutside.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(openoutside, org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.openoutside.text")); // NOI18N
        openoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openoutsideActionPerformed(evt);
            }
        });
        jPanel1.add(openoutside, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 720, 330, 40));

        openinapp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(openinapp, org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.openinapp.text")); // NOI18N
        openinapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openinappActionPerformed(evt);
            }
        });
        jPanel1.add(openinapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 720, 300, 40));

        updatebtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\HOME\\Documents\\NetBeansProjects\\szakdoga1\\frissítl.png")); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(updatebtn, org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.updatebtn.text")); // NOI18N
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel1.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 70, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 51)));
        jTable1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable1.setRowHeight(40);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jTable1.columnModel.title2")); // NOI18N
            jTable1.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jTable1.columnModel.title3")); // NOI18N
            jTable1.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jTable1.columnModel.title4")); // NOI18N
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 940, 640));

        org.openide.awt.Mnemonics.setLocalizedText(opennotinapp, org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.opennotinapp.text")); // NOI18N
        opennotinapp.setToolTipText(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.opennotinapp.toolTipText")); // NOI18N
        opennotinapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opennotinappActionPerformed(evt);
            }
        });
        jPanel1.add(opennotinapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 260, 20));

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jButton2.text")); // NOI18N
        jButton2.setToolTipText(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.jButton2.toolTipText")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 240, 20));

        txtFilePath.setText(org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.txtFilePath.text")); // NOI18N
        jPanel1.add(txtFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 840, -1));

        org.openide.awt.Mnemonics.setLocalizedText(btnFileC, org.openide.util.NbBundle.getMessage(pdfolvasoTopComponent.class, "pdfolvasoTopComponent.btnFileC.text")); // NOI18N
        btnFileC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileCActionPerformed(evt);
            }
        });
        jPanel1.add(btnFileC, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 30, 20));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1180, 780));

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
   
    //pdf-olvaso in app
    void openpdf(String file){
      try {
           SwingController control=new SwingController();
            SwingViewBuilder factry=new SwingViewBuilder(control);
            JPanel veiwerCompntpnl=factry.buildViewerPanel();
            ComponentKeyBinding.install(control, veiwerCompntpnl);
            control.getDocumentViewController().setAnnotationCallback(
                    new org.icepdf.ri.common.MyAnnotationCallback(
                    control.getDocumentViewController()));
            if (file.contains("https")) {
                URL url = new URL(file);
                  control.openDocument(url);
          }else if(file.contains("Users/")){
              control.openDocument(file);
          }
                  
                 
        jScrollPane1.setViewportView(veiwerCompntpnl); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Cannot Load Pdf");
        }  
    }
    
   
  
   
    public void readerwindow(){
            JFrame myReader = new JFrame();
            myReader.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            BorderLayout b1= new BorderLayout();
            myReader.setLayout(b1);
            myReader.add(jScrollPane1,BorderLayout.CENTER);
            myReader.pack();
            myReader.setPreferredSize(new Dimension(800,600));
            myReader.setMinimumSize(new Dimension(1000,1200));
            myReader.setLocationRelativeTo(null);
            myReader.setVisible(true);
            
    }
   public void updateT(){
        try {
           sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect();
          String sql ="SELECT  cim, szerzo, kiado, kiadaseve from konyvek";
       
          PreparedStatement pst = conn.prepareStatement(sql);
         
              
                ResultSet rs = pst.executeQuery();
                Object[] columnData = new Object[4];
                
                   if (model.getRowCount()>0){
                    for (int i = model.getRowCount()-1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                while(rs.next()){
                    
                    columnData[0]= rs.getString("cim");
                    columnData[1]= rs.getString("szerzo");
                    columnData[2]= rs.getString("kiado");
                    columnData[3]= rs.getString("kiadaseve");
            
                    
                    
                    model.addRow(columnData);
                    
                }
           conn.close();
           pst.close();
    
           
                
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
   }
   

   
   
    private void openinappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openinappActionPerformed
        
     
        try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect();
            String sqlID = "Select idkonyvek from konyvek where cim =?";
            String sqlS1="SELECT pdflink FROM konyvek WHERE idkonyvek = ? ";
            PreparedStatement pst = conn.prepareStatement(sqlS1);
            PreparedStatement pstid = conn.prepareStatement(sqlID);
     
            int row = jTable1.getSelectedRow();
            String kivalS = jTable1.getModel().getValueAt(row, 0).toString();
            pstid.setString(1, kivalS);
            ResultSet rsid = pstid.executeQuery();
            int kival =0;
            if (rsid.next()) {
                kival= rsid.getInt(1);
            }
            
            pst.setInt(1,kival);
            ResultSet rs = pst.executeQuery();
            
        
           
            if(rs.next()){
               
                String ut = rs.getString("pdflink");
              
                 readerwindow();
                 openpdf(ut);
            }
            else{
                JOptionPane.showMessageDialog(null,"Valami hiba történt!");
            }
             
             conn.close();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        
     
       
    }//GEN-LAST:event_openinappActionPerformed

    private void opennotinappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opennotinappActionPerformed
          String ut = txtFilePath.getText();

        try {
            if (ut.contains("https")) {
                 URL url = new URL(ut);
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ url );
            }else if (ut.contains("Users/")) {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ ut );
            }
           
            
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "check file details");
            }
    }//GEN-LAST:event_opennotinappActionPerformed

    private void openoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openoutsideActionPerformed
          try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect();
            
            String sqlS1="SELECT pdflink FROM konyvek WHERE idkonyvek = ? ";
            PreparedStatement pst = conn.prepareStatement(sqlS1);
       // pst.setString(1,txtFilePath.getText());
             int row = jTable1.getSelectedRow();
            int kival = (int)jTable1.getModel().getValueAt(row, 0);
            pst.setInt(1,kival);
            ResultSet rs = pst.executeQuery();
            
            
           
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "jó volt");
                String ut = rs.getString("pdflink");
                if (ut.contains("www.")) {
                     URL url = new URL(ut);
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ url );
                }else {
                    Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ ut );
                }
                
                 
            }
            else{
                JOptionPane.showMessageDialog(null,"Nem volt jó");
            }
             
             conn.close();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_openoutsideActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        updateT();
        //  updateT2();
        // updateCB();

    }//GEN-LAST:event_updatebtnActionPerformed

    private void btnFileCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileCActionPerformed
        
              JFileChooser fileChooser = new JFileChooser();
      int response = fileChooser.showOpenDialog(null);
     
        if (response == JFileChooser.APPROVE_OPTION) {
            String File = fileChooser.getSelectedFile().getAbsolutePath().replace('\\','/');
            txtFilePath.setText(File);
        }
    }//GEN-LAST:event_btnFileCActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String ut = txtFilePath.getText();
        readerwindow();
         openpdf(ut);  
         txtFilePath.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFileC;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton openinapp;
    private javax.swing.JButton opennotinapp;
    private javax.swing.JButton openoutside;
    private java.awt.TextField txtFilePath;
    private javax.swing.JButton updatebtn;
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
