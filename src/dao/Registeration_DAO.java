/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import app_classes.*;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */
public class Registeration_DAO {
    
    public static boolean save(Person person ){
        ResultSet rs = null;
        String name = person.getName();
        String gender = person.getGender();
        String cno = person.getPhoneNo();
        String add = person.getAddress();
        String email = person.getEmail();
        String pass; 
        float salary;
        if(person instanceof Manager){
            pass = ((Manager) person).getPassword();
            salary = ((Manager) person).getSalary();
            try {
                String qu = "Insert into Person(P_Name,Gender,Phone_Number,Address,Email) values ('" + name + "','" + gender + "','" + cno + "','" + add + "','" + email +"')";
                SQL.executeUpdate(qu);
                qu = "select p_id from person where Email='"+email+"'";        
                rs=SQL.execute(qu);
                rs.next();
                int id = rs.getInt("P_ID");
                qu = "Insert into Manager(P_id,Password,salary) values ("+id+",'" + pass + "'," + salary + ")";
                SQL.executeUpdate(qu);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }
        else{    
            pass = ((Employee) person).getPassword();
            salary = ((Employee) person).getSalary();
            try {
                String qu = "Insert into Person(P_Name,Gender,Phone_Number,Address,Email) values ('" + name + "','" + gender + "','" + cno + "','" + add + "','" + email + "')";
                SQL.executeUpdate(qu);
                qu = "select p_id from person where Email='"+email+"'";        
                rs=SQL.execute(qu);
                rs.next();
                int id = rs.getInt("P_ID");
                qu = "Insert into Employee(p_id,Password,salary) values (" + id + ",'" + pass + "'," + salary + ")";
                SQL.executeUpdate(qu);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }        
    }
    
    public static boolean isEmailExisted(String email){
        ResultSet rs = null;
        boolean retval = true;
        try{
                                                                                                                                        
            String qu = "select * from Person where Email = '"+email+"'";
            rs = SQL.execute(qu);
            if(!rs.next()){
                retval = false;
            }
        }catch(Exception e){
            retval = false;
        }
        return retval;
    }

    public static Person getPerson(String email) {
        ResultSet rs = null;
        try {
            String qu = "select * from Person where Email = '" + email + "'";
            rs = SQL.execute(qu);
            
            if (rs.next()) {
                                
                int id = rs.getInt("p_id");
                String name = rs.getString("P_Name");
                String gender = rs.getString("Gender");
                String contactNo = rs.getString("Phone_Number");
                String address = rs.getString("Address");
                email = rs.getString("Email");

                try {
                    qu = "select * from Manager where p_id = " + id + " ";
                    rs = SQL.execute(qu);
                    if (rs.next()) {
                        float salary = rs.getFloat("Salary");
                        String pass = rs.getString("Password");
                        return new Manager(id, name, gender, address, contactNo, email, salary,pass);
                    }
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("credentials not for Manger");
                }
                try{
                    qu = "select * from Employee where p_id = " + id + " ";
                    rs = SQL.execute(qu);
                    if (rs.next()) {
                        float salary = rs.getFloat("Salary"); 
                        int totalNoOrder = rs.getInt("total_orders_count"); 
                        float bonus = rs.getFloat("bonus");
                        String pass = rs.getString("Password");
                        return new Employee(id, name, gender, address, contactNo, email, totalNoOrder,bonus,salary,pass);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("credentials not for Employee");
                }         
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    public static void updateSalary(int id,float salary){
        String qu = "update Employee set Salary = "+salary+" where P_ID = "+id;
        try {
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
