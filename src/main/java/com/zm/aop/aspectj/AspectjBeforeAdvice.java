package com.zm.aop.aspectj;

import com.zm.aop.config.AspectInstanceFactory;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * <aop:before pointcut-ref="placeOrder" method="start" />
 */
public class AspectjBeforeAdvice extends AbstractAspectjAdvice {

    public AspectjBeforeAdvice(Method adviceMethod, AspectJExpressionPointcut pointcut, AspectInstanceFactory adviceObjectFactory) {
        super(adviceMethod, pointcut, adviceObjectFactory);
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        //例如： 调用TransactionManager的start方法
        this.invokeAdviceMethod();
        Object o = mi.proceed();
        return o;
    }
}
