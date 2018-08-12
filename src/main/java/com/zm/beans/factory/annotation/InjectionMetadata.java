package com.zm.beans.factory.annotation;

import java.util.List;

/**
 * 代笔一个注解类
 *
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午4:20
 */
public class InjectionMetadata {
    private final Class<?> targetClass;
    private List<InjectionElement> injectionElements;

    public InjectionMetadata(Class<?> targetClass, List<InjectionElement> injectionElements) {
        this.targetClass = targetClass;
        this.injectionElements = injectionElements;
    }

    public List<InjectionElement> getInjectionElements() {
        return injectionElements;
    }

    public void inject(Object target) {
        if (injectionElements == null || injectionElements.isEmpty()) {
            return;
        }
        for (InjectionElement ele : injectionElements) {
            ele.inject(target);
        }
    }
}
