/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetworkapi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fahmy
 */
public class DB {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/socialNetwork";//database name

    // Database credentials
    final String USER = "root";
    final String PASS = "fahmy1234";
    
        
    DB(){  }

    public ResultSet executeQuery(String q){
        try {
            Connection conn=null;
            Statement stmt =null;
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            return rs;
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
        return null;
    }
    
    public boolean execute(String q){
        try {
            Connection conn=null;
            Statement stmt =null;
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = (Statement) conn.createStatement();
            return stmt.execute(q);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
        return false;
    }
    
    
    public int getUser(String email){
        String q = "select * from users where email = '"+email+"'";
        ResultSet r = executeQuery(q);
        try{
            if(r.next()){
                return Integer.valueOf(r.getString("id"));
            }else{
                return -1;
            }
        }catch(SQLException e){}
        return -1;
    }
}


//        // STEP 5: Extract data from result set
//        while (rs.next()) {
//            // Retrieve by column name
//            String name = rs.getString("name");//column name
//            System.out.println(name);
//        }


