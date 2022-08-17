/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import app_classes.Customer;
import dao.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class CustomerDetailsForm extends javax.swing.JPanel {

    /**
     * Creates new form CustomerDetailsForm
     */
    
    private RMS rms = null;
    
    public CustomerDetailsForm(RMS rms) {
        this.rms= rms;
        initComponents();
    }

    private boolean checkValidation() {
        if (name.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Enter Name");
            name.grabFocus();
            return false;
        } else if (email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Enter Email");
            email.grabFocus();
            return false;
        }else if (!isEmailValidPattern()) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Invalid Email Pattern");
            return false;
        } else if (Customer_DAO.isEmailExisted(email.getText())) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Email already Exist..");
            return false;
        } else if (phoneNo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Enter Phone No");
            phoneNo.grabFocus();
            return false;
        } else if (address.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Enter Address");
            address.grabFocus();
            return false;
        } else if (gender.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Select gender");
            return false;
        }
            return true;
    }
    private boolean isEmailValidPattern(){
        String regex = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email.getText());
        return matcher.matches();
    }
    private void reSet(){
        name.setText(null);
        gender.setSelectedIndex(0);
        phoneNo.setText(null);
        address.setText(null);
        email.setText(null);
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        phoneNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 710));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 3, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Details");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 26, 492, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gender");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 73, 29));

        phoneNo.setBackground(new java.awt.Color(255, 204, 204));
        phoneNo.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        add(phoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 172, 45));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 144, 73, 29));

        name.setBackground(new java.awt.Color(255, 204, 204));
        name.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 172, 45));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone No");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 272, 92, -1));

        email.setBackground(new java.awt.Color(255, 204, 204));
        email.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 172, 45));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 207, 73, 29));

        address.setBackground(new java.awt.Color(255, 204, 204));
        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 170, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 325, 73, 29));

        submit.setBackground(new java.awt.Color(255, 204, 204));
        submit.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 110, 40));

        backButton.setBackground(new java.awt.Color(255, 204, 204));
        backButton.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 110, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 410));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/1.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 290, 340));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/2.jpeg"))); // NOI18N
        jLabel9.setText("jLabel9");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 340, 290, 370));

        gender.setBackground(new java.awt.Color(255, 204, 204));
        gender.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Female", "Male" }));
        add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 170, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel11.setText("jLabel10");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 530, 290));
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       if(checkValidation()){
            String uname = name.getText();
            String ugender = (String)gender.getSelectedItem();
            String uphoneNo = phoneNo.getText();
            String uaddress = address.getText();
            String uemail = email.getText();
            boolean flag = Customer_DAO.save(new Customer(uname,ugender,uaddress,uphoneNo,uemail));
            if(flag){
                JOptionPane.showMessageDialog(CustomerDetailsForm.this, "Registration successfull...");
            }else{
                JOptionPane.showMessageDialog(CustomerDetailsForm.this, "something went wrong...");
            }
            reSet();
            this.rms.addComponent(new OrderForm(this.rms));
       }
    }//GEN-LAST:event_submitActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
      this.rms.addComponent(new OrdersForm(this.rms));
    }//GEN-LAST:event_backButtonActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNo;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
