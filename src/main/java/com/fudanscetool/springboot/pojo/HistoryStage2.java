package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class HistoryStage2 {
    private String projectID;

    private float size;

    private ArrayList<Float> EM;
}