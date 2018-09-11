package com.busi.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Song on 2017/2/15.
 * 官方示例工程中的测试代码
 */
@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "success";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
//        SpringApplication.run(MsgController.class, args);
    }
}