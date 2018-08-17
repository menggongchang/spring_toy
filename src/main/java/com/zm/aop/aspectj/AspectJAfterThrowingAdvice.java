package com.zm.aop.aspectj;

import com.zm.aop.config.AspectInstanceFactory;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class AspectJAfterThrowingAdvice extends AbstractAspectjAdvice {


    public AspectJAfterThrowingAdvice(Method adviceMethod, AspectJExpressionPointcut pointcut, AspectInstanceFactory adviceObjectFactory) {

        super(adviceMethod, pointcut, adviceObjectFactory);
    }


    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Throwable t) {
            invokeAdviceMethod();
            throw t;
        }
    }
}