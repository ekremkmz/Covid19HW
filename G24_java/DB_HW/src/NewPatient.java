
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewPatient extends javax.swing.JFrame {

    PatientList patientList;
    boolean edit;
    int hastaID;

    public NewPatient(int hastaID, PatientList patientList, boolean edit) throws SQLException {
        initComponents();
        this.patientList = patientList;
        this.edit = edit;
        this.hastaID = hastaID;
        if (edit) {
            this.setTitle("Hasta Düzenle");
            String query = "select * from hasta where hasta_id=?";
            PreparedStatement stat;
            ResultSet rs;
            //Hasta bilgileri alınıyor
            stat = MainScreen.conn.prepareStatement(query);
            stat.setInt(1, hastaID);
            rs = stat.executeQuery();
            rs.next();
            //Hasta bilgileri gerekli bloklara yerleştiriliyor
            adTextField.setText(rs.getString(2));
            soyadTextField.setText(rs.getString(3));
            dateCalender.setDate(rs.getDate(4));
            cinsiyetComboBox.setSelectedItem(rs.getString(5));
            int doktorID = rs.getInt(7);
            query = "select * from doktor order by doktor_id";
            stat = MainScreen.conn.prepareStatement(query);
            rs = stat.executeQuery();
            while (rs.next()) {
                doktorlarComboBox.addItem(rs.getInt(1) + " - " + rs.getString(2) + " " + rs.getString(3));
                if (rs.getInt(1) == doktorID) {
                    doktorlarComboBox.setSelectedItem(rs.getInt(1) + " - " + rs.getString(2) + " " + rs.getString(3));
                }
            }
            stat.close();
        } else {
            this.setTitle("Yeni Hasta Ekle");
            dateCalender.setDate((new GregorianCalendar(2000, 01, 01)).getTime());
            String query = "select * from doktor order by doktor_id";
            Statement stat = MainScreen.conn.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                doktorlarComboBox.addItem(rs.getInt(1) + " - " + rs.getString(2) + " " + rs.getString(3));
            }
            stat.close();
        }
        dateCalender.setMaxSelectableDate((new GregorianCalendar(2010, 01, 01)).getTime());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        adTextField = new javax.swing.JTextField();
        soyadTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateCalender = new com.toedter.calendar.JCalendar();
        jLabel4 = new javax.swing.JLabel();
        cinsiyetComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        doktorlarComboBox = new javax.swing.JComboBox<>();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ad:");

        jLabel2.setText("Soyad:");

        jLabel3.setText("Doğum Tarihi:");

        jLabel4.setText("Cinsiyet:");

        cinsiyetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E", "K" }));

        jLabel5.setText("Hastanın Doktoru:");

        cancelButton.setText("İptal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Kaydet");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(doktorlarComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(cinsiyetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(soyadTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(adTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateCalender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(adTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(soyadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateCalender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cinsiyetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(doktorlarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String query;
        if (edit) {
            query = "update hasta set ad=?,soyad=?,dtarih=?,cinsiyet=?,h_dktr=? where hasta_id=?";
        } else {
            query = "insert into hasta values (nextval('hasta_seq'), ?, ?, ?, ?, null, ?, null)";
        }

        try {
            PreparedStatement stat = MainScreen.conn.prepareStatement(query);
            stat.setString(1, adTextField.getText());
            stat.setString(2, soyadTextField.getText());
            stat.setDate(3, new Date(dateCalender.getDate().getTime()));
            stat.setString(4, cinsiyetComboBox.getSelectedItem().toString());
            stat.setInt(5, Integer.parseInt(doktorlarComboBox.getSelectedItem().toString().split(" - ")[0]));
            if (edit) {
                stat.setInt(6, hastaID);
            }
            stat.execute();
            patientList.updateHastaTablosu();
            stat.close();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(NewPatient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cinsiyetComboBox;
    private com.toedter.calendar.JCalendar dateCalender;
    private javax.swing.JComboBox<String> doktorlarComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField soyadTextField;
    // End of variables declaration//GEN-END:variables
}
