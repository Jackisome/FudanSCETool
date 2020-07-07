package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private String projectID;

    private String password;

    private boolean isAdministrator;

    private Timestamp registerTime;
}
