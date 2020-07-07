package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.FeedbackDAO;
import com.fudanscetool.springboot.dao.ProjectDAO;
import com.fudanscetool.springboot.pojo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackkService {
    @Autowired
    private FeedbackDAO fdao;

    public List<Feedback> showUserFeedback(String userID) {}

    public List<Feedback> showAllFeedback() {}

    public boolean createFeedback(Feedback feedback) {}

    public boolean changeFeedbackStatus(Feedback feedback) {}

    public int countUnreadFeedbackNumber() {}
}
