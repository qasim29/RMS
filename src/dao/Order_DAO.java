/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app_classes.Meals;
import app_classes.Order;
import app_classes.OrderDetails;
import static dao.OrderDetails_DAO.getMealbyName;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Order_DAO {
   public static void ADD(Order order){

       Connection con = null;
        PreparedStatement pst = null;
        con = SQL.get().create();
        try {

            String qu = "insert into Orders(order_ID,C_ID,E_ID,order_date,total_price) values (?,?,?,?,?)";
            pst = con.prepareStatement(qu);
            pst.setString(1, order.getO_id());
            pst.setInt(2, order.getC_id());
            pst.setInt(3, order.getE_id());
            pst.setDate(4, new java.sql.Date(DateTimeUtil.updateTime(order.getOrderDate()).getTime()));
            pst.setFloat(5, order.getTotalPrice());
            pst.executeUpdate();
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        boolean flag = false;
//        try {
//            String o_id = order.getO_id();
//            int e_id = order.getE_id();
//            int c_id = order.getC_id();
//            float cost = order.getTotalPrice();
//            Date date = order.getOrderDate();
//            String qu = "insert into Orders(order_id,c_id,e_id,order_date,total_price) values('"+o_id+"',"+c_id+","+e_id+","+cost+",'"+date+"')";
//            SQL.executeUpdate(qu);
//            flag = true;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            flag = false;
//        }
//        return flag;
    }
   
   
    public static ArrayList<Order> getAll() {
        ArrayList<Order> list = new ArrayList<>();
        String qu = "select * from Orders";
        try {
            ResultSet rs = SQL.execute(qu);
            while (rs.next()) {
                String o_id = rs.getString("Order_ID");
                int c_id = rs.getInt("C_Id");
                int e_id = rs.getInt("E_Id");
                Date date = rs.getDate("order_date");
                float price = rs.getFloat("total_price");
                Order item = new Order(e_id, c_id, o_id,price,date);
                list.add(item);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
   
    public static void deleteRow(String id){
        String qu = "delete from Orders where Order_ID ='"+id+"'";
        try {
            SQL.delete(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Order> getOrders(int e_id) {
        ArrayList<Order> list = new ArrayList<>();
        String qu = "select * from Orders where e_id = "+e_id;
        try {
            ResultSet rs = SQL.execute(qu);
            while (rs.next()) {
                String o_id = rs.getString("Order_ID");
                int c_id = rs.getInt("C_Id");
                e_id = rs.getInt("E_Id");
                Date date = rs.getDate("order_date");
                float price = rs.getFloat("total_price");
                Order item = new Order(e_id, c_id, o_id,price,date);
                list.add(item);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public static ArrayList<Order> getAllByEmployee(int p_id) {
        ArrayList<Order> list = new ArrayList<>();
        String qu = "select * from Orders where E_id = "+p_id;
        try {
            ResultSet rs = SQL.execute(qu);
            while (rs.next()) {
                String o_id = rs.getString("Order_ID");
                int c_id = rs.getInt("C_Id");
                int e_id = rs.getInt("E_Id");
                Date date = rs.getDate("order_date");
                float price = rs.getFloat("total_price");
                Order item = new Order(e_id, c_id, o_id,price,date);
                list.add(item);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return list;
    }

}
