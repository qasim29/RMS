/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import app_classes.*;
import dao.LoginDao;
import dao.Registeration_DAO;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class LoginForm extends javax.swing.JPanel {

    private static int USER_PERSON_ID;
    private static String USER_ID;
    private static String USER_TYPE;

    private RMS rms = null;
    public LoginForm(RMS rms) {
        this.rms = rms;
        initComponents();
    }
    
    private boolean checkValidation() {
        String userId = UserId.getText();
        String password = upassword.getText();
        if (userId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(LoginForm.this, "Enter ID");
            UserId.grabFocus();
            return false;
        } else if (password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(LoginForm.this, "Enter Password");
            upassword.grabFocus();
            return false;
        }
        return true;
    }
    
      public static int getUserPersonId() {
        return USER_PERSON_ID;
    }

    public static String getUserId() {
        return USER_ID;
    }

    public static String getUserType() {
        return USER_TYPE;
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        UserId = new javax.swing.JTextField();
        upassword = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registrationButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 367, 100, 37));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("User ID");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 308, 100, 37));

        UserId.setBackground(new java.awt.Color(255, 204, 204));
        UserId.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        UserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIdActionPerformed(evt);
            }
        });
        add(UserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 308, 161, 41));

        upassword.setBackground(new java.awt.Color(255, 204, 204));
        add(upassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 370, 161, 37));

        loginButton.setBackground(new java.awt.Color(255, 204, 204));
        loginButton.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 448, 95, 39));

        registrationButton.setBackground(new java.awt.Color(255, 204, 204));
        registrationButton.setText("Registration");
        registrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationButtonActionPerformed(evt);
            }
        });
        add(registrationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 673, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 500, 260));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/1.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 300, 340));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/2.jpeg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 300, 370));

        jLabel7.setFont(new java.awt.Font("Gadugi", 3, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Login");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 330, 100));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void UserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIdActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String userId = UserId.getText();
        String password = upassword.getText();
        if (checkValidation() && LoginDao.validationLogin(userId, password)) {
            Person person = Registeration_DAO.getPerson(userId);
            USER_PERSON_ID = person.getP_id();
            USER_ID = userId;
            if(person instanceof Manager){
                this.rms.enableToolbarAsManager();
            }else if(person instanceof Employee){
                this.rms.enableToolbarAsEmployee();
            }else{
                JOptionPane.showMessageDialog(LoginForm.this, "Customer's Email..");

            }
            
            
            this.rms.addComponent(new OrdersForm(this.rms));
        } else {
            JOptionPane.showMessageDialog(LoginForm.this, "Invalid Details..");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationButtonActionPerformed
        // TODO add your handling code here:
        this.rms.addComponent(new registrationForm(this.rms));
    }//GEN-LAST:event_registrationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UserId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton registrationButton;
    private javax.swing.JPasswordField upassword;
    // End of variables declaration//GEN-END:variables
}
