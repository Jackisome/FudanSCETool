package com.fudanscetool.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelperService {
    @Value("useIntroduction")
    private String useIntroduction;

    @Value("modelIntroduction")
    private String modelIntroduction;

    public String showIntroduction() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return useIntroduction;
    }

    public String showModel() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());

        return modelIntroduction;
    }
}
