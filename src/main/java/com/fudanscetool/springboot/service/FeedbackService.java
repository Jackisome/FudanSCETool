package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.FeedbackDAO;
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
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return fdao.searchUserFeedback(userID);
    }

    public List<Feedback> showAllFeedback() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return fdao.searchAllFeedback();
    }

    public boolean createFeedback(Feedback feedback) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return fdao.insertFeedback(feedback) != 0;
    }

    public boolean changeFeedbackStatus(Feedback feedback) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return fdao.updateFeedbackStatus(feedback, "read") != 0;
    }

    public int countUnreadFeedbackNumber() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return fdao.countUnreadFeedbackNumber();
    }
}
