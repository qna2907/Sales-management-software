package qlbanhang;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import source.DBKetnoi;

public class CTHDJPanel extends javax.swing.JPanel {

    final String header[] = {"MAHD", "MASP", "SOLUONG", "GIABAN"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    DBKetnoi cn = new DBKetnoi();
    Connection conn;
    private ResultSet rs;

    public CTHDJPanel() {
        initComponents();
        loadBang();
    }

    public void loadBang() {
        try {
            conn = DBKetnoi.getConnection();
            int number;
            Vector row;
            String sql = "SELECT * FROM CTHOADON";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();
            tb.setRowCount(0);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.add(rs.getString(i));
                }
                tb.addRow(row);
                TableCTHD.setModel(tb);
            }
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        TableCTHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (TableCTHD.getSelectedRow() >= 0) {
                    txtmhd1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 0) + "");
                    txtmsp1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 1) + "");
                    txtsl.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 2) + "");
                    txtgb.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 3) + "");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpncthd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmhd1 = new javax.swing.JTextField();
        txtmsp1 = new javax.swing.JTextField();
        txtsl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtgb = new javax.swing.JTextField();
        cmdthem4 = new javax.swing.JButton();
        cmdsua4 = new javax.swing.JButton();
        cmdxoa4 = new javax.swing.JButton();
        cmdtimkiem4 = new javax.swing.JButton();
        cmddau4 = new javax.swing.JButton();
        cmdtrai4 = new javax.swing.JButton();
        cmdphai4 = new javax.swing.JButton();
        cmdcuoi4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCTHD = new javax.swing.JTable();
        cmdtailai4 = new javax.swing.JButton();

        jpncthd.setBackground(new java.awt.Color(255, 255, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Mã Hóa Đơn:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Mã Sản Phẩm:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Số Lượng:");

        txtmhd1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtmhd1.setForeground(new java.awt.Color(51, 0, 0));

        txtmsp1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtmsp1.setForeground(new java.awt.Color(51, 0, 0));

        txtsl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtsl.setForeground(new java.awt.Color(51, 0, 0));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Giá Bán:");

        txtgb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtgb.setForeground(new java.awt.Color(51, 0, 0));

        cmdthem4.setBackground(new java.awt.Color(255, 0, 51));
        cmdthem4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdthem4.setForeground(new java.awt.Color(255, 255, 255));
        cmdthem4.setText("Thêm");
        cmdthem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdthem4ActionPerformed(evt);
            }
        });

        cmdsua4.setBackground(new java.awt.Color(102, 255, 102));
        cmdsua4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdsua4.setForeground(new java.awt.Color(255, 0, 51));
        cmdsua4.setText("Sửa");
        cmdsua4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsua4ActionPerformed(evt);
            }
        });

        cmdxoa4.setBackground(new java.awt.Color(255, 204, 204));
        cmdxoa4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdxoa4.setText("Xóa");
        cmdxoa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdxoa4ActionPerformed(evt);
            }
        });

        cmdtimkiem4.setBackground(new java.awt.Color(102, 255, 255));
        cmdtimkiem4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdtimkiem4.setForeground(new java.awt.Color(0, 51, 204));
        cmdtimkiem4.setText("Tìm Kiếm");
        cmdtimkiem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdtimkiem4ActionPerformed(evt);
            }
        });

        cmddau4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmddau4.setText("<<");
        cmddau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmddau4ActionPerformed(evt);
            }
        });

        cmdtrai4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdtrai4.setText("<");
        cmdtrai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdtrai4ActionPerformed(evt);
            }
        });

        cmdphai4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdphai4.setText(">");
        cmdphai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdphai4ActionPerformed(evt);
            }
        });

        cmdcuoi4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdcuoi4.setText(">>");
        cmdcuoi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcuoi4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("THÔNG TIN CHI TIẾT HÓA ĐƠN");

        TableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MAHD", "MASP", "SOLUONG", "GIABAN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCTHD);

        cmdtailai4.setBackground(new java.awt.Color(255, 255, 51));
        cmdtailai4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmdtailai4.setForeground(new java.awt.Color(204, 0, 255));
        cmdtailai4.setText("Tải Lại");
        cmdtailai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdtailai4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpncthdLayout = new javax.swing.GroupLayout(jpncthd);
        jpncthd.setLayout(jpncthdLayout);
        jpncthdLayout.setHorizontalGroup(
            jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpncthdLayout.createSequentialGroup()
                .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpncthdLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpncthdLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1))
                            .addGroup(jpncthdLayout.createSequentialGroup()
                                .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtsl, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmsp1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmhd1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmdthem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdsua4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdxoa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdtimkiem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdtailai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jpncthdLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(cmddau4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdtrai4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdphai4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdcuoi4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jpncthdLayout.setVerticalGroup(
            jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpncthdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpncthdLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmhd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmsp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jpncthdLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cmdthem4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdsua4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdxoa4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdtimkiem4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdtailai4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpncthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmddau4)
                    .addComponent(cmdtrai4)
                    .addComponent(cmdphai4)
                    .addComponent(cmdcuoi4))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpncthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpncthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void xoatrang(){
        txtmhd1.setText("");
        txtmsp1.setText("");
        txtsl.setText("");
        txtgb.setText("");
        loadBang();
        txtmhd1.setEnabled(true);
        txtmsp1.setEnabled(true);
    }
    private void cmdthem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdthem4ActionPerformed
        try{
            conn = DBKetnoi.getConnection();
            if(txtmhd1.getText().equals("") || txtmsp1.getText().equals("") || txtsl.getText().equals("") || txtgb.getText().equals("")){
                JOptionPane.showConfirmDialog(this, "Bạn cần nhập đủ dữ liệu");
            } else{
                StringBuffer sb = new StringBuffer();
                String sql_check_pk = "SELECT MAHD FROM CTHOADON WHERE MAHD = N'"+txtmhd1.getText()+"' AND MASP = N'"+ txtmsp1 +"'";
                Statement st = conn.createStatement();
                rs = st.executeQuery(sql_check_pk);
                if (rs.next()){
                    sb.append("Chi tiết hóa đơn này đã tồn tại!");
                }
                if (sb.length()>0){
                    JOptionPane.showMessageDialog(this, sb.toString());
                } else {
                    String sql = "INSERT INTO CTHOADON VALUES(N'"+txtmhd1.getText()+"',N'"+txtmsp1.getText()+"',N'"+txtsl.getText()+"',N'"+txtgb.getText()+"')";
                    st = conn.createStatement();
                    int kg = st.executeUpdate(sql);
                    if (kg > 0){
                        JOptionPane.showMessageDialog(this,"Thêm mới thành công!");
                        xoatrang();
                    } 
                }
            }
        } catch(Exception e){
            
        }
    }//GEN-LAST:event_cmdthem4ActionPerformed

    private void TableCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCTHDMouseClicked
        int x = TableCTHD.getSelectedRow();
        if (x>=0){
            txtmhd1.setText(TableCTHD.getValueAt(x,0) +"");
            txtmsp1.setText(TableCTHD.getValueAt(x,1) +"");
            txtsl.setText(TableCTHD.getValueAt(x,2) +"");
            txtgb.setText(TableCTHD.getValueAt(x,3) +"");
            txtmhd1.setEnabled(false);
            txtmsp1.setEnabled(false);
        }
    }//GEN-LAST:event_TableCTHDMouseClicked

    private void cmdsua4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsua4ActionPerformed
        try{
            conn = DBKetnoi.getConnection();
            if(txtsl.getText().equals("") || txtgb.getText().equals("")){
                JOptionPane.showConfirmDialog(this, "Bạn cần nhập đủ dữ liệu");
            } else{
                    Statement st = conn.createStatement();
                    String sql = "UPDATE CTHOADON SET SOLUONG = N'"+ txtsl.getText() +"', GIABAN = N'"+ txtgb.getText() +"' WHERE MAHD = N'"+ txtmhd1.getText() +"' AND MASP = N'"+ txtmsp1.getText() +"'";
                    st = conn.createStatement();
                    int kg = st.executeUpdate(sql);
                    if (kg > 0){
                        JOptionPane.showMessageDialog(this,"Cập nhật thành công!");
                        xoatrang();
                    } 
                st.close();
            }
            conn.close();
            rs.close();
        } catch(Exception e){
        }
    }//GEN-LAST:event_cmdsua4ActionPerformed

    private void cmdxoa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdxoa4ActionPerformed
        try{
            conn = DBKetnoi.getConnection();
            String sql = "DELETE CTHOADON WHERE MAHD = N'"+ txtmhd1.getText() +"' AND MASP = N'"+ txtmsp1.getText() +"'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn có chắc xóa chứ?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_NO_OPTION){
                st.executeUpdate(sql);
                xoatrang();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            }
            
            
        } catch(Exception e){
            
        }
    }//GEN-LAST:event_cmdxoa4ActionPerformed
public void getSelectFirst(){
        int selectedRow = 0;
        txtmhd1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 0) + "");
        txtmsp1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 1) + "");
        txtsl.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 2) + "");
        txtgb.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 3) + "");
        TableCTHD.setRowSelectionInterval(0, 0);
    }
    public void getSelectPrevious(){
        if(TableCTHD.getSelectedRow() >= 1){ 
            int selectedRow = TableCTHD.getSelectedRow() - 1;
            txtmhd1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 0) + "");
            txtmsp1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 1) + "");
            txtsl.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 2) + "");
            txtgb.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 3) + "");
            TableCTHD.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectNext(){
        if(TableCTHD.getSelectedRow() < TableCTHD.getRowCount() - 1){ 
            int selectedRow = TableCTHD.getSelectedRow() + 1;
            txtmhd1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 0) + "");
            txtmsp1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 1) + "");
            txtsl.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 2) + "");
            txtgb.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 3) + "");
            TableCTHD.setRowSelectionInterval(selectedRow, selectedRow);
        }
    }
    public void getSelectLast(){
        int selectedRow = TableCTHD.getRowCount() - 1;
        txtmhd1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 0) + "");
        txtmsp1.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 1) + "");
        txtsl.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 2) + "");
        txtgb.setText(TableCTHD.getValueAt(TableCTHD.getSelectedRow(), 3) + "");
        TableCTHD.setRowSelectionInterval(selectedRow, selectedRow);
    }
    private void cmddau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmddau4ActionPerformed
        getSelectFirst();
    }//GEN-LAST:event_cmddau4ActionPerformed

    private void cmdtrai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdtrai4ActionPerformed
        getSelectPrevious();
    }//GEN-LAST:event_cmdtrai4ActionPerformed

    private void cmdphai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdphai4ActionPerformed
        getSelectNext();
    }//GEN-LAST:event_cmdphai4ActionPerformed

    private void cmdcuoi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcuoi4ActionPerformed
        getSelectLast();
    }//GEN-LAST:event_cmdcuoi4ActionPerformed

    private void cmdtailai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdtailai4ActionPerformed
        loadBang();
        xoatrang();
    }//GEN-LAST:event_cmdtailai4ActionPerformed

    private void cmdtimkiem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdtimkiem4ActionPerformed
        int size = TableCTHD.getRowCount();
        String mahd = JOptionPane.showInputDialog(this, "Nhập vào Mã Hóa Đơn cần tìm:");
        String masp = JOptionPane.showInputDialog(this, "Nhập vào Mã Sản Phẩm cần tìm:");
        for (int i = 0; i < size; i++) {
            if (TableCTHD.getValueAt(i, 0).toString().equalsIgnoreCase(mahd) && TableCTHD.getValueAt(i, 1).toString().equalsIgnoreCase(masp)) {
                JOptionPane.showMessageDialog(this, "Tìm kiếm thành công!");
                txtmhd1.setEnabled(false);
                txtmsp1.setEnabled(false);
                TableCTHD.setRowSelectionInterval(i, i);
                break;
            }
        }
    }//GEN-LAST:event_cmdtimkiem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCTHD;
    private javax.swing.JButton cmdcuoi4;
    private javax.swing.JButton cmddau4;
    private javax.swing.JButton cmdphai4;
    private javax.swing.JButton cmdsua4;
    private javax.swing.JButton cmdtailai4;
    private javax.swing.JButton cmdthem4;
    private javax.swing.JButton cmdtimkiem4;
    private javax.swing.JButton cmdtrai4;
    private javax.swing.JButton cmdxoa4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpncthd;
    private javax.swing.JTextField txtgb;
    private javax.swing.JTextField txtmhd1;
    private javax.swing.JTextField txtmsp1;
    private javax.swing.JTextField txtsl;
    // End of variables declaration//GEN-END:variables
}
