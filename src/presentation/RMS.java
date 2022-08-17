/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author dell
 */
public class RMS extends javax.swing.JFrame {

    public RMS() {
        //initComponents();
        this.setTitle("RMS");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        BorderLayout layout = new BorderLayout();

        this.getContentPane().setLayout(layout);

        jToolBar1 = new javax.swing.JToolBar();
        btnIngredient = new javax.swing.JButton();
        jToolBar1.setRollover(true);

        btnIngredient.setText("<html><center>Ingredients</center></html>");
        btnIngredient.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnIngredient.setFocusable(false);
        btnIngredient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngredient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngredientActionPerformed(evt);
            }
        });
        jToolBar1.add(btnIngredient);
        jToolBar1.add(new JSeparator(SwingConstants.VERTICAL));
        btnMeals = new javax.swing.JButton();
        btnMeals.setText("<html><center>Meals</center></html>");
        btnMeals.setFont(new java.awt.Font("Gadugi", 1, 18));
        btnMeals.setFocusable(false);
        btnMeals.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMeals.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMeals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMealsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMeals);
        jToolBar1.add(new JSeparator(SwingConstants.VERTICAL));
        btnAssignSalary = new javax.swing.JButton();
        btnAssignSalary.setText("<html><center>Assign Salary</center></html>");
        btnAssignSalary.setFont(new java.awt.Font("Gadugi", 1, 18));
        btnAssignSalary.setFocusable(false);
        btnAssignSalary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAssignSalary.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAssignSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignSalaryActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAssignSalary);

        jToolBar1.add(new JSeparator(SwingConstants.VERTICAL));
        btnOrder = new javax.swing.JButton();
        btnOrder.setText("<html><center>Book</center></html>");
        btnOrder.setFont(new java.awt.Font("Gadugi", 1, 18));
        btnOrder.setFocusable(false);
        btnOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrder);

        jToolBar1.add(new JSeparator(SwingConstants.VERTICAL));
        btnOrderDetails = new javax.swing.JButton();
        btnOrderDetails.setText("<html><center>View Order</center></html>");
        btnOrderDetails.setFont(new java.awt.Font("Gadugi", 1, 18));
        btnOrderDetails.setFocusable(false);
        btnOrderDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrderDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDetailsActionPerformed(evt);
            }
        });

        jToolBar1.add(btnOrderDetails);
        this.getContentPane().add(jToolBar1, BorderLayout.NORTH);

        jToolBar1.setVisible(false);

        JPanel loginForm = new LoginForm(this);

        this.getContentPane().add(loginForm, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnIngredient = new javax.swing.JButton();
        btnMeals = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnOrderDetails = new javax.swing.JButton();
        btnAssignSalary = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnIngredient.setText("Ingredients");
        btnIngredient.setFocusable(false);
        btnIngredient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngredient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngredientActionPerformed(evt);
            }
        });
        jToolBar1.add(btnIngredient);

        btnMeals.setText("Meals");
        btnMeals.setFocusable(false);
        btnMeals.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMeals.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMeals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMealsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMeals);

        btnOrder.setText("Order");
        btnOrder.setFocusable(false);
        btnOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrder);

        btnOrderDetails.setText("View Order");
        btnOrderDetails.setFocusable(false);
        btnOrderDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrderDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDetailsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrderDetails);

        btnAssignSalary.setText("Assign Salary");
        btnAssignSalary.setFocusable(false);
        btnAssignSalary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAssignSalary.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAssignSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignSalaryActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAssignSalary);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 427, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngredientActionPerformed
        // TODO add your handling code here:
        this.addComponent(new IngredientsForm(this));
    }//GEN-LAST:event_btnIngredientActionPerformed

    private void btnMealsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMealsActionPerformed
        // TODO add your handling code here:
        this.addComponent(new MealForm(this));
    }//GEN-LAST:event_btnMealsActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:
        this.addComponent(new OrderForm(this));
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDetailsActionPerformed
        // TODO add your handling code here:
        this.addComponent(new OrdersForm(this));
    }//GEN-LAST:event_btnOrderDetailsActionPerformed

    private void btnAssignSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignSalaryActionPerformed
        // TODO add your handling code here:
        this.addComponent(new AssignSalaryForm(this));
    }//GEN-LAST:event_btnAssignSalaryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RMS().setVisible(true);
            }
        });
    }
    
    public void addComponent(JPanel component) {
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof IngredientsForm
                    || c instanceof MealForm
                    || c instanceof MealIngredientsForm
                    || c instanceof OrderForm
                    || c instanceof OrderDetailsForm
                    || c instanceof registrationForm
                    || c instanceof LoginForm
                    || c instanceof OrdersForm
                    || c instanceof CustomerDetailsForm
                    || c instanceof AssignSalaryForm )
            {
                this.getContentPane().remove(c);
            }
        }
        this.getContentPane().add(component, BorderLayout.CENTER);
        this.pack();
        setLocationRelativeTo(null);
    }
     public void enableToolbarAsManager() {
        this.jToolBar1.setVisible(true);
        btnIngredient.setVisible(true);
        btnMeals.setVisible(true);
        btnOrder.setVisible(false);
        btnOrderDetails.setVisible(true);
        btnAssignSalary.setVisible(true);
    }

    public void enableToolbarAsEmployee() {
        this.jToolBar1.setVisible(true);
        btnIngredient.setVisible(true);
        btnMeals.setVisible(true);
        btnOrder.setVisible(true);
        btnOrderDetails.setVisible(true);
        btnAssignSalary.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignSalary;
    private javax.swing.JButton btnIngredient;
    private javax.swing.JButton btnMeals;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnOrderDetails;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
