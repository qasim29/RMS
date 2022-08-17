/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app_classes.Ingredients;
import app_classes.MealIngredients;
import app_classes.Meals;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class MealIngredients_DAO {
    public static boolean ADD(MealIngredients ing){
        boolean flag = false;
        try {
            int m_id = ing.getM_id();
            int ing_id = ing.getIng_id();
            int qty = ing.getQty();
            String qu = "insert into Meal_Ingredients(Ing_id,meal_id,Qunatity) values("+ing_id+","+m_id+","+qty+")";
            SQL.executeUpdate(qu);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;
    }
    
    public static Ingredients getIngredientByName(String name){
        Ingredients item = null;
        String qu = "select * from Ingredients where Name ='"+name+"'";
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                int ing_id = rs.getInt("Ing_ID");
                name = rs.getString("Name");
                int qty = rs.getInt("Qty");
                String desc = rs.getString("Description");
                item = new Ingredients(ing_id,name,qty,desc);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }
    
    public static void deleteRow(String name,int m_id){
        Ingredients ing = getIngredientByName(name);
        String qu = "delete from Meal_Ingredients where meal_id ="+m_id+"and ing_id = "+ing.getIng_id();
        try {
            SQL.delete(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Ingredients getIngredientById(int id){
        Ingredients item = null;
        String qu = "select * from Ingredients where Ing_id ="+id;
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                id = rs.getInt("Ing_ID");
                String name = rs.getString("Name");
                int qty = rs.getInt("Qty");
                String desc = rs.getString("Description");
                item = new Ingredients(id,name,qty,desc);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }
    
    public static ArrayList<MealIngredients> getAll(){
        ArrayList<MealIngredients> list = new ArrayList<>();
        String qu = "select * from Meal_Ingredients";
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                int ing_id = rs.getInt("Ing_Id");
                int m_id= rs.getInt("Meal_id");
                int qty= rs.getInt("Qunatity");
                MealIngredients item = new MealIngredients(m_id,ing_id,qty);
                list.add(item);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static void update(int ing_id,int m_id,int qty){
        String qu = "update Meal_Ingredients set Qunatity = "+qty+" where ing_ID = "+ing_id+"and meal_id = "+m_id;
        try {
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Meals getMealDetails(int meal_id){
        ArrayList<MealIngredients> mealIngredients = new ArrayList<>();
        Meals meal = null;
        String qu = "select * from Meals join Meal_Ingredients on Meals.Meal_id = Meal_Ingredients.Meal_id where Meals.meal_id = "+meal_id;
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                int ing_id = rs.getInt("Ing_Id");
                int m_id= rs.getInt("Meal_id");
                int qty= rs.getInt("Qunatity");
                MealIngredients item = new MealIngredients(m_id,ing_id,qty);
                mealIngredients.add(item);
            }
            String mName = rs.getString("Name");
            float price = rs.getFloat("Price");
            String image = rs.getString("Image");
            meal= new Meals(meal_id,mName,price,image,mealIngredients);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return meal;
    }
}
