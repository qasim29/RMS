/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_classes;

/**
 *
 * @author dell
 */
public class MealIngredients {
    private int m_id;
    private int ing_id;
    private int qty;

    public MealIngredients() {
    }

    public MealIngredients(int m_id, int ing_id, int qty) {
        this.m_id = m_id;
        this.ing_id = ing_id;
        this.qty = qty;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public int getIng_id() {
        return ing_id;
    }

    public void setIng_id(int ing_id) {
        this.ing_id = ing_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

   
    
    
}
