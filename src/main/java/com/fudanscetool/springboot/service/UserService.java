package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.ProjectDAO;
import com.fudanscetool.springboot.dao.UserDAO;
import com.fudanscetool.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO udao;

    @Autowired
    private ProjectDAO pdao;

    public boolean register(User user) {}

    public boolean login(User user) {}

    public boolean addAdministrator(User user) {}

    public boolean changePassword(String userID, String oldPassword, String newPassword) {}

    public List<User> showAllUser() {}

    public boolean deleteUser(String userID) {}

    public User findUser(String userID) {}

    public boolean changeUserProjectNumber(String userID, int changeNumber) {}

    public int countUserNumber() {}
}
