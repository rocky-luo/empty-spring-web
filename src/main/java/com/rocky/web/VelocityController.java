package com.rocky.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rocky on 17/2/8.
 */
@RequestMapping("/velocity")
@Controller
public class VelocityController {


    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response, Model model){
        model.addAttribute("name", "rocky");
        model.addAttribute("age", 18);
        return "hello-vm";
    }
}
