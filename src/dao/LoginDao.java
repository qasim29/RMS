/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import app_classes.*;
import java.sql.ResultSet;

/**
 *
 * @author qasim
 */
public class LoginDao {

    public static boolean validationLogin(String userId, String pass) {
        boolean flag = false;
        ResultSet rs = null;
        try {
            String qu = "select * from Person where Email = '" + userId + "'";
            rs = SQL.execute(qu);
            rs.next();
            int p_id = rs.getInt("P_id");
            System.out.println(p_id);
            Person person = Registeration_DAO.getPerson(userId);
            if (person instanceof Employee) {
                qu = "select * from Employee where p_id = " + p_id;
                rs = SQL.execute(qu);
            } else if (person instanceof Manager) {
                qu = "select * from Manager where p_id = " + p_id;
                rs = SQL.execute(qu);
            }

            if (rs.next() && pass.equals(rs.getString("Password"))) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
