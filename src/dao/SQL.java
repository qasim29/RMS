package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {

    private static SQL sql = null;

    private SQL() {

    }

    public static SQL get() {
        if (sql == null) {
            sql = new SQL();
        }
        return sql;
    }

    public Connection create() {
        // for giving access database from code
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=restaurantDB;user=sa;password=*ABmm2002#;encrypt=true;trustServerCertificate=true;");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void executeUpdate(String query) throws Exception{
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = SQL.get().create();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            pst.close();

            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }finally{
            if(pst != null){
                pst.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }

        public static ResultSet execute(String query) throws Exception{
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String udb = "jdbc:sqlserver://localhost:1433;databaseName=restaurantDB;user=sa;password=*ABmm2002#;encrypt=true;trustServerCertificate=true;";

            try {
                Connection conn = DriverManager.getConnection(udb);
                //Statement sta = conn.createStatement();
                PreparedStatement pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());            
        }
        return rs;
    }

        
        public static void delete(String query) throws Exception{
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = SQL.get().create();
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            pst.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            if(pst != null){
                pst.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
}
