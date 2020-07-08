package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.*;
import com.fudanscetool.springboot.pojo.HistoryProject;
import com.fudanscetool.springboot.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstimateSystemService {
    @Autowired
    private ProjectDAO pdao;

    @Autowired
    private HistoryProjectDAO hdao;

    @Autowired
    private HistoryStage1DAO hs1dao;

    @Autowired
    private HistoryStage2DAO hs2dao;

    @Autowired
    private HistoryStage3DAO hs3dao;

    public List<HistoryProject> findAllHistoryProject() {}

    public List<Project> findAllWaitProject() {}

    public boolean copyToHistoryProjectDatabase(String ProjectID) {}

    public boolean createNewHistoryProject(HistoryProject hProject) {}

    public boolean trainModel(String model) {}

    public boolean deleteHistoryProject(String hProjectID) {}

    public int countHistoryProjectNumber() {}
}
