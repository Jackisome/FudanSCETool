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

    private String codeLanguage;

    private float PREC;
    private float FLEX;
    private float RESL;
    private float TEAM;
    private float PMAT;

    private Stage1 stage1;

    private Stage2 stage2;

    private Stage3 stage3;

    private float realLoad;
}
