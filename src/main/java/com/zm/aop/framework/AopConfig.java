package com.zm.aop.framework;

import com.zm.aop.Advice;

import java.lang.reflect.Method;
import java.util.List;

public interface AopConfig {
    Class<?> getTargetClass();

    Object getTargetObject();

    void setTargetObject(Object obj);

    void addAdvice(Advice advice);

    List<Advice> getAdvices(Method method/*,Class<?> targetClass*/);

    List<Advice> getAdvices();


    //JDKProxy

    boolean isProxyTargetClass();


    Class<?>[] getProxiedInterfaces();


    boolean isInterfaceProxied(Class<?> intf);

}
