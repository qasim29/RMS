/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app_classes.*;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author dell
 */
public class Ingredient_DAO {
    public static boolean add(Ingredients ingredient) {
        String name = ingredient.getName();
        int qty =ingredient.getQty();
        String desc = ingredient.getDescription();
        try {
            String qu = "Insert into Ingredients(Name,Qty,Description) values ('" + name + "'," + qty + ",'" + desc + "')";
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }
    
    public static void deleteRow(int id){
        String qu = "delete from Ingredients where ing_id ="+id;
        try {
            SQL.delete(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Ingredients> getAll(){
        ArrayList<Ingredients> list = new ArrayList<>();
        String qu = "select * from Ingredients";
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                int id = rs.getInt("Ing_ID");
                String name = rs.getString("Name");
                int qty = rs.getInt("Qty");
                String desc = rs.getString("Description");
                Ingredients ingredient = new Ingredients(id,name,qty,desc);
                list.add(ingredient);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
     public static void update(int id,String name,int qty,String desc){
        String qu = "update Ingredients set Name = '"+name+"',Qty = "+qty+",Description = '"+desc+"' where ing_ID = "+id;
        try {
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public static ArrayList<Ingredients> search(String name){
        ArrayList<Ingredients> list = new ArrayList<>();
        String qu = "select * from Ingredients where Name ='"+name+"'";
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                int id = rs.getInt("Ing_ID");
                name = rs.getString("Name");
                int qty = rs.getInt("Qty");
                String desc = rs.getString("Description");
                Ingredients ingredient = new Ingredients(id,name,qty,desc);
                list.add(ingredient);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
