package com.tan.voting_system.service.impl;

import com.tan.voting_system.pojo.User;

/**
 * @author TanShan
 * @date 2022/12/28 12:46
 */
public interface UserService {
    //注册用户
    public String CreateUser(String username,String password);

    public User Login(String username, String password);
}
