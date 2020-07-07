package com.fudanscetool.springboot.service;

import com.fudanscetool.springboot.pojo.Stage1;
import com.fudanscetool.springboot.pojo.Stage2;
import com.fudanscetool.springboot.pojo.Stage3;
import org.springframework.stereotype.Service;

import java.util.List;

public class AnalogyModel implements EstimateModel {
    @Override
    public void train() {

    }

    @Override
    public float estimateStage1(List<Float> scaleFactor, Stage1 stage) {
        return 0;
    }

    @Override
    public float estimateStage2(List<Float> scaleFactor, Stage2 stage) {
        return 0;
    }

    @Override
    public float estimateStage3(List<Float> scaleFactor, Stage3 stage) {
        return 0;
    }
}
