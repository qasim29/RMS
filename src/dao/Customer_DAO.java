package dao;

import app_classes.Customer;
import app_classes.Meals;
import app_classes.Person;
import java.sql.ResultSet;

public class Customer_DAO {

    public static boolean save(Person customer) {
        ResultSet rs = null;
        String name = customer.getName();
        String gender = customer.getGender();
        String cno = customer.getPhoneNo();
        String add = customer.getAddress();
        String email = customer.getEmail();

        try {
            String qu = "Insert into Person(P_Name,Gender,Phone_Number,Address,Email) values ('" + name + "','" + gender + "','" + cno + "','" + add + "','" + email + "')";
            SQL.executeUpdate(qu);
            qu = "select p_id from person where email='" + email + "'";
            rs = SQL.execute(qu);
            rs.next();
            int id = rs.getInt("P_ID");
            qu = "Insert into Customer(p_id) values (" + id + ")";
            SQL.executeUpdate(qu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

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
    
    public static Customer getCustomerbyEmail(String email) {
        Customer customer = null;
        String qu = "select * from Person where Email = '"+email+"'" ;
        try {
            ResultSet rs = SQL.execute(qu);
            if(rs.next());
            {
                int p_id = rs.getInt("p_id");
                String name= rs.getString("P_Name");
                String gender = rs.getString("Gender");
                String cNo = rs.getString("Phone_Number");
                String add = rs.getString("Address");
                customer = new Customer(p_id, name, gender,add,cNo,email);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }
    
    public static Person getPerson(int p_id) {
        Person person = null;
        String qu = "select * from Person where p_id = "+p_id ;
        try {
            ResultSet rs = SQL.execute(qu);
            if(rs.next());
            {
                p_id = rs.getInt("p_id");
                String name= rs.getString("P_Name");
                String gender = rs.getString("Gender");
                String cNo = rs.getString("phone_number");
                String add = rs.getString("Address");
                String email = rs.getString("Email");
                person = new Person(p_id, name, gender,add,cNo,email);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return person;
    }
    
}
