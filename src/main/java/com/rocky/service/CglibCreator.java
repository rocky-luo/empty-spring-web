package com.rocky.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by rocky on 18/5/7.
 */
public class CglibCreator {

    private final static Logger LOGGER = LoggerFactory.getLogger(CglibCreator.class);

    private static MethodInterceptor interceptor = new MethodInterceptor() {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            LOGGER.info("before target method [" + method.getName() + "]");
            Object result = methodProxy.invokeSuper(o, objects);
            LOGGER.info("after target method [" + method.getName() + "]");
            return result;
        }
    };


    public static <T> T getObject(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(interceptor);  // call back method
        return (T) enhancer.create();  // create proxy instance
    }

}
