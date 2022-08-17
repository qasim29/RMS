/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_classes;

import java.util.Date;


/**
 *
 * @author dell
 */
public class Order {
    private int e_id;
    private int c_id;
    private String o_id;
    private float totalPrice;
    private Date orderDate;
    
    public Order(){
    }

    public Order(int e_id, int c_id, String o_id, float totalPrice, Date orderDate) {
        this.e_id = e_id;
        this.c_id = c_id;
        this.o_id = o_id;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
}
