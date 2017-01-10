package com.rocky.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by rocky on 16/9/1.
 */
@RequestMapping("/hello")
@Controller
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/world")
    @ResponseBody
    public String helloWorld() {
        return "hello, world, it is " + new Date();
    }
}
