package com.zm.beans.factory.config;

import com.zm.beans.BeanException;

/**
 * Bean生命周期相关
 *
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午4:49
 */
public interface BeanPostProcessor {
    Object beforeInitialization(Object bean, String beanName) throws BeanException;
    Object afterInitialization(Object bean, String beanName) throws BeanException;
}
