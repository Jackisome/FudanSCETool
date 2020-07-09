package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.pojo.Feedback;
import com.fudanscetool.springboot.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @CrossOrigin
    @PostMapping(value = "showOwnerFeedback")
    @ResponseBody
    public List<Feedback> showOwnerFeedback(@RequestBody String userID) {
        return feedbackService.showUserFeedback(userID);
    }

    @CrossOrigin
    @PostMapping(value = "showAllFeedback")
    @ResponseBody
    public List<Feedback> showAllFeedback() {
        return feedbackService.showAllFeedback();
    }

    @CrossOrigin
    @PostMapping(value = "createFeedback")
    @ResponseBody
    public boolean createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }
}

