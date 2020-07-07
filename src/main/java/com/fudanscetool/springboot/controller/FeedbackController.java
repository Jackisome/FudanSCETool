package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.pojo.Feedback;
import com.fudanscetool.springboot.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService fs;

    public List<Feedback> showOwnedFeedback() {}

    public List<Feedback> showAllFeedback() {}

    public boolean createFeedback() {}
}
