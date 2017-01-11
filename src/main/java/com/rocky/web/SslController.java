package com.rocky.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rocky on 17/1/12.
 */
@RequestMapping("/.well-known")
@Controller
public class SslController {
    @RequestMapping("/pki-validation/fileauth.htm")
    @ResponseBody
    public String ttt(){
        return "20170111231652348edk4omcmzenazuk6me6xx73vnqk10v4u3qw4mqfwota6xaf";
    }

}
