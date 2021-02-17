
import java.sql.*;
import javax.swing.JOptionPane;

public class TahlilAta extends javax.swing.JFrame {

    int hastaID;
    PatientList patientList;
    boolean edit;

    public TahlilAta(int hastaID, PatientList patientList) throws SQLException {
        initComponents();
        this.hastaID = hastaID;
        this.patientList = patientList;
        String query = "select h_thl from hasta where hasta_id=?";
        PreparedStatement stat = MainScreen.conn.prepareStatement(query);
        stat.setInt(1, hastaID);

        ResultSet rs = stat.executeQuery();
        rs.next();
        Integer tahlilId;
        tahlilId = rs.getInt(1);
        if (rs.wasNull() == false) {
            edit = true;
            query = "select * from tahlil where tahlil_id=?";
            stat = MainScreen.conn.prepareStatement(query);
            stat.setInt(1, tahlilId);
            rs = stat.executeQuery();
            rs.next();
            spiroTextField.setText(rs.getString(2));
            difTextField.setText(rs.getString(3));
        } else {
            edit = false;
        }
        stat.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spiroTextField = new javax.swing.JTextField();
        difTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tahlil Atama");

        jLabel1.setText("Spirometre Sonucu:");

        jLabel2.setText("Difüzyon Sonucu:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spiroTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(difTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spiroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(difTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if (edit) {
            try {
                String query = "update set spirometere=?,dif_test=? where tahlil_id=?";
                PreparedStatement stat = MainScreen.conn.prepareStatement(query);
                stat.setInt(1, Integer.parseInt(spiroTextField.getText().trim()));
                stat.setInt(2, Integer.parseInt(difTextField.getText().trim()));
                stat.setInt(3, hastaID);
                stat.execute();
                stat.close();
                patientList.updateHastaTablosu();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Sadece sayı formatında veri girebilirsiniz.");
            } catch (SQLException ex) {
                if (ex.getSQLState().equals("42601")) {
                    JOptionPane.showMessageDialog(this, "Spirometre 0 ile 100 arasında, difüzyon testi 0 ile 140 arasında olmalı!!");
                }

            } finally {
                this.dispose();
            }

        } else {
            try {
                String query = "INSERT INTO tahlil (tahlil_id,spirometre, dif_test) VALUES (?,?,?);";
                PreparedStatement stat = MainScreen.conn.prepareStatement(query);
                stat.setInt(1, hastaID);
                stat.setInt(2, Integer.parseInt(spiroTextField.getText().trim()));
                stat.setInt(3, Integer.parseInt(difTextField.getText().trim()));
                stat.execute();

                query = "update hasta set h_thl=? where hasta_id=?";
                stat = MainScreen.conn.prepareStatement(query);
                stat.setInt(1, hastaID);
                stat.setInt(2, hastaID);
                stat.execute();
                stat.close();
                patientList.updateHastaTablosu();
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Sadece sayı formatında veri girebilirsiniz.");
            } catch (SQLException ex) {
                if (ex.getSQLState().equals("23514")) {
                    JOptionPane.showMessageDialog(this, "Spirometre 0 ile 100 arasında, difüzyon testi 0 ile 140 arasında olmalı!!");
                }
            } finally {
                this.dispose();
            }
        }


    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField difTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField spiroTextField;
    // End of variables declaration//GEN-END:variables
}
