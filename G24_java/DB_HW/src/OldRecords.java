
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class OldRecords extends javax.swing.JFrame {

    public OldRecords() throws SQLException {
        initComponents();

        DefaultTableModel updateOldRecords = (DefaultTableModel) oldRecords.getModel();
        String query = "select * from eski_hasta";
        Statement stat = MainScreen.conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            Object[] row = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) + " " + rs.getString(6)};
            updateOldRecords.addRow(row);
        }
        stat.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        oldRecords = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eski Kayıtlar");
        setResizable(false);

        oldRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Silme Tarihi", "Ad", "Soyad", "Doktor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(oldRecords);
        if (oldRecords.getColumnModel().getColumnCount() > 0) {
            oldRecords.getColumnModel().getColumn(0).setResizable(false);
            oldRecords.getColumnModel().getColumn(1).setResizable(false);
            oldRecords.getColumnModel().getColumn(2).setResizable(false);
            oldRecords.getColumnModel().getColumn(3).setResizable(false);
            oldRecords.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable oldRecords;
    // End of variables declaration//GEN-END:variables
}
