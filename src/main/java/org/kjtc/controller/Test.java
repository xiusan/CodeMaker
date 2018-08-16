package org.kjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/8/16/016.
 */
@Controller
public class Test {
    @RequestMapping(value = "/testoa")
    public String operatorInfoPage(){
        return "test";
    }

}
