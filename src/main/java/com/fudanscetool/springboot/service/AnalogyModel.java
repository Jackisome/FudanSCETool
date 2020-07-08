package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;

public class AnalogyModel implements EstimateModel {
    @Override
    public void train() {

    }

    @Override
    public double estimateStage1(double weight, Stage1 stage) {
        return 0;
    }

    @Override
    public double estimateStage2(double weight, Stage2 stage) {
        return 0;
    }

    @Override
    public double estimateStage3(double weight, Stage3 stage) {
        return 0;
    }
}
