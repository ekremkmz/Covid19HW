
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class PatientList extends javax.swing.JFrame {

    NewPatient newPatientFrame;
    TedaviAta tedaviAtaFrame;
    TahlilAta tahlilAtaFrame;

    public PatientList() throws SQLException {
        initComponents();

        updateHastaTablosu();

        String query = "select * from doktor order by doktor_id";
        Statement stat = MainScreen.conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            doktorlarComboBox.addItem(rs.getInt(1) + " - " + rs.getString(2) + " " + rs.getString(3));
        }
        doktorlarComboBox.setSelectedItem("Tümü");
        stat.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hastaTablosu = new javax.swing.JTable();
        deletePatient = new javax.swing.JButton();
        editPatient = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        newPatient = new javax.swing.JButton();
        tedaviButton = new javax.swing.JButton();
        cinsiyetComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        oldCheckBox = new javax.swing.JCheckBox();
        doktorlarComboBox = new javax.swing.JComboBox<>();
        criticCheckBox = new javax.swing.JCheckBox();
        tahlilButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hasta Listesi");
        setResizable(false);

        jLabel1.setText("Hasta Listesi");

        hastaTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ad", "Soyad", "Dogum Tarihi", "Cinsiyet", "Doktor", "Spirometre", "Difüzyon Testi", "Tip", "İlaç", "Ek"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hastaTablosu.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(hastaTablosu);

        deletePatient.setText("Hastayı Sil");
        deletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePatientActionPerformed(evt);
            }
        });

        editPatient.setText("Hastayı Düzenle");
        editPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPatientActionPerformed(evt);
            }
        });

        jLabel4.setText("Filtreleme:");

        newPatient.setText("Yeni Hasta Ekle");
        newPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPatientActionPerformed(evt);
            }
        });

        tedaviButton.setText("Tedavi Protokolü");
        tedaviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tedaviButtonActionPerformed(evt);
            }
        });

        cinsiyetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tümü", "E", "K" }));
        cinsiyetComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinsiyetComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Cinsiyet");

        jLabel3.setText("Doktoru");

        oldCheckBox.setText("65 yaş üstü");
        oldCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCheckBoxActionPerformed(evt);
            }
        });

        doktorlarComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tümü" }));
        doktorlarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doktorlarComboBoxActionPerformed(evt);
            }
        });

        criticCheckBox.setText("Kritik Hastalar");
        criticCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criticCheckBoxActionPerformed(evt);
            }
        });

        tahlilButton.setText("Tahlil Ata");
        tahlilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahlilButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deletePatient, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tahlilButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tedaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doktorlarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cinsiyetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(oldCheckBox)))
                                .addGap(18, 18, 18)
                                .addComponent(criticCheckBox)))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPatient)
                    .addComponent(deletePatient)
                    .addComponent(jLabel4)
                    .addComponent(tedaviButton)
                    .addComponent(cinsiyetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(oldCheckBox)
                    .addComponent(criticCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPatient)
                    .addComponent(jLabel3)
                    .addComponent(doktorlarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tahlilButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPatientActionPerformed
        int seciliRow = hastaTablosu.getSelectedRow();
        if (seciliRow != -1) {
            int hastaID = (int) hastaTablosu.getValueAt(seciliRow, 0);
            try {
                newPatientFrame = new NewPatient(hastaID, this, true);
            } catch (SQLException ex) {
                Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
            }
            newPatientFrame.setVisible(true);
            newPatientFrame.requestFocus();
            newPatientFrame.setFocusable(true);
            newPatientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }


    }//GEN-LAST:event_editPatientActionPerformed

    private void deletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePatientActionPerformed
        int seciliRow = hastaTablosu.getSelectedRow();
        if (seciliRow != -1) {
            try {
                int hastaID = (int) hastaTablosu.getValueAt(seciliRow, 0);
                String query = "delete from hasta where hasta_id=?";
                PreparedStatement stat = MainScreen.conn.prepareStatement(query);
                stat.setInt(1, hastaID);
                stat.execute();
                stat.close();
                updateHastaTablosu();
            } catch (SQLException ex) {
                Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deletePatientActionPerformed

    private void newPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientActionPerformed
        try {
            newPatientFrame = new NewPatient(0, this, false);
            newPatientFrame.setVisible(true);
            newPatientFrame.requestFocus();
            newPatientFrame.setFocusable(true);
            newPatientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newPatientActionPerformed

    private void doktorlarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doktorlarComboBoxActionPerformed
        try {
            updateHastaTablosu();
        } catch (SQLException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_doktorlarComboBoxActionPerformed

    private void cinsiyetComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinsiyetComboBoxActionPerformed
        try {
            updateHastaTablosu();
        } catch (SQLException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cinsiyetComboBoxActionPerformed

    private void oldCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCheckBoxActionPerformed
        try {
            updateHastaTablosu();// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldCheckBoxActionPerformed

    private void tedaviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tedaviButtonActionPerformed
        int seciliRow = hastaTablosu.getSelectedRow();
        if (seciliRow != -1) {
            try {
                int hastaID = (int) hastaTablosu.getValueAt(seciliRow, 0);
                tedaviAtaFrame = new TedaviAta(hastaID, this);
                tedaviAtaFrame.setVisible(true);
                tedaviAtaFrame.requestFocus();
                tedaviAtaFrame.setFocusable(true);
                tedaviAtaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } catch (SQLException ex) {
                Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tedaviButtonActionPerformed

    private void criticCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criticCheckBoxActionPerformed
        try {
            updateHastaTablosu();// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_criticCheckBoxActionPerformed

    private void tahlilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahlilButtonActionPerformed
        int seciliRow = hastaTablosu.getSelectedRow();
        if (seciliRow != -1) {
            try {
                int hastaID = (int) hastaTablosu.getValueAt(seciliRow, 0);
                tahlilAtaFrame = new TahlilAta(hastaID, this);
                tahlilAtaFrame.setVisible(true);
                tahlilAtaFrame.requestFocus();
                tahlilAtaFrame.setFocusable(true);
                tahlilAtaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } catch (SQLException ex) {
                Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tahlilButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cinsiyetComboBox;
    private javax.swing.JCheckBox criticCheckBox;
    private javax.swing.JButton deletePatient;
    private javax.swing.JComboBox<String> doktorlarComboBox;
    private javax.swing.JButton editPatient;
    private javax.swing.JTable hastaTablosu;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newPatient;
    private javax.swing.JCheckBox oldCheckBox;
    private javax.swing.JButton tahlilButton;
    private javax.swing.JButton tedaviButton;
    // End of variables declaration//GEN-END:variables

    public void updateHastaTablosu() throws SQLException {
        DefaultTableModel updateHasta = (DefaultTableModel) hastaTablosu.getModel();
        for (int i = hastaTablosu.getRowCount() - 1; i >= 0; i--) {
            updateHasta.removeRow(i);
        }
        String query = "SELECT * FROM hastatablosu where ";

        if (cinsiyetComboBox.getSelectedItem().toString().equals("Tümü") == true) {
            query += "cinsiyet is not null ";
        } else {
            query += "cinsiyet ='" + cinsiyetComboBox.getSelectedItem().toString() + "' ";
        }
        if (doktorlarComboBox.getSelectedItem().toString().equals("Tümü") == true) {
            query += "and doktor_id is not null ";
        } else {
            query += "and doktor_id =" + doktorlarComboBox.getSelectedItem().toString().split(" - ")[0] + " ";
        }
        if (oldCheckBox.isSelected()) {
            query += "and EXTRACT(YEAR FROM (AGE( dtarih))) > 65 ";
        }
        if (criticCheckBox.isSelected()) {
            query += "and spirometre < 49 and dif_test < 40 ";
        }
        query += " order by hasta_id";
        Statement stat;

        stat = MainScreen.conn.createStatement();

        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            Object[] row = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(7) + " " + rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13)};
            updateHasta.addRow(row);
        }
        stat.close();
    }
}
