package com.tan.voting_system.dao.impl;

import com.tan.voting_system.dao.UserDao;
import com.tan.voting_system.pojo.User;
import com.tan.voting_system.utils.BaseDao;

/**
 * 实现方法
 * @author TanShan
 * @date 2022/12/28 12:37
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    //用户注册
    @Override
    public int CreateUser(String username, String password) {
        String sql = "insert into users(username, password) values (?,?)";
        return update(sql,username,password);
    }

    @Override
    public User SelectUserByName(String username) {
        String sql = "select * from users where users.username = ?";
        return queryForOne(User.class,sql,username);
    }
}
