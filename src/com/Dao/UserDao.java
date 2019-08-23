package com.Dao;

import com.DataSourceUtils;
import com.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hx
 * @date 2019-08-23 14:35
 */
public class UserDao {

    JdbcTemplate template = new JdbcTemplate(DataSourceUtils.getDataSource());

    public User finderUser(String username,String password){
        try {
            return template.queryForObject("select * from user where username=? and password=?",
                    new BeanPropertyRowMapper<>(User.class),username,password);
        }catch (DataAccessException e){
            return null;
        }
    }

}
