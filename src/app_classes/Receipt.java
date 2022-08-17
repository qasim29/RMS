/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_classes;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Receipt {
    private String cName;
    private String eName;
    private  ArrayList<OrderDetails> meals;
    private Date date;
    private float totalPrice;

    public Receipt(String cName, String eName, ArrayList<OrderDetails> meals, Date date, float totalPrice) {
        this.cName = cName;
        this.eName = eName;
        this.meals = meals;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public ArrayList<OrderDetails> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<OrderDetails> meals) {
        this.meals = meals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
