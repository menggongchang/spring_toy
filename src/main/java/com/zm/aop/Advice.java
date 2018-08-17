package com.zm.aop;

import org.aopalliance.intercept.MethodInterceptor;

public interface Advice extends MethodInterceptor {
    Pointcut getPointCut();
}
