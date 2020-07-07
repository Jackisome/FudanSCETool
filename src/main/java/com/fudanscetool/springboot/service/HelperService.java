package com.fudanscetool.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelperService {
    @Value()
    private String useIntroduction;

    @Value()
    private String modelIntroduction;

    public String showIntroduction() {}

    public String showModel() {}
}
