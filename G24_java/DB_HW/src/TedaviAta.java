
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TedaviAta extends javax.swing.JFrame {

    int hastaID;
    PatientList patientList;

    public TedaviAta(int hastaID, PatientList patientList) throws SQLException {
        initComponents();
        this.hastaID = hastaID;
        this.patientList = patientList;
        String query = "select h_tdv from hasta where hasta_id=?";
        PreparedStatement stat = MainScreen.conn.prepareStatement(query);
        stat.setInt(1, hastaID);

        ResultSet rs = stat.executeQuery();
        rs.next();
        Integer tedaviId;
        tedaviId = rs.getInt(1);
        if (rs.wasNull() == false) {
            query = "select * from tedavi where tedavi_id=?";
            stat = MainScreen.conn.prepareStatement(query);
            stat.setInt(1, tedaviId);
            rs = stat.executeQuery();
            rs.next();
            tipTextField.setText(rs.getString(2));
            ilacTextField.setText(rs.getString(3));
            ekTextField.setText(rs.getString(4));
        }
        stat.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tipTextField = new javax.swing.JTextField();
        ilacTextField = new javax.swing.JTextField();
        ekTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tedavi Atama");

        jLabel1.setText("Tip:");

        jLabel2.setText("İlaç:");

        jLabel3.setText("Ek:");

        tipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipTextFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Kaydet");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("İptal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ekTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ilacTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ilacTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ekTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            String query = "update hasta set h_tdv=tedavi_protokol(?,?,?) where hasta_id=?";
            PreparedStatement stat = MainScreen.conn.prepareStatement(query);
            stat.setString(1, tipTextField.getText().trim());
            stat.setString(2, ilacTextField.getText().trim());
            stat.setString(3, ekTextField.getText().trim());
            stat.setInt(4, hastaID);
            stat.execute();
            stat.close();
            patientList.updateHastaTablosu();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(TedaviAta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dispose();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField ekTextField;
    private javax.swing.JTextField ilacTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField tipTextField;
    // End of variables declaration//GEN-END:variables
}
