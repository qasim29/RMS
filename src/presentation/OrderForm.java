/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import app_classes.Meals;
import app_classes.Order;
import app_classes.OrderDetails;
import dao.Customer_DAO;
import dao.MealsDAO;
import dao.OrderDetails_DAO;
import dao.Order_DAO;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class OrderForm extends javax.swing.JPanel {

    /**
     * Creates new form OrderForm
     */
    private RMS rms = null;
    private String o_id;
    DefaultTableModel model;
    private float totPrice;

    public OrderForm(RMS rms) {
        this.rms = rms;
        initComponents();
        this.totPrice = 0;
        model = (DefaultTableModel) orderMealTbl.getModel();
        for (Meals meal : MealsDAO.getAll()) {
            orderMeal.addItem(meal);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private boolean checkValidation() {
        if (customerID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(OrderForm.this, "Enter Email");
            customerID.grabFocus();
            return false;
        } else if (!isEmailValidPattern()) {
            JOptionPane.showMessageDialog(OrderForm.this, "Invalid Email Pattern");
            customerID.grabFocus();
            return false;
        } else if (!OrderDetails_DAO.isEmailExisted(customerID.getText())) {
            this.rms.addComponent(new CustomerDetailsForm(this.rms));
            return false;
        } else if (Integer.parseInt(qty.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(OrderForm.this, "Enter Quantity");
            qty.grabFocus();
            return false;
        } else if (orderDate.getDate() == null) {
            JOptionPane.showMessageDialog(OrderForm.this, "Enter date");
            orderDate.grabFocus();
            return false;
        }
        return true;
    }

    private boolean isEmailValidPattern() {
        String regex = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customerID.getText());
        return matcher.matches();
    }

    private void load() {
        List<OrderDetails> list = OrderDetails_DAO.getAll();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            OrderDetails orderMeal = list.get(i);
            int m_id = orderMeal.getM_id();
            int quant = orderMeal.getQty();
            //addRow(OrderDetails_DAO.getMealbyId(m_id).getName(), quant);

        }

    }

    private void addRow(String name, int qty) {
        model.insertRow(orderMealTbl.getRowCount(), new Object[]{name, qty});
    }

    private void reSet() {
        orderMeal.setSelectedIndex(0);
        qty.setValue(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        orderId = new javax.swing.JTextField();
        orderDate = new com.toedter.calendar.JDateChooser();
        orderMeal = new javax.swing.JComboBox<>();
        qty = new javax.swing.JSpinner();
        totalCost = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        doneBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderMealTbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        customerID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 32, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order ID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Meals");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Order Date");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Price");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 169, -1, -1));

        orderId.setBackground(new java.awt.Color(255, 204, 204));
        orderId.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        orderId.setEnabled(false);
        orderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIdActionPerformed(evt);
            }
        });
        add(orderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 156, -1));

        orderDate.setBackground(new java.awt.Color(255, 204, 204));
        add(orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 114, 156, 31));

        orderMeal.setBackground(new java.awt.Color(255, 204, 204));
        add(orderMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 156, 33));
        add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 156, 30));

        totalCost.setBackground(new java.awt.Color(255, 204, 204));
        totalCost.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        totalCost.setEnabled(false);
        totalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCostActionPerformed(evt);
            }
        });
        add(totalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 166, 156, -1));

        addBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 337, 96, 45));

        deleteBtn.setBackground(new java.awt.Color(255, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 337, -1, 45));

        updateBtn.setBackground(new java.awt.Color(255, 204, 204));
        updateBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 337, -1, 45));

        doneBtn.setBackground(new java.awt.Color(255, 204, 204));
        doneBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        doneBtn.setText("DONE");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });
        add(doneBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 337, 97, 45));

        orderMealTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderMealTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMealTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderMealTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 412, 690, 270));

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Customer ID");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        customerID.setBackground(new java.awt.Color(255, 204, 204));
        customerID.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDActionPerformed(evt);
            }
        });
        add(customerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 156, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 110, 400));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 120, 70));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, 70));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/1.jpg"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 460, 240));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/2.jpeg"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 466, 360, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void orderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderIdActionPerformed

    private void totalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalCostActionPerformed

    private void customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if (checkValidation() && orderId.getText().trim().isEmpty()) {
            int m_id = ((Meals) orderMeal.getSelectedItem()).getM_id();
            int quant = Integer.parseInt(qty.getValue().toString());
            addRow(OrderDetails_DAO.getMealbyId(m_id).getName(), quant);
            totalPrice((Meals) orderMeal.getSelectedItem(),quant);
        }
//        if (checkValidation() && orderId.getText().trim().isEmpty()) {
//
//            //String c_id = customerID.getText();
//            int m_id = ((Meals) orderMeal.getSelectedItem()).getM_id();
//            int quantity = (int) qty.getValue();
//            OrderDetails order = new OrderDetails(o_id, m_id, quantity);
//            boolean check = OrderDetails_DAO.ADD(order);
//            reSet();
//            totalPrice((Meals) orderMeal.getSelectedItem(),quantity);
//            if (check) {
//                JOptionPane.showMessageDialog(OrderForm.this, " added successfully..");
//                load();
//            } else {
//                JOptionPane.showMessageDialog(OrderForm.this, "order already  Exist..");
//            }
//        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int i = orderMealTbl.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(OrderForm.this, "Select any Row");
        } else {
            totalPrice((OrderDetails_DAO.getMealbyName(model.getValueAt(i, 0).toString())),((int)Float.parseFloat(model.getValueAt(i, 1).toString()))*-1);
            model.removeRow(i);
        }

//        int i = orderMealTbl.getSelectedRow();
//        if (i == -1) {
//            JOptionPane.showMessageDialog(OrderForm.this, "Select any Row");
//        } else {
//            String id = (model.getValueAt(i, 0).toString());
//            String mName = (model.getValueAt(i, 1).toString());
//            OrderDetails_DAO.deleteRow(id,mName);
//            load();
//            reSet();
//            totalPrice(OrderDetails_DAO.getMealbyName(mName),(Integer.parseInt(model.getValueAt(i, 2).toString()))*-1);
//        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int i = orderMealTbl.getSelectedRow();
        if (i != 1 && checkValidation() && !(orderId.getText().trim().isEmpty())) {
            model.removeRow(i);
            int m_id = ((Meals) orderMeal.getSelectedItem()).getM_id();
            int quant = Integer.parseInt(qty.getValue().toString());
            addRow(OrderDetails_DAO.getMealbyId(m_id).getName(), quant);

        } else {
            JOptionPane.showMessageDialog(OrderForm.this, "Select Row to update");
        }
//        int i = orderMealTbl.getSelectedRow();
//        if (i != 1 && checkValidation() && !(orderId.getText().trim().isEmpty())) {
//            totalPrice((Meals)orderMeal.getSelectedItem(),((int) qty.getValue())*-1);
//            Meals meal = (Meals)orderMeal.getSelectedItem();
//            int quant = (int)(qty.getValue());
//            OrderDetails_DAO.update((String)orderId.getText(), meal.getM_id(),quant);
//            totalPrice((Meals)orderMeal.getSelectedItem(),((int) qty.getValue()));
//            load();
//            reSet();
//           
//        } else {
//            JOptionPane.showMessageDialog(OrderForm.this, "Select Row to update");
//        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        // TODO add your handling code here:
        if (checkValidation() && orderId.getText().trim().isEmpty()) {
            o_id = UUID.randomUUID().toString();
            int e_id = LoginForm.getUserPersonId();
            String c_id = customerID.getText();
            int m_id = ((Meals) orderMeal.getSelectedItem()).getM_id();
            Date oDate = orderDate.getDate();
            float price = totPrice;
            Order order = new Order(e_id, Customer_DAO.getCustomerbyEmail(c_id).getP_id(), o_id, price, oDate);
            Order_DAO.ADD(order);

            for (int i = 0; i < model.getRowCount(); i++) {
                Meals meal = OrderDetails_DAO.getMealbyName(model.getValueAt(i, 0).toString());
                int qty = (int) Float.parseFloat(model.getValueAt(i, 1).toString());
                OrderDetails_DAO.ADD(new OrderDetails(o_id, meal.getM_id(), qty));
            }
            JOptionPane.showMessageDialog(OrderForm.this, " added successfully..");
            //load();
            reSet();
        }
    }//GEN-LAST:event_doneBtnActionPerformed

    private void orderMealTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMealTblMouseClicked
        // TODO add your handling code here:reSetField();
        int i = orderMealTbl.getSelectedRow();
        if (i != -1) {
            //       orderMeal.setSelectedItem(OrderDetails_DAO.getMealbyName((String)model.getValueAt(i, 0).toString()));
            //  qty.setValue(""+Integer.parseInt(model.getValueAt(i, 1).toString()));

        } else {
            JOptionPane.showMessageDialog(OrderForm.this, "Select any Row");
        }
    }//GEN-LAST:event_orderMealTblMouseClicked

    private void totalPrice(Meals meal, int qty) {
        totPrice += meal.getPrice() * qty;
        totalCost.setText("" + totPrice);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField customerID;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser orderDate;
    private javax.swing.JTextField orderId;
    private javax.swing.JComboBox<Meals> orderMeal;
    private javax.swing.JTable orderMealTbl;
    private javax.swing.JSpinner qty;
    private javax.swing.JTextField totalCost;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}