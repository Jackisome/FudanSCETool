package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FeedbackDAO {
    @Select("SELECT * FROM feedback WHERE userID=#{userID}")
    List<Feedback> searchUserFeedback(String userID);

    @Select("SELECT * FROM feedback")
    List<Feedback> searchAllFeedback();

    @Insert("INSERT INTO feedback VALUES(#{feedbackTime}, #{userID}, #{feedbackContent}, #{feedbackStatus})")
    int insertFeedback(Feedback feedback);

    @Select("SELECT COUNT (*) FROM feedback WHERE feedbackStatus='未读'")
    int countUnreadFeedbackNumber();

    @Update("UPDATE feedback SET feedbackStatus=#{status} WHERE feedbackTime=#{feedbackTime} AND userID={userID}")
    int updateFeedbackStatus(Feedback feedback, String status);
}
