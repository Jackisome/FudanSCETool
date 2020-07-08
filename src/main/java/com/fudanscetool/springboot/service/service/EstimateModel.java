package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;

import java.util.List;

public interface EstimateModel {
    void train();
    float estimateStage1(float weight, Stage1 stage);
    float estimateStage2(float weight, Stage2 stage);
    float estimateStage3(float weight, Stage3 stage);
}
