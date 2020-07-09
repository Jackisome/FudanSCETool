package com.fudanscetool.springboot.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Feedback {
    private Timestamp feedbackTime;

    private String userID;

    private String feedbackContent;

    private String feedbackStatus;
}
