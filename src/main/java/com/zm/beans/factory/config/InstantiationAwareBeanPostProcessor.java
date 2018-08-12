package com.zm.beans.factory.config;

import com.zm.beans.BeanException;

/**
 * Bean生命周期相关
 *
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午4:50
 */
public interface InstantiationAwareBeanPostProcessor  extends BeanPostProcessor{
    Object beforeInstantiation(Class<?> beanClass, String beanName) throws BeanException;

    boolean afterInstantiation(Object bean, String beanName) throws BeanException;

    void postProcessPropertyValues(Object bean, String beanName)
            throws BeanException;
}
