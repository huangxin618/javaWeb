package com.Service;

import com.Dao.UserDao;
import com.User;

/**
 * @author hx
 * @date 2019-08-23 15:31
 */
public class UserService {

    UserDao userDao = new UserDao();

    public User login(String username,String password){

        return userDao.finderUser(username,password);
    }

}
