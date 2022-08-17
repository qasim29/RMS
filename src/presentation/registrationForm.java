/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import app_classes.*;
import dao.*;


/**
 *
 * @author dell
 */
public class registrationForm extends javax.swing.JPanel {

    /**
     * Creates new form registrationForm
     */
    private RMS rms = null;
    public registrationForm(RMS rms) {
        this.rms= rms;
        initComponents();
    }
    
    private boolean checkValidation(){
        if(name.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(registrationForm.this, "Enter Name");
            name.grabFocus();
            return false;
        }else if(phoneNo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(registrationForm.this, "Enter Phone No");
            phoneNo.grabFocus();
            return false;
        }else if(gender.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(registrationForm.this, "Select gender");
            return false;
        }else if(address.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(registrationForm.this, "Enter Address");
            address.grabFocus();
            return false;
        }else if(type.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(registrationForm.this, "Select Type");
            return false;
        }else if(email.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(registrationForm.this, "Enter Email");
            email.grabFocus();
            return false;
        }else if(!isEmailValidPattern()){    
            JOptionPane.showMessageDialog(registrationForm.this, "Invalid Email Pattern");
            return false;
        }else if(Registeration_DAO.isEmailExisted(email.getText())){
           JOptionPane.showMessageDialog(registrationForm.this, "Email already Exist..");
           return false;
        }else if(password.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(registrationForm.this, "Enter Password");
            password.grabFocus();
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
        type.setSelectedIndex(0);
        email.setText(null);
        password.setText(null);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        phoneNo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        registerButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        gender = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 710));
        setLayout(null);

        jLabel7.setFont(new java.awt.Font("Gadugi", 3, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registration");
        add(jLabel7);
        jLabel7.setBounds(20, 30, 350, 90);

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");
        add(jLabel6);
        jLabel6.setBounds(40, 160, 100, 37);

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");
        add(jLabel8);
        jLabel8.setBounds(420, 220, 100, 37);

        email.setBackground(new java.awt.Color(255, 204, 204));
        email.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        add(email);
        email.setBounds(550, 220, 161, 41);

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gender");
        add(jLabel9);
        jLabel9.setBounds(40, 270, 100, 37);

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Address");
        add(jLabel10);
        jLabel10.setBounds(40, 330, 100, 37);

        jLabel16.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Phone No");
        add(jLabel16);
        jLabel16.setBounds(40, 220, 100, 37);

        name.setBackground(new java.awt.Color(255, 204, 204));
        name.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name);
        name.setBounds(170, 160, 170, 41);

        phoneNo.setBackground(new java.awt.Color(255, 204, 204));
        phoneNo.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoActionPerformed(evt);
            }
        });
        add(phoneNo);
        phoneNo.setBounds(170, 220, 170, 41);

        address.setBackground(new java.awt.Color(255, 204, 204));
        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        add(jScrollPane1);
        jScrollPane1.setBounds(170, 340, 170, 96);

        password.setBackground(new java.awt.Color(255, 204, 204));
        add(password);
        password.setBounds(550, 280, 160, 40);

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        add(jLabel5);
        jLabel5.setBounds(420, 280, 100, 37);

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Type");
        add(jLabel11);
        jLabel11.setBounds(420, 160, 100, 37);

        registerButton.setBackground(new java.awt.Color(255, 204, 204));
        registerButton.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        add(registerButton);
        registerButton.setBounds(240, 450, 120, 40);

        registerButton1.setBackground(new java.awt.Color(255, 204, 204));
        registerButton1.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        registerButton1.setText("Back");
        registerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButton1ActionPerformed(evt);
            }
        });
        add(registerButton1);
        registerButton1.setBounds(370, 450, 120, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(710, 0, 80, 430);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/1.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(0, 510, 530, 220);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/2.jpeg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4);
        jLabel4.setBounds(510, 510, 280, 220);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        add(jLabel13);
        jLabel13.setBounds(0, 430, 590, 80);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        add(jLabel14);
        jLabel14.setBounds(590, 430, 200, 80);

        type.setBackground(new java.awt.Color(255, 204, 204));
        type.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Manager", "Employee" }));
        add(type);
        type.setBounds(550, 160, 160, 40);

        gender.setBackground(new java.awt.Color(255, 204, 204));
        gender.setFont(new java.awt.Font("Gadugi", 3, 18)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Female", "Male" }));
        add(gender);
        gender.setBounds(170, 280, 170, 40);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel15);
        jLabel15.setBounds(0, 0, 710, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoActionPerformed

    private void registerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButton1ActionPerformed
        // TODO add your handling code here:
        this.rms.addComponent(new LoginForm(this.rms));
    }//GEN-LAST:event_registerButton1ActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        if(checkValidation()){
            String uname = name.getText();
            String ugender = (String)gender.getSelectedItem();
            String uphoneNo = phoneNo.getText();
            String uaddress = address.getText();
            String upassword = password.getText();
            String utype = (String)type.getSelectedItem();
            String uemail = email.getText();
            Person person = null;
            if(utype.equals("Manager")){
                person = new Manager(uname,ugender,uaddress,uphoneNo,uemail,upassword,0); 
            }
            else if(utype.equals("Employee")){
                person = new Employee(uname,ugender,uaddress,uphoneNo,uemail,upassword,0);
            }
            boolean flag = Registeration_DAO.save(person);
            if(flag){
                JOptionPane.showMessageDialog(registrationForm.this, "Registration successfull...");
            }else{
                JOptionPane.showMessageDialog(registrationForm.this, "something went wrong...");
            }
        }
            reSet();
    }//GEN-LAST:event_registerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phoneNo;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton registerButton1;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
