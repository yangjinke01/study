package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    private static final String SUCCESS = "success";

    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("hello world");
        return SUCCESS;
    }
}
