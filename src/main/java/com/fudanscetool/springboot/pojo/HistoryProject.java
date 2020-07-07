package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;

@Data
public class HistoryProject {
    private String projectID;

    private String projectName;

    private Timestamp createTime;

    private String programType;

    private String language;

    private ArrayList<Float> scaleFactor;

    private Stage1 stage1;

    private Stage2 stage2;

    private Stage3 stage3;

    private float realLoad;
}
