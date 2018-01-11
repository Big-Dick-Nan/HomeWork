package com.lixiaonan.user.service;

import com.lixiaonan.user.dao.UserDao;
import com.lixiaonan.user.domain.User;
import com.lixiaonan.user.service.exception.*;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User user) throws LonginException {

        User formDb = userDao.queryByUsername(user.getUsername());

        if (formDb == null){
            throw  new InvalidUsernameException();
        }
        //如果查出的用户名与输入的用户不相同
        if (!formDb.getPassword().equals(user.getPassword())) {
            //抛出密码不匹配异常
            throw  new PasswordNotMatchException();
        }
        return formDb;
    }

    public User register(User user) throws RegisterException {
        System.out.println(user);

        User formDb = userDao.queryByUsername(user.getUsername());
        if (formDb.getUsername().equals(user.getUsername())){
            throw  new IdenticalException();
        }

        return formDb;
    }


}

