package com.zm.aop;

public interface Pointcut {
    String getExpression();
    MethodMatcher getMethodMatcher();
}
