package com.dyx.jdbcTemplate;

import com.dyx.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class JDBCTemplateDemo1 {

    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql1 = "select * from user where username = ?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql1,"tom");

        System.out.println(stringObjectMap);








    }
}
