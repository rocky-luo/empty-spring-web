package com.rocky.web;

import com.google.common.collect.Lists;
import com.rocky.service.CglibCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by rocky on 18/5/7.
 */
@RequestMapping("/jvm")
@Controller
public class JvmController {
    private List<Object> objects = Lists.newArrayList();

    @RequestMapping("/addCglib")
    @ResponseBody
    public String addCglib(Integer num) {
        if (num == null) {
            num = 1;
        }
        for (; num > 0; num--) {
            StringHolder stringHolder = CglibCreator.<StringHolder>getObject(new StringHolder("a"));
            objects.add(stringHolder);
            System.out.println("队列中:" + objects.size());
        }
        return "ok";
    }
}
