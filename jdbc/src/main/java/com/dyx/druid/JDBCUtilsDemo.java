package com.dyx.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBCUtilsDemo {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql1 = "select * from user where username = ?";

            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, "tom");
            boolean b = pstmt.execute();
            System.out.println(b);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtils.close(pstmt, conn);
    }
}
