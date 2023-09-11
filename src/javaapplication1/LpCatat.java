/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class LpCatat extends javax.swing.JFrame {
        Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    DefaultTableModel data;
    

    /**
     * Creates new form browse
     */
    public LpCatat() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        load_datap();
        awal();
    }
     private void load_program(){
           Object header[]={"kode","Nama","Keterangan"};
           data = new DefaultTableModel(null,header);
           
           try {
               sql = "SELECT * FROM tbprogram";
               stat = con.createStatement();
               rs = stat.executeQuery(sql);
               while (rs.next()) {                   

                   String k2 = rs.getString(2);
                   String k3 = rs.getString(3);
                   String k4 = rs.getString(4);
           
                   String k[] = {k2,k3,k4};
                   data.addRow(k);
               }
               jTable2.setModel(data);
                   jDialog2.setVisible(true);
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
       }
    private void load_datap(){
           Object header[]={"kode Catat","kode Program","Nama Program","penganan","date","keterangan","Status"};
           data = new DefaultTableModel(null,header);
           
           try {
               sql = "SELECT * FROM tbctat";
               stat = con.createStatement();
               rs = stat.executeQuery(sql);
               while (rs.next()) {                   

                   String k2 = rs.getString(2);
                   String k3 = rs.getString(3);
                   String k4 = rs.getString(4);
                   String k5 = rs.getString(5);
                   String k6 = rs.getString(6);
                   String k7 = rs.getString(7);
                   String k8 = rs.getString(8);
                   String k[] = {k2,k3,k4,k5,k6,k7,k8};
                   data.addRow(k);
               }
               jTable1.setModel(data);
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
       }
    private void awal(){
        jTextField2.setEnabled(false);
        jButton2.setEnabled(false);
    }
    private void cari(){
           Object header[]={"kode Catat","kode Program","Nama Program","penganan","date","keterangan","status"};
           data = new DefaultTableModel(null,header);
                boolean checkbox1Selected = checkbox1.isSelected();
                boolean checkbox2Selected = checkbox2.isSelected();

         try {

                    if (checkbox1Selected && checkbox2Selected) {
                        // Jika checkbox1 dan checkbox2 dicentang
                        sql = "SELECT * FROM tbctat WHERE kodep ='"+jTextField2.getText()+"'  AND tbctat.status = 'YES';";
                        stat = con.createStatement();
                        rs = stat.executeQuery(sql);

                        // Handle hasil query
                        // ...
                    } else if (checkbox1Selected && !checkbox2Selected) {
                        // Jika checkbox1 dicentang dan checkbox2 tidak dicentang
                        sql = "SELECT * FROM tbctat WHERE kodep = '"+jTextField2.getText()+"';";
                        stat = con.createStatement();
                        rs = stat.executeQuery(sql);
                        // Handle hasil query
                        // ...
                    } else if (!checkbox1Selected && checkbox2Selected) {
                        // Jika checkbox1 tidak dicentang dan checkbox2 dicentang
                        sql = "SELECT * FROM tbctat WHERE tbctat.status = 'YES';";
                        stat = con.createStatement();
                        rs = stat.executeQuery(sql);
                        // Handle hasil query
                        // ...
                    }else if (!checkbox1Selected && !checkbox2Selected){
                        load_datap();
                    }
                    while (rs.next()) {                   

                        String k2 = rs.getString(2);
                        String k3 = rs.getString(3);
                        String k4 = rs.getString(4);
                        String k5 = rs.getString(5);
                        String k6 = rs.getString(6);
                        String k7 = rs.getString(7);
                        String k8 = rs.getString(8);
                        String k[] = {k2,k3,k4,k5,k6,k7,k8};
                        data.addRow(k);
               }
               jTable1.setModel(data);
               jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }



//            if (jCheckBox3.isSelected()) {
//            jTextField1.setText("YES");
//            }else{
//            jTextField1.setText("NO");
//            }
//        boolean checkbox1Selected = jCheckBox2.isSelected();
//        boolean checkbox2Selected = jCheckBox3.isSelected();
//        if (checkbox1Selected && checkbox2Selected){
//            Object header[]={"kode Catat","kode Program","Nama Program","penganan","date","keterangan","status"};
//           data = new DefaultTableModel(null,header);
//           
//           try {
//               sql = "SELECT * FROM tbctat WHERE kodep ='"+jTextField2.getText()+"'AND tbctat.status='YES';";
//               stat = con.createStatement();
//               rs = stat.executeQuery(sql);
//               while (rs.next()) {                   
//
//                   String k2 = rs.getString(2);
//                   String k3 = rs.getString(3);
//                   String k4 = rs.getString(4);
//                   String k5 = rs.getString(5);
//                   String k6 = rs.getString(6);
//                   String k7 = rs.getString(7);
//                   String k8 = rs.getString(8);
//                   String k[] = {k2,k3,k4,k5,k6,k7,k8};
//                   data.addRow(k);
//               }
//               jTable1.setModel(data);
//               jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//               
//           } catch (Exception e) {              
//               JOptionPane.showMessageDialog(null, e);
//           }        
//                      
//        }else if(checkbox1Selected && !checkbox2Selected){
//        }
//{
//            load_datap();
//        }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog2 = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Cari1 = new javax.swing.JToggleButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Cari = new javax.swing.JButton();
        checkbox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        checkbox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        jDialog2.setTitle("Brows Kode");
        jDialog2.setMinimumSize(new java.awt.Dimension(500, 260));
        jDialog2.setResizable(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        Cari1.setText("Cari");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cari1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laporan Catatan");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setAutoCreateRowSorter(true);
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
        jTable1.setToolTipText("");
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);

        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        checkbox1.setText("Program");
        checkbox1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkbox1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        checkbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox1ActionPerformed(evt);
            }
        });

        checkbox2.setText("Selesai");
        checkbox2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkbox2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        checkbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox2ActionPerformed(evt);
            }
        });

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(checkbox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cari, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkbox1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkbox2)
                    .addComponent(Cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox1ActionPerformed
        // TODO add your handling code here:
    if (checkbox1.isSelected()) {
            jTextField2.setEnabled(true);
            jButton2.setEnabled(true);
        }else{
            jTextField2.setEnabled(false);
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_checkbox1ActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_CariActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int cok = jTable2.getSelectedRow();
        String a = jTable2.getValueAt(cok, 0).toString();
        //    String c = jTable2.getValueAt(cok, 2).toString();
        jTextField2.setText(a);
        jDialog2.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        load_program();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LpCatat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LpCatat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LpCatat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LpCatat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LpCatat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JToggleButton Cari1;
    private javax.swing.JCheckBox checkbox1;
    private javax.swing.JCheckBox checkbox2;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
