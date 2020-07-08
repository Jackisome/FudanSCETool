package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;

public interface EstimateModel {
    void train();
    double estimateStage1(double weight, Stage1 stage);
    double estimateStage2(double weight, Stage2 stage);
    double estimateStage3(double weight, Stage3 stage);
}
