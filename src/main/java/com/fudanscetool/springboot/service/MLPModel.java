package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;


public class MLPModel implements EstimateModel {
    @Override
    public void train() {
        new COCOMOIIModel().train();
    }

    @Override
    public double estimateStage1(double weight, Stage1 stage) {
        return new COCOMOIIModel().estimateStage1(weight, stage);
    }

    @Override
    public double estimateStage2(double weight, Stage2 stage) {
        return new COCOMOIIModel().estimateStage2(weight, stage);
    }

    @Override
    public double estimateStage3(double weight, Stage3 stage) {
        return new COCOMOIIModel().estimateStage3(weight, stage);
    }
}
