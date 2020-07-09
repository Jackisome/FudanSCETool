package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.ProjectDAO;
import com.fudanscetool.springboot.dao.UserDAO;
import com.fudanscetool.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
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

        return udao.insertUser(user) != 0;
    }

    public boolean login(User user) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        User userInDatabase = udao.searchUser(user.getUserID());
        if(userInDatabase == null) {
            System.out.println("User doesn't exist");
            return false;
        }
        return user.getUserPassword().equals(userInDatabase.getUserPassword());
    }

    public boolean addAdministrator(User user) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        user.setAdministrator(true);
        return udao.insertUser(user) != 0;
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
