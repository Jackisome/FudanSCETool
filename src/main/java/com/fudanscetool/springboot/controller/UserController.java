package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.pojo.User;
import com.fudanscetool.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService us;

    public boolean register() {}

    public boolean login() {}

    public boolean addAdministrator() {}

    public boolean changePassword() {}

    public List<User> showAllUser() {}

    public boolean deleteUser() {}

    public boolean logout() {}
}
