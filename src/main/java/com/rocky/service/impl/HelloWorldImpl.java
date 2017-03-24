package com.rocky.service.impl;

import com.rocky.dao.IHelloWorldDAO;
import com.rocky.framework.LogMethodInvokeInfo;
import com.rocky.model.po.PersonPO;
import com.rocky.service.IHelloWorldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rocky on 16/9/2.
 */
@Service
public class HelloWorldImpl implements IHelloWorldService {
    @Resource
    private IHelloWorldDAO helloWorldDAO;


    @Override
    public PersonPO getById(Long id) {
        PersonPO po = helloWorldDAO.getById(id);
        return po;
    }

    @Override
    @Transactional
    public void batchInsert(List<PersonPO> personPOList) {
        for (PersonPO po : personPOList) {
            helloWorldDAO.insert(po);
        }
    }

    @Override
    public void aopProxy() {
        aop1();
        System.out.println("这是第1次测试=======");
        this.aop1();
        System.out.println("这是第2次测试=======");

    }

    @Override
    @LogMethodInvokeInfo(reqInfo = false, retInfo = false)
    public void aop1() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogMethodInvokeInfo(reqInfo = false, retInfo = false)
    private void aop2() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
