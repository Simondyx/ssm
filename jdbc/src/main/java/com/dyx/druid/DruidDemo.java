package com.dyx.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {

        Properties properties=new Properties();
        //通过当前类的class对象获取资源文件
        InputStream is = DruidDemo.class.getResourceAsStream("/druid.properties");
        properties.load(is);
        //返回的是DataSource，不是DruidDataSource
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //获取连接
        Connection connection = dataSource.getConnection();

        //Statement接口
        Statement statement = connection.createStatement();
        String sql1 = "select * from user";
        boolean b1 = statement.execute(sql1);
        System.out.println(b1);


        //PreparedStatement接口
        String sql2 = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        boolean b2 = preparedStatement.execute();
        System.out.println(b2);

        //关闭连接
        connection.close();





    }
}
