package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    @Insert("INSERT INTO user (userID, userPassword, isAdministrator, registerTime, ownedProjectNumber) VALUES(#{userId}, #{password}, #{isAdministrator}, #{registerTime}, #{ownedProjectNumber})")
    int insertUser(User user);

    @Select("SELECT userID, userPassword, isAdministrator, registerTime, ownedProjectNumber FROM user WHERE userID=#{userID}")
    User searchUser(String userID);

    @Update("UPDATE user SET userPassword=#{password} WHERE userID=#{userID}")
    int updatePassword(String userID, String password);

    @Select("SELECT * FROM user")
    List<User> searchAllUser();

    @Delete("DELETE FROM user WHERE userID=#{userID}")
    int deleteUser(String userID);

    @Select("SELECT COUNT(*) FROM user")
    int countUserNumber();

    @Update("UPDATE user SET ownedProjectNumber=#{owwnedProjectNumber} WHERE userID=#{userID}")
    int updateOwnedProjectNumber(String userID, int ownedProjectNumber);
}
