package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Stage3 {
    private String projectID;

    private float size;

    private ArrayList<Float> EM;

    private float estimateLoad;
}