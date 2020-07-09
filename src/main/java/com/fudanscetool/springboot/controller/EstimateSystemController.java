package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.pojo.*;
import com.fudanscetool.springboot.service.EstimateSystemService;
import com.fudanscetool.springboot.service.FeedbackService;
import com.fudanscetool.springboot.service.ProjectService;
import com.fudanscetool.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EstimateSystemController {
    private EstimateSystemService estimateSystemService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @CrossOrigin
    @PostMapping(value = "showAllHistoryProject")
    @ResponseBody
    public List<HistoryProject> showAllHistoryProject() {
        return estimateSystemService.findAllHistoryProject();
    }

    @CrossOrigin
    @PostMapping(value = "showApply")
    @ResponseBody
    public List<Project> showApply() {
        return estimateSystemService.findAllWaitProject();
    }

    @CrossOrigin
    @PostMapping(value = "aggreToAddDatabase")
    @ResponseBody
    public boolean aggreToAddDatabase(@RequestBody String projectID) {
        boolean aggreApplyment = projectService.aggreApplyment(projectID);
        boolean copyToHistoyDB = estimateSystemService.copyToHistoryProjectDatabase(projectID);
        return aggreApplyment && copyToHistoyDB;
    }

    @CrossOrigin
    @PostMapping(value = "addHistoryProject")
    @ResponseBody
    public boolean addHistoryProject(@RequestParam HistoryProject hProject, @RequestParam HistoryStage1 hStage1, @RequestParam HistoryStage2 hStage2, @RequestParam HistoryStage3 hStage3) {
        return estimateSystemService.createNewHistoryProject(hProject, hStage1, hStage2, hStage3);
    }

    @CrossOrigin
    @PostMapping(value = "trainModel")
    @ResponseBody
    public boolean trainModel(@RequestBody String model) {
        return estimateSystemService.trainModel(model);
    }

    @CrossOrigin
    @PostMapping(value = "deleteHistoryProject")
    @ResponseBody
    public boolean deleteHistoryProject(@RequestBody String hProjectID) {
        return estimateSystemService.deleteHistoryProject(hProjectID);
    }

    @CrossOrigin
    @PostMapping(value = "showAdministratorInfo")
    @ResponseBody
    public String showAdministratorInfo() {
        String resultMessage = "";
        resultMessage += "当前用户人数为： ";
        int userCount = userService.countUserNumber();
        resultMessage += userCount;
        resultMessage += "\n";
        int waitProjectCount = projectService.countWaitProject();
        resultMessage += waitProjectCount;
        resultMessage += "\n";
        return resultMessage;
    }
}
