package com.zm.beans.factory.annotation;

import com.zm.beans.factory.config.AutowireCapableBeanFactory;

import java.lang.reflect.Member;

/**
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午4:20
 */
public abstract class InjectionElement {
    protected Member member;
    protected AutowireCapableBeanFactory factory;
    InjectionElement(Member member,AutowireCapableBeanFactory factory){
        this.member = member;
        this.factory = factory;
    }

    public abstract void inject(Object target);
}
