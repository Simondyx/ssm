package com.dyx.jdbc;

import java.sql.*;

public class JDBCDemo1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.192.131:3306/contacts"
                , "root", "123456");
        Statement stmt = conn.createStatement();


        String sql1 = "select * from user";
        ResultSet resultSet = stmt.executeQuery(sql1);
        while(resultSet.next()){
            System.out.println("----");
        }


        stmt.close();
        conn.close();
    }
}
