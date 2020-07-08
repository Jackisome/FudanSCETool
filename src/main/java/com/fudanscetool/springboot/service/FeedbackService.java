package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.FeedbackDAO;
import com.fudanscetool.springboot.dao.ProjectDAO;
import com.fudanscetool.springboot.pojo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackDAO fdao;

    /**
     * 根据userID返回用户的所有反馈
     * @param userID
     * @return
     */
    public List<Feedback> showUserFeedback(String userID) {
        return fdao.
    }

    public List<Feedback> showAllFeedback() {}

    public boolean createFeedback(Feedback feedback) {}

    public boolean changeFeedbackStatus(Feedback feedback) {}

    public int countUnreadFeedbackNumber() {}
}
