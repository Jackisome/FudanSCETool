package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Stage2 {
    private String projectID;

    private double size;

    private String PCPX;
    private String RUSE;
    private String PDIF;
    private String PERS;
    private String PREX;
    private String FCIL;
    private String SCED;

    private float estimateLoad;
}
