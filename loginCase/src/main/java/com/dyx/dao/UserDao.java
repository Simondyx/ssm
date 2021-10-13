package com.dyx.dao;

import com.dyx.domain.User;
import com.dyx.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
    操作数据库中User表的类
 */
public class UserDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *
     * @param loginUser
     * @return
     */
    public User login(User loginUser){


        try {

            String sql = "select * from USER where username = ? and password = ?";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword()
            );
            return user;

        }catch(DataAccessException e){
            e.printStackTrace();
            return null;
        }

    }
}
