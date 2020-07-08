package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.pojo.User;
import com.fudanscetool.springboot.result.Result;
import com.fudanscetool.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.*;

@Controller
public class UserController {

    //@Autowired
    private UserService us;

    public boolean register() {return false;}

    @CrossOrigin
    @PostMapping(value = "login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        System.out.println("Receive " + requestUser);
        String userID = requestUser.getUserID();
        //userID = HtmlUtils.htmlEscape(userID);

        if (!Objects.equals("admin", userID) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println(message);
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

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


    public boolean addAdministrator() {return false;}

    public boolean changePassword() {return false;}

    public List<User> showAllUser() {return null;}

    public boolean deleteUser() {return false;}

    public boolean logout() {return false;}
}
