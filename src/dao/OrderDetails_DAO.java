/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app_classes.Meals;
import app_classes.OrderDetails;
import app_classes.Receipt;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class OrderDetails_DAO {

    public static boolean isEmailExisted(String email) {
        ResultSet rs = null;
        boolean retval = true;
        try {

            String qu = "select * from Person where Email = '" + email + "'";
            rs = SQL.execute(qu);
            if (!rs.next()) {
                retval = false;
            }
        } catch (Exception e) {
            retval = false;
        }
        return retval;
    }

    public static boolean ADD(OrderDetails order) {
        boolean flag = false;
        try {
            String o_id = order.getO_id();
            int meal_id = order.getM_id();
            int qty = order.getQty();
            String qu = "insert into Order_Details(Order_id,Meal_Id,Quantity) values('" + o_id + "'," + meal_id + "," + qty + ")";
            SQL.executeUpdate(qu);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;
    }

    public static ArrayList<OrderDetails> getAll() {
        ArrayList<OrderDetails> list = new ArrayList<>();
        String qu = "select * from Order_Details";
        try {
            ResultSet rs = SQL.execute(qu);
            while (rs.next()) {
                String o_id = rs.getString("Order_ID");
                int m_id = rs.getInt("Meal_Id");
                int qty = rs.getInt("Quantity");
                OrderDetails item = new OrderDetails(o_id, m_id, qty);
                list.add(item);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static Meals getMealbyId(int m_id) {
        Meals meal = null;
        String qu = "select * from Meals where meal_id = " + m_id;
        try {
            ResultSet rs = SQL.execute(qu);
            if (rs.next());
            {
                String mName = rs.getString("Name");
                float mPrice = rs.getFloat("Price");
                meal = new Meals(m_id, mName, mPrice);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return meal;
    }

    public static Meals getMealbyName(String name) {
        Meals meal = null;
        String qu = "select * from Meals where Name = '" + name + "'";
        try {
            ResultSet rs = SQL.execute(qu);
            if (rs.next());
            {
                int m_id = rs.getInt("Meal_id");
                String mName = rs.getString("Name");
                float mPrice = rs.getFloat("Price");
                meal = new Meals(m_id, mName, mPrice);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return meal;
    }

    public static void deleteRow(String id, String name) {
        Meals meal = getMealbyName(name);
        String qu = "delete from Order_Details where Order_ID ='" + id + "' and meal_id =" + meal.getM_id();
        try {
            SQL.delete(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(String o_id, int meal_id, int qty) {
        String qu = "update Order_details set Quantity = " + qty + " where Order_ID = '" + o_id + "' and meal_id = " + meal_id;
        try {
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Receipt getReceipt(String o_id) {
        Receipt receipt = null;
        String cName = null;
        String eName =null;
        Date date = null;
        float totalprice = 0;
        ArrayList<OrderDetails> list = new ArrayList<>();
        String qu = "select * from Orders join Order_details on orders.order_id = order_details.order_id where orders.Order_id = '" + o_id + "'";
        try {
            ResultSet rs = SQL.execute(qu);
            while(rs.next())
            {
                int m_id = rs.getInt("Meal_Id");
                int qty = rs.getInt("Quantity");
                OrderDetails item = new OrderDetails(o_id, m_id, qty);
                list.add(item);
                cName = Customer_DAO.getPerson(rs.getInt("c_id")).getName();
                eName = Customer_DAO.getPerson(rs.getInt("e_id")).getName();
                date = rs.getDate("Order_date");
                totalprice = rs.getFloat("total_price");
            }
            
            receipt = new Receipt(cName, eName, list,date,totalprice);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return receipt;
    }
}
