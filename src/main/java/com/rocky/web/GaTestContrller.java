package com.rocky.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rocky on 17/2/17.
 */
@RequestMapping("/ga")
@Controller
public class GaTestContrller {
    @RequestMapping("/ga1")
    public String ga1() {
        return "ga1";
    }
    @RequestMapping("/ga2")
    public String ga2(){
        return "ga2";
    }
}
