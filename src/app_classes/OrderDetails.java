/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_classes;

import dao.MealsDAO;

/**
 *
 * @author dell
 */
public class OrderDetails {
    private String o_id;
    private int m_id;
    private int qty;
    
    public OrderDetails(){}

    public OrderDetails(String o_id, int m_id, int qty) {
        this.o_id = o_id;
        this.m_id = m_id;
        this.qty = qty;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "Name : " + MealsDAO.getMealName(m_id) + ", quantity : " + qty + '}';
    }
    
    
    
}
