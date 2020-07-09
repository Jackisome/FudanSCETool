package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.pojo.Project;
import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;
import com.fudanscetool.springboot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @CrossOrigin
    @PostMapping(value = "createProject")
    @ResponseBody
    public boolean createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @CrossOrigin
    @PostMapping(value = "estimateStage1")
    @ResponseBody
    public Stage1 estimateStage1(@RequestParam Stage1 stage1, @RequestParam String model) {
        Stage1 result = stage1;
        Project project = projectService.findProject(stage1.getProjectID());
        double estimateLoad = projectService.estimateStage1(project, stage1, model);
        result.setEstimateLoad(estimateLoad);
        return result;
    }

    @CrossOrigin
    @PostMapping(value = "estimateStage2")
    @ResponseBody
    public Stage2 estimateStage2(@RequestParam Stage2 stage2, @RequestParam String model) {
        Stage2 result = stage2;
        Project project = projectService.findProject(stage2.getProjectID());
        double estimateLoad = projectService.estimateStage2(project, stage2, model);
        result.setEstimateLoad(estimateLoad);
        return result;
    }

    @CrossOrigin
    @PostMapping(value = "estimateStage3")
    @ResponseBody
    public Stage3 estimateStage3(@RequestParam Stage3 stage3, @RequestParam String model) {
        Stage3 result = stage3;
        Project project = projectService.findProject(stage3.getProjectID());
        double estimateLoad = projectService.estimateStage3(project, stage3, model);
        result.setEstimateLoad(estimateLoad);
        return result;
    }

    @CrossOrigin
    @PostMapping(value = "showStage1")
    @ResponseBody
    public Stage1 showStage1(@RequestBody String projectID) {
        return projectService.findStage1(projectID);
    }

    @CrossOrigin
    @PostMapping(value = "showStage2")
    @ResponseBody
    public Stage2 showStage2(@RequestBody String projectID) {
        return projectService.findStage2(projectID);
    }

    @CrossOrigin
    @PostMapping(value = "showStage3")
    @ResponseBody
    public Stage3 showStage3(@RequestBody String projectID) {
        return projectService.findStage3(projectID);
    }

    @CrossOrigin
    @PostMapping(value = "inputRealLoad")
    @ResponseBody
    public boolean inputRealLoad(@RequestBody HashMap<String, String> message) {
        String projectID = message.get("projectID");
        double realLoad = Double.valueOf(message.get("realLoad"));
        return projectService.updateRealLoad(projectID, realLoad);
    }

    @CrossOrigin
    @PostMapping(value = "applyAddDatabase")
    @ResponseBody
    public boolean applyAddDatabase(@RequestBody String projectID) {
        return projectService.applyAddProject(projectID);
    }

    @CrossOrigin
    @PostMapping(value = "outputProject")
    @ResponseBody
    public void outputProject(@RequestBody String projectID) {
        // todo
        return;
    }

    @CrossOrigin
    @PostMapping(value = "deleteProject")
    @ResponseBody
    public boolean deleteProject(@RequestBody String projectID) {
        return projectService.deleteProject(projectID);
    }

    @CrossOrigin
    @PostMapping(value = "showAllProject")
    @ResponseBody
    public List<Project> showAllProject() {
        return projectService.findAllProject();
    }
}
