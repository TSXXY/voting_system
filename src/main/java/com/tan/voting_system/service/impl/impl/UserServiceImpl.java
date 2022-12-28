package com.tan.voting_system.service.impl.impl;

import com.tan.voting_system.dao.UserDao;
import com.tan.voting_system.dao.impl.UserDaoImpl;
import com.tan.voting_system.pojo.User;
import com.tan.voting_system.service.impl.UserService;

import java.util.Optional;

/**
 * @author TanShan
 * @date 2022/12/28 12:46
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public String CreateUser(String username, String password) {
        int i = userDao.CreateUser(username, password);
        return i == -1 ? "注册失败" : "注册成功";
    }

    @Override
    public boolean Login(String username,String password) {
        User user = userDao.SelectUserByName(username);
        Optional<User> user1 = Optional.ofNullable(user);
        if (user1.isPresent()) {
            return password.equals(user.getPassword());
        }
        return false;
    }
}
