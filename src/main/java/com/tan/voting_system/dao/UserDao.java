package com.tan.voting_system.dao;

/**
 * User的dao接口
 * @author TanShan
 * @date 2022/12/28 12:32
 */
public interface UserDao {
    //注册用户
    public int CreateUser(String username,String password);
}
