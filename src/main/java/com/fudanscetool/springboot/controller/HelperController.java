package com.fudanscetool.springboot.controller;

import com.fudanscetool.springboot.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelperController {
    @Autowired
    private HelperService helperService;

    @CrossOrigin
    @PostMapping(value = "showIntroduction")
    @ResponseBody
    public String showIntroduction() {
        return helperService.showIntroduction();
    }

    @CrossOrigin
    @PostMapping(value = "showModel")
    @ResponseBody
    public String showModel() {
        return helperService.showModel();
    }
}
