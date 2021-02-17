
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class MainScreen extends javax.swing.JFrame {

    public static Connection conn;

    public MainScreen(Connection conn) {
        initComponents();

        this.conn = conn;

        try {
            updateHastaSayiTablosu();
            updateOtherInfos();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        hastaSayiTablosu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        numberOfDoctors = new javax.swing.JLabel();
        showDoctors = new javax.swing.JButton();
        showPatients = new javax.swing.JButton();
        oldRecordsButton = new javax.swing.JButton();
        cureButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        numberofPatients = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numberofCritic = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numberofLazyDoctors = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid 19 Panel");
        setResizable(false);

        hastaSayiTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Anlık Hasta Sayısı", null, null, null}
            },
            new String [] {
                "", "Ayakta", "Servis", "Yoğun Bakım"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(hastaSayiTablosu);

        jLabel2.setText("Doktor sayısı:");

        numberOfDoctors.setText("0");

        showDoctors.setText("Doktorları Görüntüle");
        showDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDoctorsActionPerformed(evt);
            }
        });

        showPatients.setText("Hastaları Görüntüle");
        showPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPatientsActionPerformed(evt);
            }
        });

        oldRecordsButton.setText("Eski Kayıtlar");
        oldRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldRecordsButtonActionPerformed(evt);
            }
        });

        cureButton.setText("Tedavi Protokolleri");
        cureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cureButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tsb.png"))); // NOI18N

        jLabel1.setText("Toplam Hasta Sayısı:");

        numberofPatients.setText("0");

        jLabel5.setText("Kritik Hasta Sayısı:");

        numberofCritic.setText("0");

        jLabel4.setText("Boştaki doktor sayısı:");

        numberofLazyDoctors.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(numberOfDoctors)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(numberofPatients)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(numberofCritic)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(numberofLazyDoctors))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(showDoctors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oldRecordsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(showPatients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(showPatients)
                        .addGap(18, 18, 18)
                        .addComponent(showDoctors)
                        .addGap(18, 18, 18)
                        .addComponent(oldRecordsButton)
                        .addGap(18, 18, 18)
                        .addComponent(cureButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numberOfDoctors)
                    .addComponent(jLabel1)
                    .addComponent(numberofPatients)
                    .addComponent(jLabel5)
                    .addComponent(numberofCritic)
                    .addComponent(jLabel4)
                    .addComponent(numberofLazyDoctors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDoctorsActionPerformed
        try {
            DoctorList doctorList = new DoctorList();
            doctorList.setVisible(true);
            doctorList.requestFocus();
            doctorList.setFocusable(true);
            doctorList.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showDoctorsActionPerformed

    private void showPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPatientsActionPerformed
        try {
            PatientList patientList = new PatientList();
            patientList.setVisible(true);
            patientList.requestFocus();
            patientList.setFocusable(true);
            patientList.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showPatientsActionPerformed

    private void cureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cureButtonActionPerformed
        try {
            CureList cureList = new CureList();
            cureList.setVisible(true);
            cureList.requestFocus();
            cureList.setFocusable(true);
            cureList.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cureButtonActionPerformed

    private void oldRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldRecordsButtonActionPerformed
        try {
            OldRecords oldRecords = new OldRecords();
            oldRecords.setVisible(true);
            oldRecords.requestFocus();
            oldRecords.setFocusable(true);
            oldRecords.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldRecordsButtonActionPerformed

    private void updateHastaSayiTablosu() throws SQLException {
        DefaultTableModel updateHastaSayi = (DefaultTableModel) hastaSayiTablosu.getModel();
        String query = "select *from hastaBilgileriniGetir()";
        Statement stat;

        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(query);

        int i = 1;
        rs.next();
        Object[] row = {"Anlık Hasta Sayısı", rs.getInt(1), rs.getInt(2), rs.getInt(3)};
        updateHastaSayi.removeRow(0);
        updateHastaSayi.addRow(row);
        stat.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cureButton;
    private javax.swing.JTable hastaSayiTablosu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel numberOfDoctors;
    private javax.swing.JLabel numberofCritic;
    private javax.swing.JLabel numberofLazyDoctors;
    private javax.swing.JLabel numberofPatients;
    private javax.swing.JButton oldRecordsButton;
    private javax.swing.JButton showDoctors;
    private javax.swing.JButton showPatients;
    // End of variables declaration//GEN-END:variables

    private void updateOtherInfos() throws SQLException {
        String query = "SELECT COUNT(doktor_id) FROM doktor;";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        rs.next();
        numberOfDoctors.setText(rs.getString(1));

        query = "SELECT COUNT(hasta_id) FROM hasta;";
        stat = conn.createStatement();
        rs = stat.executeQuery(query);
        rs.next();
        numberofPatients.setText(rs.getString(1));

        query = "SELECT COUNT(*) FROM(SELECT tahlil_id FROM tahlil WHERE spirometre < 49 INTERSECT SELECT tahlil_id FROM tahlil WHERE dif_test < 40) I;";
        stat = conn.createStatement();
        rs = stat.executeQuery(query);
        rs.next();
        numberofCritic.setText(rs.getString(1));
        
        query="select count(*) from (SELECT COUNT(h.h_dktr) as hasta_sayisi FROM doktor d LEFT JOIN hasta h ON d.doktor_id = h.h_dktr GROUP BY doktor_id having COUNT(h.h_dktr)=0) tablo";
        stat = conn.createStatement();
        rs = stat.executeQuery(query);
        rs.next();
        numberofLazyDoctors.setText(rs.getString(1));
        stat.close();
    }
}
