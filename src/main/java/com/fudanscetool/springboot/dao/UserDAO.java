package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    @Insert("insert into user (userID, userPassword, isAdministrator, registerTime, ownedProjectNumber)values(#{userId}, #{password}, #{isAdministrator}, #{registerTime}, #{ownedProjectNumber})")
    int insertUser(User user);

    @Select("")
    User searchUser(String userID);

    @Update("")
    int updatePassword(String userID, String password);

    @Select("")
    List<User> searchAllUser();

    @Delete("")
    int deleteUser(String userID);

    @Select("")
    int countUserNumber();
}
