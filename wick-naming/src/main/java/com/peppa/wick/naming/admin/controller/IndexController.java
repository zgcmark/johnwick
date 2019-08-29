package com.peppa.wick.naming.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(path = "/index",produces = "text/html")
    public String index(){
        return "test";
    }
}
