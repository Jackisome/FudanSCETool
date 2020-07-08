package com.fudanscetool.springboot.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public void setSession(HttpServletRequest request, String key, Object content){
        if(content==null)
        {
            request.getSession().removeAttribute(key);
        }
        else {
            request.getSession(true).setAttribute(key,content);
        }

    }
}