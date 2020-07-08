package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.dao.HistoryProjectDAO;
import com.fudanscetool.springboot.dao.HistoryStage1DAO;
import com.fudanscetool.springboot.dao.HistoryStage2DAO;
import com.fudanscetool.springboot.dao.HistoryStage3DAO;
import com.fudanscetool.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class COCOMOIIModel implements EstimateModel {

    @Autowired
    private HistoryProjectDAO hdao;

    @Autowired
    private HistoryStage1DAO h1dao;

    @Autowired
    private  HistoryStage2DAO h2dao;

    @Autowired
    private HistoryStage3DAO h3dao;

    @Value("cocomoiia1")
    private int cocomoiia1;

    @Value("cocomoiia2")
    private int cocomoiia2;

    @Value("cocomoiia3")
    private int cocomoiia3;

    @Override
    public void train() {
        List<HistoryProject> allHistoryProject = hdao.searchAllHistoryProject();
        int a1temp = 0;
        for (int i = 0; i < allHistoryProject.size(); i++) {
            float weight = 0.91 + 0.01 * (allHistoryProject.get(i).getScaleFactor())
            HistoryStage1 hs1 = h1dao.searchHistoryStage1(allHistoryProject.get(i).getProjectID());
            float weight = 0.91 + 0.01 * ()
        }
    }

    @Override
    public float estimateStage1(float weight, Stage1 stage) {
        return 0;
    }

    @Override
    public float estimateStage2(float weight, Stage2 stage) {
        return 0;
    }

    @Override
    public float estimateStage3(float weight, Stage3 stage) {
        return 0;
    }
}
