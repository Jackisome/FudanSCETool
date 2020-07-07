package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.ProjectDAO;
import com.fudanscetool.springboot.dao.Stage1DAO;
import com.fudanscetool.springboot.dao.Stage2DAO;
import com.fudanscetool.springboot.dao.Stage3DAO;
import com.fudanscetool.springboot.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO pdao;

    @Autowired
    private Stage1DAO s1dao;

    @Autowired
    private Stage2DAO s2dao;

    @Autowired
    private Stage3DAO s3dao;

    public boolean createProject(Project project) {}

    public float changeFunc2ToSize(int[] funct2, String codeLanguage) {}

    public float changeFunc3ToSize(int[] funct3, String codaLanguage) {}

    public Project findProject(String projectID) {}

    public float estimateStage1(Project project, String model) {}

    public float estimateStage2(Project project, String model) {}

    public float estimateStage3(Project project, String model) {}

    public Map<String, Float> countEachLoad(float load) {}

    public Map<String, Float> countEachSalary(Map<String, Float> load) {}

    public boolean updateRealLoad(String projectID) {}

    public boolean applyAddProject(String projectID) {}

    public File outputProject(String ProjectID) {}

    public boolean deleteProject(String projectID) {}

    public List<Project> findAllProject() {}

    public int countWaitProject(String status) {}
}
