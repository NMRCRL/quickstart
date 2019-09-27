package com.login.service;

import com.login.entity.User;
import com.login.utils.Md5Util;

import java.util.Arrays;
import java.util.List;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description
 * @Date 2019/9/26
 * @Version 1.0
 **/


public class UserService {
    private List<User> userList;

    /**
     * @param null
     * @return List<User>
     * @Description 用户数据初始化方法
     */
    public  List<User> init() {

        User[] users = {
                new User(1, "aaa@qq.com", "698d51a19d8a121ce581499d7b701668", "松山湖", "user1.jpg"),
                new User(1, "bbb@qq.com", "698d51a19d8a121ce581499d7b701668", "松山湖", "user2.jpg"),
                new User(1, "ccc@qq.com", "698d51a19d8a121ce581499d7b701668", "松山湖", "user3.jpg")

        };

        userList = Arrays.asList(users);
        return userList;


    }

    public User userLogin(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password))) {
                return user;

            }
        }
        return null;
    }

    public static void main(String[] args) {
        UserService us = new UserService();
        us.init();
        User user = us.userLogin("aaa@qq.com", "111");
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("登陆失败");
        }

    }


}
