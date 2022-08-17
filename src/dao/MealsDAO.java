/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import app_classes.Meals;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author qasim
 */
public class MealsDAO {
    public static boolean ADD(Meals meal){
        boolean flag = false;
        try {
            String Name = meal.getName();
            float Price = meal.getPrice();
            String url = meal.getImage();
            
            String qu = "insert into meals(Name,price,Image) values('"+Name+"',"+Price+",'"+url+"')";
            SQL.executeUpdate(qu);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;
    }
    
    public static ArrayList<Meals> getAll(){
        ArrayList<Meals> list = new ArrayList<>();
        String qu = "select * from Meals";
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next()){
                int id = rs.getInt("MEAL_ID");
                String name = rs.getString("NAME");
                float cost = rs.getFloat("PRICE");
                String url = rs.getString("IMAGE");
                Meals item = new Meals(id,name,cost,url);
                list.add(item);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }    
    
    public static void deleteRow(int id){
        String qu = "delete from Meals where Meal_ID ="+id;
        try {
            SQL.delete(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void update(int id,String name,float price,String url){
        String qu = "update Meals set Name = '"+name+"', Price = '"+price+"',Image = '"+url+"' where Meal_ID = "+id;
        try {
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String getMealName(int m_id){
        String qu = "select * from Meals where meal_id = "+m_id;
        String name = null;
        try {
            ResultSet rs = SQL.execute(qu);
            if(rs.next()){
               name = rs.getString("NAME");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

}
