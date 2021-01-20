package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.dao.UserDAO;
import com.fudanscetool.springboot.pojo.Project;
import com.fudanscetool.springboot.pojo.User;
import com.fudanscetool.springboot.result.Result;
import com.fudanscetool.springboot.service.ProjectService;
import com.fudanscetool.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserDAO userdao;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @CrossOrigin
    @PostMapping(value = "register")
    @ResponseBody
    public boolean register(@RequestBody User user) {
        //System.out.println(user);
        return userService.register(user);
    }

    @CrossOrigin
    @PostMapping(value = "login")
    @ResponseBody
    public boolean login(@RequestBody User user) {
        //boolean loginSuccess = userService.login(user);
        //System.out.println(loginSuccess);
        return userService.login(user);
    }

    // 用map接受和发送数据
    /*
    @CrossOrigin
    @PostMapping(value = "login")
    @ResponseBody
    public List<HashMap<String, String>> login(@RequestBody HashMap<String, String> requestUser) {
        System.out.println("Receive " + requestUser);
        String userID = requestUser.get("userID");
        System.out.println(userID);
        int userPassword = Integer.parseInt(requestUser.get("password"));
        System.out.println(userPassword);
        //String userID = requestUser.getUserID();
        //userID = HtmlUtils.htmlEscape(userID);

        List<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key1", "1");
        map.put("key2", "1");
        map.put("key3", "1");
        list.add(map);
        map.put("key2", "2");
        list.add(map);
        map.put("key3", "3");
        list.add(map);
        return list;
    }
     */

    @CrossOrigin
    @PostMapping(value = "addAdministrator")
    @ResponseBody
    public boolean addAdministrator(@RequestBody User user) {
        return userService.addAdministrator(user);
    }

    @CrossOrigin
    @PostMapping(value = "changePassword")
    @ResponseBody
    public boolean changePassword(@RequestBody HashMap<String, String> requestUser) {
        String userID = requestUser.get("userID");
        String oldPassword = requestUser.get("oldPassword");
        String newPassword = requestUser.get("newPassword");
        return userService.changePassword(userID, oldPassword, newPassword);
    }

    @CrossOrigin
    @PostMapping(value = "showAllUser")
    @ResponseBody
    public List<User> showAllUser() {
        return userService.showAllUser();
    }

    @CrossOrigin
    @PostMapping(value = "deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestBody String userID) {
        List<Project> projects = projectService.findProjectByOwner(userID);
        for(int i = 0; i < projects.size(); ++i) {
            String projectID = projects.get(i).getProjectID();
            projectService.deleteStage1(projectID);
            projectService.deleteStage2(projectID);
            projectService.deleteStage3(projectID);
            projectService.deleteProject(projectID);
        }
        return userService.deleteUser(userID);
    }

    @CrossOrigin
    @PostMapping(value = "logout")
    @ResponseBody
    public boolean logout() {
        return true;
    }
}
