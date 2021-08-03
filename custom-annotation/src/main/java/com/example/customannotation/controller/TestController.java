package com.example.customannotation.controller;

import com.example.customannotation.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qzz
 */
@RestController
@RequestMapping("api/sys")
public class TestController {

    @SysLog("测试注解")
    @GetMapping("/testAnnotation")
    public String testAnnotation(String name){
        return "您好"+name;
    }

    @SysLog(desc = "测试注解1")
    @GetMapping("/testAnnotation1")
    public String testAnnotation1(String name){
        return "hello,"+name;
    }
}
