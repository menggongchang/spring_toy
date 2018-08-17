package com.zm.aop.aspectj;

import com.zm.aop.Advice;
import com.zm.aop.Pointcut;
import com.zm.aop.config.AspectInstanceFactory;

import java.lang.reflect.Method;

/**
 * <aop:before pointcut-ref="placeOrder" method="start" />
 */
public abstract class AbstractAspectjAdvice implements Advice {
    protected Method adviceMethod;//执行的方法
    protected Pointcut pointcut;
    protected AspectInstanceFactory adviceObjectFactory;//执行的方法所属的对象

    public AbstractAspectjAdvice(Method adviceMethod,
                                 AspectJExpressionPointcut pointcut,
                                 AspectInstanceFactory adviceObjectFactory) {
        this.adviceMethod = adviceMethod;
        this.pointcut = pointcut;
        this.adviceObjectFactory = adviceObjectFactory;
    }

    public void invokeAdviceMethod() throws Throwable {

        adviceMethod.invoke(adviceObjectFactory.getAspectInstance());
    }

    public Pointcut getPointCut() {
        return this.pointcut;
    }

    public Method getAdviceMethod() {
        return adviceMethod;
    }

    public Object getAdviceInstance() throws Exception {
        return adviceObjectFactory.getAspectInstance();
    }
}
