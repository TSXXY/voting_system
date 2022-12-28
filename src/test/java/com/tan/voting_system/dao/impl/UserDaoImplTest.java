package com.tan.voting_system.dao.impl;

import com.tan.voting_system.dao.UserDao;
import org.junit.jupiter.api.Test;


/**
 * @author TanShan
 * @date 2022/12/28 12:42
 */
class UserDaoImplTest {

   UserDao userDao = new UserDaoImpl();
    @Test
    void createUser() {
        int wang = userDao.CreateUser("wang", "123546");
        if(wang!=-1){
            System.out.println("注册成功");
        }
    }
}