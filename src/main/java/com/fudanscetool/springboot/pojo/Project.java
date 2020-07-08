package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;

@Data
public class Project {
    private String projectID;

    private String projectName;

    private Timestamp createTime;

    private String programType;

    private String codeLanguage;

    private String PREC;
    private String FLEX;
    private String RESL;
    private String TEAM;
    private String PMAT;

    private double realLoad;

    private String projectStatus;

    private String projectOwner;
}
