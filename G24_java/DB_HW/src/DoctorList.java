import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 * @author ramiz.mmd
 */

public class DoctorList extends javax.swing.JFrame  {
    
    NewDoctor newDoctorFrame;
    EditDoctor editDoctorFrame;
    public DoctorList() throws SQLException{
        initComponents();
        updateDoktorTablosu();
        
        String query = "select * from uzmanlik order by uzmanlik_id";
        Statement stat = MainScreen.conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            FilterUzmanlik.addItem(rs.getInt(1) + " - " + rs.getString(2));
        }
        FilterUzmanlik.setSelectedItem("Tümü");

        
        query = "select * from hastane order by hastane_id";
        stat = MainScreen.conn.createStatement();
        ResultSet rs1 = stat.executeQuery(query);
        while (rs1.next()) {
            HastaneCombo1.addItem(rs1.getInt(1) + " - " + rs1.getString(2));
        }
        
        HastaneCombo1.setSelectedItem("Tümü");
        
        stat.close();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        DoktorTablosu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addDoctor = new javax.swing.JButton();
        deleteDoctor = new javax.swing.JButton();
        editDoctor = new javax.swing.JButton();
        FilterUzmanlik = new javax.swing.JComboBox<>();
        HastaneCombo1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doktor Tablosu");
        setResizable(false);

        DoktorTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ad Soyad", "Uzmanlık", "Hastane", "Baktığı hasta sayısı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DoktorTablosu);
        if (DoktorTablosu.getColumnModel().getColumnCount() > 0) {
            DoktorTablosu.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Doktor Tablosu");

        addDoctor.setText("Doktor Ekle");
        addDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoctorActionPerformed(evt);
            }
        });

        deleteDoctor.setText("Doktor Sil");
        deleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorActionPerformed(evt);
            }
        });

        editDoctor.setText("Doktor Düzenle");
        editDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDoctorActionPerformed(evt);
            }
        });

        FilterUzmanlik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tümü" }));
        FilterUzmanlik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterUzmanlikActionPerformed(evt);
            }
        });

        HastaneCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tümü" }));
        HastaneCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HastaneCombo1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Uzmanlık:");

        jLabel3.setText("Hastane:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HastaneCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FilterUzmanlik, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addDoctor)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteDoctor)
                            .addComponent(jLabel2)
                            .addComponent(FilterUzmanlik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editDoctor)
                            .addComponent(jLabel3)
                            .addComponent(HastaneCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoctorActionPerformed
        try {
            newDoctorFrame = new NewDoctor(this);
            newDoctorFrame.setVisible(true);
            newDoctorFrame.requestFocus();
            newDoctorFrame.setFocusable(true);
            newDoctorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addDoctorActionPerformed

    private void FilterUzmanlikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterUzmanlikActionPerformed
        try {
            updateDoktorTablosu();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FilterUzmanlikActionPerformed

    private void deleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDoctorActionPerformed
                int seciliRow = DoktorTablosu.getSelectedRow();
        if (seciliRow != -1) {
            try {
                int doktorID = (int) DoktorTablosu.getValueAt(seciliRow, 0);
                String query="delete from doktor where doktor_id=?";
                PreparedStatement stat = MainScreen.conn.prepareStatement(query);
                stat.setInt(1, doktorID);
                stat.execute();
                updateDoktorTablosu();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteDoctorActionPerformed

    private void editDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDoctorActionPerformed
        int seciliRow = DoktorTablosu.getSelectedRow();
        if (seciliRow != -1) {
            int doktorID = (int) DoktorTablosu.getValueAt(seciliRow, 0);
            try {
                editDoctorFrame = new EditDoctor(doktorID, this);
            } catch (SQLException ex) {
                Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
            }
            editDoctorFrame.setVisible(true);
            editDoctorFrame.requestFocus();
            editDoctorFrame.setFocusable(true);
            editDoctorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_editDoctorActionPerformed

    private void HastaneCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HastaneCombo1ActionPerformed
        try {
            updateDoktorTablosu();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HastaneCombo1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DoktorTablosu;
    private javax.swing.JComboBox<String> FilterUzmanlik;
    private javax.swing.JComboBox<String> HastaneCombo1;
    private javax.swing.JButton addDoctor;
    private javax.swing.JButton deleteDoctor;
    private javax.swing.JButton editDoctor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void updateDoktorTablosu() throws SQLException {
        DefaultTableModel updateDoktor = (DefaultTableModel) DoktorTablosu.getModel();
        for (int i = DoktorTablosu.getRowCount() - 1; i >= 0; i--) {
            updateDoktor.removeRow(i);
        }
        String query = "SELECT * FROM doktortablo where ";

        if (FilterUzmanlik.getSelectedItem().toString().equals("Tümü") == true) {
            query += "alan is not null ";
        } else {
            String alan = FilterUzmanlik.getSelectedItem().toString().split(" - ")[1];
            query += "alan ='" + alan + "'";
        }
        
        if (HastaneCombo1.getSelectedItem().toString().equals("Tümü") == true) {
            query += " and hastane_adi is not null ";
        } else {
            String hastane = HastaneCombo1.getSelectedItem().toString().split(" - ")[1];
            query += " and hastane_adi ='" + hastane + "'";
        }
        
        Statement stat;

        stat = MainScreen.conn.createStatement();

        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            Object[] row = {rs.getInt(1), rs.getString(2) + " " + rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)};
            updateDoktor.addRow(row);
        }
        stat.close();
    }
}
