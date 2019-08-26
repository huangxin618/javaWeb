package com.Dao;

import java.sql.*;

/**
 * @author hx
 * @date 2019-08-23 18:08
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hx1998","root","root");
           Statement sta = con.createStatement();
           String sql = "select * from user";
           ResultSet set =  sta.executeQuery(sql);
           while (set.next()){
               String username = set.getString("username");
               String password = set.getString("password");
               System.out.println(username+password);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
