package com.cpl.tsl.controller;


import com.cpl.tsl.bean.User;
import com.cpl.tsl.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * user控制器
 *
 * @author: lll
 * @date: 2023年04月06日 16:04:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/save")
    public String insert() {
        User user = new User();
        user.setLastName("zhangsan"+ new Random().nextInt());
        user.setEmail("1234567");
        user.setGender(1);
        user.setDId(new Random().nextInt());
        userMapper.addUser(user);
        return "success";
    }
    @GetMapping("/listuser")
    public List<User> listuser() {
        return userMapper.findUsers();
    }
}