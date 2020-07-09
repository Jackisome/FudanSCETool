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
    private static int cocomoiia1;

    @Value("cocomoiia2")
    private static int cocomoiia2;

    @Value("cocomoiia3")
    private static int cocomoiia3;

    EstimateSystemService es = new EstimateSystemService();
    ProjectService ps = new ProjectService();

    private static boolean isTrain = false;

    @Override
    public void train() {
        isTrain = true;
        List<HistoryProject> allHistoryProject = hdao.searchAllHistoryProject();
        int a1temp = 0;
        int a2temp = 0;
        int a3temp = 0;
        for (int i = 0; i < allHistoryProject.size(); i++) {
            HistoryProject hp = allHistoryProject.get(i);
            double weight = 0.91 + 0.01 * (es.getHistoryProjectWeight(hp));
            double realLoad = hp.getRealLoad();
            HistoryStage1 hs1 = h1dao.searchHistoryStage1(hp.getProjectID());
            HistoryStage2 hs2 = h2dao.searchHistoryStage2(hp.getProjectID());
            HistoryStage3 hs3 = h3dao.searchHistoryStage3(hp.getProjectID());
            double size1 = hs1.getSize();
            double size2 = hs2.getSize();
            double size3 = hs3.getSize();
            double EM2 = es.getHistoryStage2MultipleEM(hs2);
            double EM3 = es.getHistoryStage3MultipleEM(hs3);

            a1temp += realLoad / Math.pow(size1, weight);
            a2temp += realLoad / (Math.pow(size2, weight) * EM2);
            a3temp += realLoad / (Math.pow(size3, weight) * EM3);
        }
        cocomoiia1 = a1temp / allHistoryProject.size();
        cocomoiia2 = a2temp / allHistoryProject.size();
        cocomoiia3 = a3temp / allHistoryProject.size();
        isTrain = false;
    }

    @Override
    public double estimateStage1(double weight, Stage1 stage) {
        while (isTrain) ;
        return cocomoiia1 * Math.pow(stage.getSize(), weight);
    }

    @Override
    public double estimateStage2(double weight, Stage2 stage) {
        while (isTrain) ;
        double EM2 = ps.getStage2MultipleEM(stage);
        return cocomoiia2 * Math.pow(stage.getSize(), weight) * EM2;
    }

    @Override
    public double estimateStage3(double weight, Stage3 stage) {
        while (isTrain) ;
        double EM3 = ps.getStage3MultipleEM(stage);
        return cocomoiia3 * Math.pow(stage.getSize(), weight) * EM3;
    }
}
