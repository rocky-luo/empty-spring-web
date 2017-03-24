package com.rocky.web;

import com.rocky.service.IHelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by rocky on 17/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AopAndTranTest {
    @Resource
    private IHelloWorldService helloWorldService;

    @Test
    public void aopAndTranTest(){
        helloWorldService.aopProxy();
    }
}
