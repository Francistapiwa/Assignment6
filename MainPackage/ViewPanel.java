/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MainPackage;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chait
 */
public class ViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPanel
     */
    JPanel bottomPanel;
    private ArrayList<User> users;
    private User selectedUser;
    
    public ViewPanel(JPanel bottomPanel) {
        initComponents();
        this.bottomPanel = bottomPanel;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userDataTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        userDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age"
            }
        ));
        jScrollPane1.setViewportView(userDataTable);

        deleteButton.setBackground(new java.awt.Color(255, 51, 0));
        deleteButton.setText("REMOVE USER DETAILS");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(204, 102, 0));
        editButton.setText("EDIT USER DETAILS");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age");

        saveButton.setBackground(new java.awt.Color(0, 153, 51));
        saveButton.setText("SAVE USER DETAILS");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ageTextField)
                    .addComponent(nameTextField)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        
        try{
            
            int selectedRowIndex = userDataTable.getSelectedRow();
            if (selectedRowIndex<0){
                throw new IllegalArgumentException("Select any one user to edit");
            }
            
            else{
                
                
                selectedUser = users.get(selectedRowIndex);
                nameTextField.setText(selectedUser.getName());
                ageTextField.setText(String.valueOf(selectedUser.getAge()));
                
                
            }
        }
        
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_editButtonActionPerformed
    public void populateTable(){
        try{
            this.users = DatabaseConnector.getAllusers();
            
            DefaultTableModel tableModel = (DefaultTableModel) userDataTable.getModel();
            tableModel.setRowCount(0);
            for (User u: users){
                
                String[] userData = {String.valueOf(u.getId()),u.getName(),String.valueOf(u.getAge())};
                tableModel.addRow(userData);
            }
            
            clearFields();
           
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void clearFields(){
        
        nameTextField.setText("");
        ageTextField.setText("");
        selectedUser = null;
    }
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        
        try{
            int selectedRowIndex = userDataTable.getSelectedRow();
            if(selectedRowIndex < 0 ){

                throw new IllegalArgumentException("Select any one user details to delete");

            }
            else{

                DefaultTableModel model = (DefaultTableModel) userDataTable.getModel();              
                selectedUser = users.get(selectedRowIndex);
                DatabaseConnector.deleteUser(selectedUser);
                JOptionPane.showMessageDialog(null, "User Data Successfully Deleted","Successfully Deleted",JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                populateTable();


            }

        }
        catch (IllegalArgumentException e){

            JOptionPane.showMessageDialog(this, e.getMessage(),"Data Selection Error",JOptionPane.ERROR_MESSAGE);
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Data Deletion Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        
        try{
            
            if (selectedUser == null){
                throw new IllegalArgumentException("Not Selected any user to edit");
                
            }
            else{
                User newUser = new User();
                newUser.setName(nameTextField.getText());
                newUser.setAge(Integer.parseInt(ageTextField.getText()));
                DatabaseConnector.editUser(selectedUser,newUser);
                if ((selectedUser.getName().equals(newUser.getName())) && (selectedUser.getAge() == newUser.getAge())){

                    throw new IllegalArgumentException("New data is validated against same as existing data");
                }   
                clearFields();
                populateTable();
            }
        
            
        }  
        catch (IllegalArgumentException e){
            if ("not selected any user to edit".equals(e.getMessage().toLowerCase())){
                JOptionPane.showMessageDialog(this, "Please Select any of the Users to Update","Data Updation Error",JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                JOptionPane.showMessageDialog(this, "Please change the existing data before saving the details","Data Updation Error",JOptionPane.ERROR_MESSAGE);
            }
            
   
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable userDataTable;
    // End of variables declaration//GEN-END:variables
}