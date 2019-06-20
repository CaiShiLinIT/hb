package com.hb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/caidan")
public class PageController {

    @RequestMapping("/diancan")
    public String doDianCan(){
        return "diancan";
    }

}
