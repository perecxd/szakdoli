/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/templateTopComponent637.java to edit this template
 */
package org.szakdoli.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
import org.szakdoli.konnekcio.sqlkonnekcio;
import org.szakdoli.mail.sendmail;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.szakdoli.dbmanager//Manager//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ManagerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_NEVER
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.szakdoli.dbmanager.ManagerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ManagerAction",
        preferredID = "ManagerTopComponent"
)
@Messages({
    "CTL_ManagerAction=Manager",
    "CTL_ManagerTopComponent=Manager Window",
    "HINT_ManagerTopComponent=This is a Manager window"
})
public final class ManagerTopComponent extends TopComponent {

    public ManagerTopComponent() {
        initComponents();
        setName(Bundle.CTL_ManagerTopComponent());
        setToolTipText(Bundle.HINT_ManagerTopComponent());
         Object obj []= {"ID","Cím","Szerző","Kiadó","Kiadáséve","Elérhető db"};
        Object obj2[]= {"ID","Cím","Név","Igazolványszám","Határidő"};
        Object obj3[]={"ID","Név","Lakcím","Igazolványszám","Telefonszám","Születési Dátum,","E-mail cím"};
         model.setColumnIdentifiers(obj);
         model2.setColumnIdentifiers(obj2);
         model23.setColumnIdentifiers(obj3);
        jtKonyv.setModel(model);
        jtKolcson.setModel(model2);
        jtTagok.setModel(model23);

        updateT();
        updateT2();
        updateT3();
      
        

    }
     DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model23 = new DefaultTableModel();
    Connection conn;
    
    
    
    
     public void updateT() {
        try {
          
           sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); 
           
          String sql ="SELECT idkonyvek, cim, szerzo, kiado, kiadaseve from konyvek order by cim ASC";
          String sql2 = "select konyvszam - isKolcsonozve from konyvek order by cim ASC";
          PreparedStatement pst = conn.prepareStatement(sql);
          PreparedStatement pst2 = conn.prepareStatement(sql2);
                ResultSet rs2= pst2.executeQuery();
                ResultSet rs = pst.executeQuery();
                Object[] columnData = new Object[6];
                
                   if (model.getRowCount()>0){
                    for (int i = model.getRowCount()-1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }

                while(rs.next()&&rs2.next()){
                    columnData[0]= rs.getInt("idkonyvek");
                    columnData[1]= rs.getString("cim");
                    columnData[2]= rs.getString("szerzo");
                    columnData[3]= rs.getString("kiado");
                    columnData[4]= rs.getString("kiadaseve");
                    columnData[5]= rs2.getInt(1);
                    
                    
                    model.addRow(columnData);
                    
                }
           conn.close();
           pst.close();
           pst2.close();
           
                
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
   }
     
         public void updateT2(){
        try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); 
          String sql ="SELECT idkolcsonzes,nev,telszam,vissza from kolcsonzes";
          String SQL2="select cim from konyvek inner join kolcsonzes on konyvek.idkonyvek=kolcsonzes.konyvid;";
          PreparedStatement pst = conn.prepareStatement(sql);
          PreparedStatement pst2 = conn.prepareStatement(SQL2);
                ResultSet rs = pst.executeQuery();
                ResultSet rs2 = pst2.executeQuery();
                Object[] columnData = new Object[5];
                
                   if (model2.getRowCount()>0){
                    for (int i = model2.getRowCount()-1; i > -1; i--) {
                        model2.removeRow(i);
                    }
                }

                while(rs.next()&& rs2.next()){
                    columnData[0]= rs.getInt("idkolcsonzes");
                    columnData[1]= rs2.getString("cim");
                    columnData[2]= rs.getString("nev");
                    columnData[3]= rs.getString("telszam");
                    columnData[4]= rs.getString(4);
                    
                    
                    model2.addRow(columnData);
                    
                }
                pst.close();
                pst2.close();
                conn.close();
                
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
   }
         
         
         
         
         
         
         
          public void updateT3(){
        try {
             sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); 
          String sql ="SELECT idmembers, nev, lakcim, igazolvany, telszam, szuldate,mail from members";
         
          PreparedStatement pst = conn.prepareStatement(sql);
         
            
                ResultSet rs = pst.executeQuery();
                Object[] columnData = new Object[7];
                
                   if (model23.getRowCount()>0){
                    for (int i = model23.getRowCount()-1; i > -1; i--) {
                        model23.removeRow(i);
                    }
                }

                while(rs.next()){
                    columnData[0]= rs.getInt(1);
                    columnData[1]= rs.getString(2);
                    columnData[2]= rs.getString(3);
                    columnData[3]= rs.getString(4);
                    columnData[4]= rs.getInt(5);
                    columnData[5]= rs.getString(6);
                    columnData[6]= rs.getString(7);
                    
                    
                    model23.addRow(columnData);
                    
                }
           conn.close();
           pst.close();
         
           
                
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
   }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtKonyv = new javax.swing.JTable();
        btnDelete1 = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        btnMinus1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtKolcson = new javax.swing.JTable();
        btnDelete2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnReminder = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtTagok = new javax.swing.JTable();
        btnDelete3 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtKonyv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtKonyv);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 320));

        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnDelete1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnDelete1.text")); // NOI18N
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 120, 60));

        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnAdd1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnAdd1.text")); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 130, 60));

        btnMinus1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnMinus1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnMinus1.text")); // NOI18N
        btnMinus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinus1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 130, 60));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/frissítl.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 30, 30));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 70, 60));

        jSpinner2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 70, 60));

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtKolcson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jtKolcson);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 320));

        btnDelete2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnDelete2, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnDelete2.text")); // NOI18N
        btnDelete2.setToolTipText(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnDelete2.toolTipText")); // NOI18N
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 100, 60));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/frissítl.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 30, 30));

        btnReminder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnReminder, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnReminder.text")); // NOI18N
        btnReminder.setToolTipText(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnReminder.toolTipText")); // NOI18N
        btnReminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReminderActionPerformed(evt);
            }
        });
        jPanel2.add(btnReminder, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 260, 60));

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTagok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jtTagok);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 320));

        btnDelete3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnDelete3, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnDelete3.text")); // NOI18N
        btnDelete3.setToolTipText(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnDelete3.toolTipText")); // NOI18N
        btnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 100, 60));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/frissítl.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 30, 30));

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 940, 560));

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           updateT();
        updateT2();
        updateT3();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           updateT();
        updateT2();
        updateT3();
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           updateT();
        updateT2();
        updateT3();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMinus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinus1ActionPerformed
       try {
        sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect();
          
            String sqlK = "select konyvszam,isKolcsonozve from konyvek where idkonyvek =?";
            String sql4 = "update konyvek set konyvszam=? where idkonyvek=?";
            int konyvszam = 0;
            int konyvid ;
            
            PreparedStatement pst4 = conn.prepareStatement(sql4);
            PreparedStatement pstK = conn.prepareStatement(sqlK);
            int row= jtKonyv.getSelectedRow();
            konyvid = (int)jtKonyv.getModel().getValueAt(row, 0);
           
            pstK.setInt(1, konyvid);
            ResultSet rsk = pstK.executeQuery();
            int ksz=0;
            int spinnerertek2 = (int)jSpinner2.getValue();
             if (rsk.next()) {
                konyvszam=rsk.getInt(1);
                ksz=rsk.getInt(2);
            } 
             int vegsoertek = konyvszam-spinnerertek2;
             int elerheto = konyvszam-ksz;
             if(elerheto < spinnerertek2 ){
                 JOptionPane.showMessageDialog(null, "Az elérhető könyvek száma ezzel 0 alá csökkenne!");
             }else{
                  
             
             pst4.setInt(1, vegsoertek);
                  pst4.setInt(2,konyvid);
                   pst4.executeUpdate();
             }
 
        
             pstK.close();
             pst4.close();
           
            conn.close();
                 updateT();
        updateT2();
        updateT3();
           
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_btnMinus1ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
         try {
           /* Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");*/
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
            String sqlD ="delete from kolcsonzes where idkolcsonzes = ?";
            String sql3 = "Select idkonyvek from konyvek where cim =?";
            String sqlK = "select isKolcsonozve from konyvek where idkonyvek =?";
            String sql4 = "update konyvek set isKolcsonozve=? where idkonyvek=?";
            int kolcsonid = 0;
            PreparedStatement pst = conn.prepareStatement(sqlD);
            PreparedStatement pst3 = conn.prepareStatement(sql3);
            PreparedStatement pst4 = conn.prepareStatement(sql4);
            PreparedStatement pstK = conn.prepareStatement(sqlK);
            
            int row= jtKolcson.getSelectedRow();
            String kCim = jtKolcson.getModel().getValueAt(row,1).toString() ;
            kolcsonid = (int)jtKolcson.getModel().getValueAt(row, 0);
            pst.setInt(1, kolcsonid);
            pst3.setString(1, kCim);
            ResultSet rs3 = pst3.executeQuery();
            
            
            int konyvid = 0;
            int kolcsonszam=0;
           
            if (rs3.next()) {
                konyvid= rs3.getInt(1);
                
            }
            pstK.setInt(1, konyvid);
            ResultSet rsk = pstK.executeQuery();
            
             if (rsk.next()) {
                kolcsonszam=rsk.getInt(1);
            } 
            pst4.setInt(1,kolcsonszam-1 );
            pst4.setInt(2,konyvid);
            
            pst4.executeUpdate();
            pst.executeUpdate();
            
            
            
             pst3.close();
             pstK.close();
             pst4.close();
             pst.close();
            conn.close();
             updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
                                             
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        try {
             sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); 
            String sqlC = "UPDATE konyvek set konyvszam=? where idkonyvek=? ";
            String sqlS = "select konyvszam from konyvek where idkonyvek=?";
            int row = jtKonyv.getSelectedRow();
            PreparedStatement pst = conn.prepareStatement(sqlS);
            PreparedStatement pstC = conn.prepareStatement(sqlC);
          
            int  konyvid = (int)jtKonyv.getModel().getValueAt(row, 0);
            pstC.setInt(2, konyvid);
            pst.setInt(1,konyvid );      

            ResultSet rs = pst.executeQuery();
            int konyvszam = 0;
            
            while (rs.next()) {
                konyvszam =rs.getInt(1);
            }   
            int spinnerertek = (int)jSpinner1.getValue();
            int vegsoertek=(konyvszam+spinnerertek);
          
                 pstC.setInt(1, vegsoertek);
                 pstC.executeUpdate();  
            pstC.close();
              pst.close();
            conn.close();
          
                 updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }


    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete3ActionPerformed
       try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); 
            String sqlD ="delete from members where idmembers = ?";
             

            PreparedStatement pst = conn.prepareStatement(sqlD);
            
            int row= jtTagok.getSelectedRow();
          
            int konyvid = (int)jtTagok.getModel().getValueAt(row, 0);
            pst.setInt(1, konyvid);
            pst.executeUpdate();

             pst.close();
            conn.close();
               updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_btnDelete3ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
       try {
             sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
            String sqlD ="delete from konyvek where idkonyvek = ?";
            String sqlSzam = "select isKolcsonozve from konyvek where idkonyvek=? ";

            PreparedStatement pst = conn.prepareStatement(sqlD);
            PreparedStatement pstS = conn.prepareStatement(sqlSzam);
           
            
            int row= jtKonyv.getSelectedRow();
          
            int konyvid = (int)jtKonyv.getModel().getValueAt(row, 0);
            pst.setInt(1, konyvid);
             pstS.setInt(1,konyvid);
             ResultSet rs = pstS.executeQuery();
             while (rs.next()) {               
                 if (rs.getInt(1)!=0) {
                      JOptionPane.showMessageDialog(null, "Vannak még kikölcsönzött könyvek, nem tudod törölni!");
                 }else{
                     pst.executeUpdate();
           }
               
           }
            
             pstS.close();
             pst.close();
            conn.close();
               updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
                                             
                                             
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReminderActionPerformed
 try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); 
          String sql ="SELECT nev,vissza,email from kolcsonzes where idkolcsonzes =?" ;
          PreparedStatement pst = conn.prepareStatement(sql);
          
                      int row= jtKolcson.getSelectedRow();
            int kolcsid = (int)jtKolcson.getModel().getValueAt(row, 0);
            String cim =jtKolcson.getModel().getValueAt(row, 1).toString();
                pst.setInt(1, kolcsid);
               
                ResultSet rs = pst.executeQuery();
   
              String nev="";
               String vissza="";
                String hova ="";
                while(rs.next()){
                  nev = rs.getString("nev");
                 vissza  = rs.getString("vissza");
                 hova = rs.getString("email");

                }
                if (hova.equals("nincs")||hova.equals("")) {
               JOptionPane.showMessageDialog(null, "Nincs e-mail címe a felhasználónak!");
     }else{
                sendmail.mailreminder(hova, nev, cim, vissza);
                }
                pst.close();
                
                conn.close();
                
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (MessagingException ex) {
            Exceptions.printStackTrace(ex);
        }
             }//GEN-LAST:event_btnReminderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnMinus1;
    private javax.swing.JButton btnReminder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtKolcson;
    private javax.swing.JTable jtKonyv;
    private javax.swing.JTable jtTagok;
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
