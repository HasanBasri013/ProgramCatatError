/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class mProgram extends javax.swing.JFrame {
        Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    DefaultTableModel data;

    /**
     * Creates new form mProgram
     */
    public mProgram() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        DefaultTableModel model = new DefaultTableModel();
        awal();
    }
        private void IDotomatis(){
        try {
            String sql = "SELECT * FROM tbprogram order by kodep desc";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                String tcode = rs.getString("kodep").substring(4);
                String NO = ""+(Integer.parseInt(tcode)+1);
                String Nol="";
                if(NO.length()==1){
                    Nol="000";
                }
                else if(NO.length()==2){
                    Nol="00";
                }
                jTextField1.setText("KD"+Nol+NO);
            }
            else{
                jTextField1.setText("KD0001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
public void simpandata(){
       try {
                if (ubahToggle.isSelected()) {
                    
                        // Operasi UPDATE
                        sql = "UPDATE tbprogram SET namap='"+jTextField2.getText()+"', kterp='"+jTextPane1.getText()+"' WHERE kodep='"+jTextField1.getText()+"'";
                        java.sql.PreparedStatement stat=con.prepareStatement(sql);
                        stat.execute();
//                        JOptionPane.showMessageDialog(null, "Ubah Data Berhasil");
                        awal();
                    } else if (tambahToggle.isSelected()) {
                        // Operasi INSERT
                        sql ="INSERT INTO tbprogram (kodep,namap,kterp)VALUES ('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextPane1.getText()+"')";
                        java.sql.PreparedStatement stat=con.prepareStatement(sql);
                        stat.execute();
//                        JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
                        awal();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
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
        public void awal(){
            jLabel6.setText("Browse");
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(false);
        jTextPane1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton5.setEnabled(true);
        ubahToggle.setSelected(false);
        tambahToggle.setSelected(false);
        ubahToggle.setEnabled(true);
        ubahToggle.setEnabled(true);
        tambahToggle.setEnabled(true);
    }
        public void tambah(){
            bersih();
            IDotomatis();
        jLabel6.setText("Tabah");
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(true);
        jTextPane1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton5.setEnabled(false);
        ubahToggle.setEnabled(false);
        }
        public void bersih(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextPane1.setText("");
    }
        public void modeubah(){
            jLabel6.setText("Ubah");
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(true);
        jTextPane1.setEnabled(true);
        jButton2.setEnabled(true);
        tambahToggle.setEnabled(false);
        jButton5.setEnabled(false);
    }
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
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        tambahToggle = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        ubahToggle = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kode");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nama");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Alamat");

        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Master Program");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        tambahToggle.setText("Tambah");
        tambahToggle.setFocusable(false);
        tambahToggle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahToggle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tambahToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahToggleActionPerformed(evt);
            }
        });
        jToolBar1.add(tambahToggle);
        jToolBar1.add(jSeparator1);

        ubahToggle.setText("Ubah");
        ubahToggle.setFocusable(false);
        ubahToggle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ubahToggle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ubahToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahToggleActionPerformed(evt);
            }
        });
        jToolBar1.add(ubahToggle);
        jToolBar1.add(jSeparator2);

        jButton5.setText("Hapus");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator3);

        jLabel5.setText("Mode :");
        jToolBar1.add(jLabel5);

        jLabel6.setText("Status");
        jToolBar1.add(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTextField2.getText().equals("")){
    JOptionPane.showMessageDialog(null, "nama tidak boleh kosong");
        }else{
        int pilih = JOptionPane.showConfirmDialog(null,"Apakah Data Sudah Benar?"+"Simpan?","Simpan Data",JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
          simpandata();          
        }
        else if(pilih == JOptionPane.NO_OPTION){
           System.exit(0);
        }
             }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int cok = jTable2.getSelectedRow();
        String a = jTable2.getValueAt(cok, 0).toString();
        String b = jTable2.getValueAt(cok, 1).toString();
        String c= jTable2.getValueAt(cok, 2).toString();
        //    String c = jTable2.getValueAt(cok, 2).toString();
        jTextField1.setText(a);
        jTextField2.setText(b);
        jTextPane1.setText(b);
        jDialog2.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    load_program();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tambahToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahToggleActionPerformed
        // TODO add your handling code here:
        tambah();
    }//GEN-LAST:event_tambahToggleActionPerformed

    private void ubahToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahToggleActionPerformed
        // TODO add your handling code here:
        modeubah();
    }//GEN-LAST:event_ubahToggleActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int pilih = JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin menghapus?","hapus data",JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
      try {
          con.createStatement().executeUpdate("DELETE FROM tbprogram WHERE kodep='"+jTextField1.getText()+"'");
          JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Gagal");
      }
              load_program();
        }
        else{
//            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(mProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Cari1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToggleButton tambahToggle;
    private javax.swing.JToggleButton ubahToggle;
    // End of variables declaration//GEN-END:variables
}
