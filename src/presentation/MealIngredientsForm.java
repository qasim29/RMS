package presentation;

import app_classes.Ingredients;
import app_classes.MealIngredients;
import app_classes.Meals;
import dao.Ingredient_DAO;
import dao.MealIngredients_DAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MealIngredientsForm extends javax.swing.JPanel {

    private RMS rms = null;
    private Meals meal;
    private String imagePath;
    private int i;
    DefaultTableModel model;

    public MealIngredientsForm(RMS rms, Meals meal) {
        this.rms = rms;
        this.meal = meal;
        initComponents();
        mealName.setText(meal.getName());
        mealCost.setText(""+meal.getPrice());
        model = (DefaultTableModel) mealIngTbl.getModel();
        imagePath = meal.getImage();
        loadImage(imagePath);
        for (Ingredients ing : Ingredient_DAO.getAll()){
            ingredients.addItem(ing);
        }
    }

    public MealIngredientsForm(RMS rms, Meals meal, int i) {
        this.i = i;
        this.rms = rms;
        this.meal = meal;
        initComponents();
        model = (DefaultTableModel) mealIngTbl.getModel();
        loadImage(meal.getImage());
        mealDetails(meal.getM_id());

    }

    private boolean checkValidation() {
        if (Integer.parseInt(qty.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(MealIngredientsForm.this, "Enter qty");
            qty.grabFocus();
            return false;
        }
        return true;
    }

    private void mealDetails(int m_id) {
        Meals meal = MealIngredients_DAO.getMealDetails(m_id);
        mealName.setText(meal.getName());
        mealCost.setText("" + meal.getPrice());
        loadImage(meal.getImage());
        load_2(meal);
    }

    private void load_2(Meals meal) {
        List<MealIngredients> list = meal.getIngredients();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            MealIngredients obj = list.get(i);
            int ing_id = obj.getIng_id();
            int m_id = obj.getM_id();
            int qty = obj.getQty();
            addRow(MealIngredients_DAO.getIngredientById(ing_id).getName(), qty);
        }
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mealName = new javax.swing.JTextField();
        qty = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        imageBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        btnNewMeal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mealIngTbl = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ingredients = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mealCost = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Meal Ingredients");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 32, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingredient Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 176, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Meal Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 127, -1, -1));

        mealName.setBackground(new java.awt.Color(255, 204, 204));
        mealName.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        add(mealName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 170, 31));
        add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 170, 30));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cost");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));
        add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 141, 120));

        imageBtn.setBackground(new java.awt.Color(255, 204, 204));
        imageBtn.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        imageBtn.setText("Choose Image");
        imageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBtnActionPerformed(evt);
            }
        });
        add(imageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(255, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 104, 41));

        updateBtn.setBackground(new java.awt.Color(255, 204, 204));
        updateBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, 41));

        addBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBtn.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 100, 41));

        btnNewMeal.setBackground(new java.awt.Color(255, 204, 204));
        btnNewMeal.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnNewMeal.setText("NEW MEAL");
        btnNewMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMealActionPerformed(evt);
            }
        });
        add(btnNewMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, 41));

        mealIngTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingredients", "Quantity"
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
        mealIngTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mealIngTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mealIngTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 700, 290));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/1.jpg"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 280));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/2.jpeg"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 440, 300, 280));

        ingredients.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        add(ingredients, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 170, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 90, 440));

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantity");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 225, -1, -1));

        mealCost.setBackground(new java.awt.Color(255, 204, 204));
        mealCost.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        mealCost.setEnabled(false);
        add(mealCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 170, 31));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/4.jpg"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void imageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int i = mealIngTbl.getSelectedRow();
        if (i != 1 && checkValidation()) {
            int ing_id = ((Ingredients) ingredients.getSelectedItem()).getIng_id();
            int quantity = (int) qty.getValue();
            MealIngredients_DAO.update(ing_id, meal.getM_id(), quantity);
            load();
            reSet();
        } else {
            JOptionPane.showMessageDialog(MealIngredientsForm.this, "Select Row to update");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void btnNewMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMealActionPerformed
        // TODO add your handling code here:
        this.rms.addComponent(new MealForm(this.rms));
    }//GEN-LAST:event_btnNewMealActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if (checkValidation()) {
            int m_id = meal.getM_id();
            int ing_id = ((Ingredients) ingredients.getSelectedItem()).getIng_id();
            int quantity = (int) qty.getValue();
            MealIngredients obj = new MealIngredients(m_id, ing_id, quantity);
            boolean check = MealIngredients_DAO.ADD(obj);
            reSet();
            if (check) {
                JOptionPane.showMessageDialog(MealIngredientsForm.this, "Ingredient added successfully..");
                load();
            } else {
                JOptionPane.showMessageDialog(MealIngredientsForm.this, "Ingredient Already Exist..");
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:

        int i = mealIngTbl.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(MealIngredientsForm.this, "Select any Row");
        } else {
            String ing_name = model.getValueAt(i, 0).toString();
            MealIngredients_DAO.deleteRow(ing_name, meal.getM_id());
            reSet();
            load();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        mealIngTbl.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void mealIngTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mealIngTblMouseClicked
        // TODO add your handling code here:
//         reSet();
//        int i = mealIngTbl.getSelectedRow();
//        if (i != -1) {
//            ingredients.setSelectedItem(Ingredient_DAO.search(model.getValueAt(i, 0).toString()));
//            qty.setValue(model.getValueAt(i, 1).toString());            
//        } else {
//            JOptionPane.showMessageDialog(MealIngredientsForm.this, "Select any Row");
//        }
    }//GEN-LAST:event_mealIngTblMouseClicked

    private void load() {
        List<MealIngredients> list = MealIngredients_DAO.getAll();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            MealIngredients obj = list.get(i);
            int ing_id = obj.getIng_id();
            int m_id = obj.getM_id();
            int qty = obj.getQty();
            addRow(MealIngredients_DAO.getIngredientById(ing_id).getName(), qty);

        }
    }

    private void loadImage(String path) {

        if (path != null && !path.trim().equalsIgnoreCase("null") && path.trim().length() > 0) {
            try {
                BufferedImage myPicture = ImageIO.read(new File(path));
                imageLabel.setIcon(new ImageIcon(myPicture.getScaledInstance(160, 160, 160)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addRow(String name, int qty) {
        model.insertRow(mealIngTbl.getRowCount(), new Object[]{name, qty});
    }

    private void reSet() {
        ingredients.setSelectedIndex(0);
        qty.setValue(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton btnNewMeal;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton imageBtn;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JComboBox<Ingredients> ingredients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mealCost;
    private javax.swing.JTable mealIngTbl;
    private javax.swing.JTextField mealName;
    private javax.swing.JSpinner qty;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
