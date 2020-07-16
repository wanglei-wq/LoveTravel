package cn.kgc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/9.
 */
public class TheLogger {
    private static final Logger LOGGER = Logger.getLogger(TheLogger.class);

    public void before(JoinPoint jp){
        LOGGER.info("调用了"+jp.getTarget()+"类的"+jp.getSignature()+"方法________________方法入参________________"+ Arrays.toString(jp.getArgs()));
    }
    public void after(JoinPoint jp,Object result){
        LOGGER.info("返回了"+jp.getTarget()+"类的"+jp.getSignature()+"方法,方法返回________________"+result);
    }
}
