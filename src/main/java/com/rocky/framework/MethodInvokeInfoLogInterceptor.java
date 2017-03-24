package com.rocky.framework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by rocky on 17/3/21.
 */
@Aspect
@Component
public class MethodInvokeInfoLogInterceptor {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @Around("within(com.rocky..*) && @annotation(logMethodInvokeInfo)")
    public Object logInfo(ProceedingJoinPoint pjp, LogMethodInvokeInfo logMethodInvokeInfo) throws Throwable {
        Logger logger = null;
        long start = -1l;
        long end = -1l;
        if (StringUtils.isEmpty(logMethodInvokeInfo.logger())) {
            LOGGER.warn("没有指定logger，使用默认的logger");
            logger = LOGGER;
        } else {
            try {
                Field field = pjp.getTarget().getClass().getDeclaredField(logMethodInvokeInfo.logger());
                field.setAccessible(true);
                Object loggerTemp = field.get(pjp.getTarget());
                if (loggerTemp instanceof Logger) {
                    logger = (Logger) loggerTemp;
                } else {
                    LOGGER.warn("指定的logger类型不为{},使用默认的logger", Logger.class);
                    logger = LOGGER;
                }
            } catch (NoSuchFieldException e) {
                LOGGER.warn("指定的logger[" + logMethodInvokeInfo.logger() + "]不存在，使用默认的logger");
                logger = LOGGER;
            } catch (IllegalAccessException e) {
                LOGGER.warn("指定的logger[" + logMethodInvokeInfo.logger() + "]不存在，使用默认的logger");
                logger = LOGGER;
            }
        }
        if (logMethodInvokeInfo.reqInfo()) {
            logger.info(pjp.getSignature() + "输入参数>>>>>>>>>>>>" + getFormatArgs(pjp.getArgs()));
        }
        if (logMethodInvokeInfo.timing()){
            start = System.currentTimeMillis();
        }
        Object result = pjp.proceed(pjp.getArgs());
        if (logMethodInvokeInfo.timing()){
            end = System.currentTimeMillis();
        }
        if (logMethodInvokeInfo.retInfo()) {
            logger.info(pjp.getSignature() + "输出结果<<<<<<<<<<<<" + getFormatArgs(new Object[]{result}));
        }
        if (logMethodInvokeInfo.timing()){
            long useTime = end -start;
            logger.info(pjp.getSignature() + "执行耗时============" + useTime +"毫秒");
        }
        return result;

    }

    private String getFormatArgs(Object[] args) {
        if (args == null || args.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (Object ob : args) {
            if (ob != null) {
                sb.append(ob.getClass().getName()).append("{")
                        .append(ob.toString()).append("},");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
