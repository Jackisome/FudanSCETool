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

    public boolean register(User user) {return true;}

    public boolean login(User user) {return true;}

    public boolean addAdministrator(User user) {return true;}

    public boolean changePassword(String userID, String oldPassword, String newPassword) {return true;}

    public List<User> showAllUser() {return null;}

    public boolean deleteUser(String userID) {return true;}

    public User findUser(String userID) {return null;}

    public boolean changeUserProjectNumber(String userID, int changeNumber) {return true;}

    public int countUserNumber() {return udao.countUserNumber();}
}
