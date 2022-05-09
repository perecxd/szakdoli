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
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
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
        Object obj2[]= {"ID","Cím","Név","Igazolványszám"};
        Object obj3[]={"ID","Név","Lakcím","Igazolványszám","Telefonszám","Születési Dátum"};
         model.setColumnIdentifiers(obj);
         model2.setColumnIdentifiers(obj2);
         model23.setColumnIdentifiers(obj3);
        jTable1.setModel(model);
        jTable4.setModel(model2);
        jTable5.setModel(model23);
        jButton2.setText("");
        jButton3.setText("");
        updateT();
        updateT2();
        updateT3();
        jLabel1.setText(Integer.toString(jSlider1.getValue()));
        

    }
     DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model23 = new DefaultTableModel();
    Connection conn;
    
    
    
    
     public void updateT() {
        try {
           /* Class.forName("com.mysql.jdbc.Driver");*/
           Class.forName("org.sqlite.JDBC");
           sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
           
          String sql ="SELECT idkonyvek, cim, szerzo, kiado, kiadaseve from konyvek";
          String sql2 = "select konyvszam - isKolcsonozve from konyvek";
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
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
   }
     
         public void updateT2(){
        try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
          String sql ="SELECT idkolcsonzes,nev,telszam from kolcsonzes";
          String SQL2="select cim from konyvek inner join kolcsonzes on konyvek.idkonyvek=kolcsonzes.konyvid;";
          PreparedStatement pst = conn.prepareStatement(sql);
          PreparedStatement pst2 = conn.prepareStatement(SQL2);
                ResultSet rs = pst.executeQuery();
                ResultSet rs2 = pst2.executeQuery();
                Object[] columnData = new Object[4];
                
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
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
          String sql ="SELECT idmembers, nev, lakcim, igazolvany, telszam, szuldate from members";
         
          PreparedStatement pst = conn.prepareStatement(sql);
         
            
                ResultSet rs = pst.executeQuery();
                Object[] columnData = new Object[6];
                
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
        jTable1 = new javax.swing.JTable();
        btnDelete1 = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        btnMinus1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnMinus2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        btnMinus3 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 320));

        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/TÖRÖL.jpg"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnDelete1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnDelete1.text")); // NOI18N
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 60));

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/PLUSZJEL.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnAdd1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnAdd1.text")); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 100, 60));

        btnMinus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/minus.jpg"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnMinus1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnMinus1.text")); // NOI18N
        btnMinus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinus1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 100, 60));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/frissítl.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 30, 30));

        jSlider1.setMaximum(69);
        jSlider1.setMinimum(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel1.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 110, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jLabel1.text")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 30, 20));

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 320));

        btnMinus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/minus.jpg"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnMinus2, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnMinus2.text")); // NOI18N
        btnMinus2.setToolTipText(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnMinus2.toolTipText")); // NOI18N
        btnMinus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinus2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnMinus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 60));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/frissítl.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 30, 30));

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable5);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 320));

        btnMinus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/szakdoli/dbmanager/minus.jpg"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnMinus3, org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnMinus3.text")); // NOI18N
        btnMinus3.setToolTipText(org.openide.util.NbBundle.getMessage(ManagerTopComponent.class, "ManagerTopComponent.btnMinus3.toolTipText")); // NOI18N
        btnMinus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinus3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnMinus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 60));

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
        Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
            String sqlD ="delete from konyvek where idkonyvek = ?";
            String sqlK = "select konyvszam,isKolcsonozve from konyvek where idkonyvek =?";
            String sql4 = "update konyvek set konyvszam=? where idkonyvek=?";
            int konyvszam = 0;
            int konyvid ;
            PreparedStatement pst = conn.prepareStatement(sqlD);
            PreparedStatement pst4 = conn.prepareStatement(sql4);
            PreparedStatement pstK = conn.prepareStatement(sqlK);
            int row= jTable1.getSelectedRow();
            konyvid = (int)jTable1.getModel().getValueAt(row, 0);
            pst.setInt(1, konyvszam);
            pstK.setInt(1, konyvid);
            ResultSet rsk = pstK.executeQuery();
            int ksz=0;
             if (rsk.next()) {
                konyvszam=rsk.getInt(1);
                ksz=rsk.getInt(2);
            } 
             if((konyvszam-ksz)==0){
                 JOptionPane.showMessageDialog(null, "Vannak még kikölcsönzött könyvek, nem tudod törölni");
             }else { if (konyvszam>1) {
                              
                                    konyvszam--;
                pst4.setInt(1, konyvszam);
                  pst4.setInt(2,konyvid);
                   pst4.execute();
             
             
          }else if (konyvszam==1) {
               
               pst.setInt(1, konyvid);
             
             pst.execute();
          }
             }

            
            
        
             pstK.close();
             pst4.close();
             pst.close();
            conn.close();
                 updateT();
        updateT2();
        updateT3();
           
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_btnMinus1ActionPerformed

    private void btnMinus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinus2ActionPerformed
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
            
            int row= jTable4.getSelectedRow();
            String kCim = jTable4.getModel().getValueAt(row,1).toString() ;
            kolcsonid = (int)jTable4.getModel().getValueAt(row, 0);
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
            
            pst4.execute();
            pst.execute();
            
            
            
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
                                             
    }//GEN-LAST:event_btnMinus2ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        try {
             sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
            String sqlC = "UPDATE konyvek set konyvszam=? where idkonyvek=? ";
            String sqlS = "select konyvszam from konyvek where idkonyvek=?";

            int row = jTable1.getSelectedRow();
            PreparedStatement pst = conn.prepareStatement(sqlS);
            PreparedStatement pstS = conn.prepareStatement(sqlC);
            int  konyvid = (int)jTable1.getModel().getValueAt(row, 0);
            pstS.setInt(2, konyvid);
            pst.setInt(1,konyvid );

            ResultSet rs = pst.executeQuery();
            int konyvszam = 0;
            while (rs.next()) {
                konyvszam =rs.getInt(1);
            }
            pstS.setInt(1, konyvszam+jSlider1.getValue());

            pstS.execute();
            pstS.close();

            conn.close();
            pst.close();
                 updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }


    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnMinus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinus3ActionPerformed
       try {
            sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
            String sqlD ="delete from members where idmembers = ?";

            PreparedStatement pst = conn.prepareStatement(sqlD);
            
            int row= jTable5.getSelectedRow();
          
            int konyvid = (int)jTable5.getModel().getValueAt(row, 0);
            pst.setInt(1, konyvid);
            pst.execute();

             pst.close();
            conn.close();
               updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_btnMinus3ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
       try {
             sqlkonnekcio dbc = new sqlkonnekcio();
            conn = dbc.connect(); //DriverManager.getConnection("jdbc:mysql://localhost:3306/szakdoli","root","Lampa123");
            String sqlD ="delete from konyvek where idkonyvek = ?";

            PreparedStatement pst = conn.prepareStatement(sqlD);
            
            int row= jTable1.getSelectedRow();
          
            int konyvid = (int)jTable1.getModel().getValueAt(row, 0);
            pst.setInt(1, konyvid);
            pst.execute();

             pst.close();
            conn.close();
               updateT();
        updateT2();
        updateT3();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
                                             
                                             
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
      jLabel1.setText(Integer.toString(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnMinus1;
    private javax.swing.JButton btnMinus2;
    private javax.swing.JButton btnMinus3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
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
