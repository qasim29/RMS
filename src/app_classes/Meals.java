/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_classes;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Meals {
    private int m_id;
    private String name;
    private float price;
    private String image;
    private ArrayList<MealIngredients> ingredients;

    
    public Meals(){}

    public Meals(int m_id, String name, float price, String image, ArrayList<MealIngredients> ingredients) {
        this.m_id = m_id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.ingredients = ingredients;
    }
    
    
    
    public Meals(String name, float price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }
    
    public Meals(int m_id, String name, float price) {
        this.m_id = m_id;
        this.name = name;
        this.price = price;
    }
    
    public Meals(int m_id, String name, float price, String image) {
        this.m_id = m_id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<MealIngredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<MealIngredients> ingredients) {
        this.ingredients = ingredients;
    }
    
    
    @Override
    public String toString() {
        return  name + ":" + price;
    }
}
