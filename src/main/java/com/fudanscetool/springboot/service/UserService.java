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

    public boolean register(User user) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        if (udao.searchUser(user.getUserID()) != null) {
            return false;
        }
        else
        {
            udao.insertUser(user);
            return true;
        }
    }

    public boolean login(User user) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return user.getUserPassword().equals(udao.searchUser(user.getUserID()).getUserPassword());
    }

    public boolean addAdministrator(User user) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        user.setAdministrator(true);
        if (udao.searchUser(user.getUserID()) != null) {
            return false;
        }
        else
        {
            udao.insertUser(user);
            return true;
        }
    }

    public boolean changePassword(String userID, String oldPassword, String newPassword) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return udao.updatePassword(userID, newPassword) != 0;
    }

    public List<User> showAllUser() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return udao.searchAllUser();
    }

    public boolean deleteUser(String userID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return udao.deleteUser(userID) != 0;
    }

    public User findUser(String userID) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return udao.searchUser(userID);
    }

    public boolean changeUserProjectNumber(String userID, int changeNumber) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        User user = udao.searchUser(userID);
        return udao.updateOwnedProjectNumber(userID, user.getOwnedProjectNumber() + changeNumber) != 0;
    }

    public int countUserNumber() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return udao.countUserNumber();
    }
}
