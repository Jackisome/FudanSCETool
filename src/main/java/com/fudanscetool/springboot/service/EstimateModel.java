package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;

import java.util.List;

public interface EstimateModel {
    void train();
    float estimateStage1(List<Float> scaleFactor, Stage1 stage);
    float estimateStage2(List<Float> scaleFactor, Stage2 stage);
    float estimateStage3(List<Float> scaleFactor, Stage3 stage);
}
