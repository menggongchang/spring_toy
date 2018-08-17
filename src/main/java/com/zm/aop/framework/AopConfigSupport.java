package com.zm.aop.framework;

import com.zm.aop.Advice;
import com.zm.aop.Pointcut;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AopConfigSupport implements AopConfig {


    private boolean proxyTargetClass = false;


    private Object targetObject = null;

    private List<Advice> advices = new ArrayList<>();

    private List<Class> interfaces = new ArrayList<>();


    public AopConfigSupport() {

    }


    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getTargetObject() {
        return this.targetObject;
    }

    public Class<?> getTargetClass() {
        return this.targetObject.getClass();
    }


    public void addInterface(Class<?> intf) {
        Assert.notNull(intf, "Interface must not be null");
        if (!intf.isInterface()) {
            throw new IllegalArgumentException("[" + intf.getName() + "] is not an interface");
        }
        if (!this.interfaces.contains(intf)) {
            this.interfaces.add(intf);

        }
    }

    public Class<?>[] getProxiedInterfaces() {
        return this.interfaces.toArray(new Class[this.interfaces.size()]);
    }

    public boolean isInterfaceProxied(Class<?> intf) {
        for (Class proxyIntf : this.interfaces) {
            if (intf.isAssignableFrom(proxyIntf)) {
                return true;
            }
        }
        return false;
    }

    public void addAdvice(Advice advice) {
        this.advices.add(advice);
    }


    public boolean isProxyTargetClass() {

        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public List<Advice> getAdvices() {

        return this.advices;
    }

    public List<Advice> getAdvices(Method method) {
        List<Advice> result = new ArrayList<>();
        for (Advice advice : this.getAdvices()) {
            Pointcut pc = advice.getPointCut();
            if (pc.getMethodMatcher().matches(method)) {
                result.add(advice);
            }
        }
        return result;
    }
}
