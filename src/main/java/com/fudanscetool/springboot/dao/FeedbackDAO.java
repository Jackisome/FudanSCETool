package com.fudanscetool.springboot.dao;

import com.fudanscetool.springboot.pojo.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDAO {
    List<Feedback> searchUserFeedback(String userID);

    List<Feedback> searchAllFeedback();

    int insertFeedback(Feedback feedback);

    int countUnreadFeedbackNumber();

    int updateFeedbackStatus(Feedback feedback, String status);
}
