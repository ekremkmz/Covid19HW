
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CureList extends javax.swing.JFrame {

    public CureList() throws SQLException{
        initComponents();

        DefaultTableModel updateCureTable = (DefaultTableModel) cureTable.getModel();
        String query = "SELECT tedavi_id, tip, ilac, ek, COUNT(h_tdv) FROM tedavi LEFT JOIN hasta ON tedavi.tedavi_id = hasta.h_tdv GROUP BY tedavi_id ORDER BY COUNT(h_tdv) desc;";
        Statement stat = MainScreen.conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            Object[] row = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)};
            updateCureTable.addRow(row);
        }
        stat.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cureTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tedavi Protokolleri");
        setResizable(false);

        cureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protokol Id", "Tip", "İlaç", "Ek", "Kişi Sayısı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cureTable);
        if (cureTable.getColumnModel().getColumnCount() > 0) {
            cureTable.getColumnModel().getColumn(0).setResizable(false);
            cureTable.getColumnModel().getColumn(1).setResizable(false);
            cureTable.getColumnModel().getColumn(2).setResizable(false);
            cureTable.getColumnModel().getColumn(3).setResizable(false);
            cureTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cureTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
