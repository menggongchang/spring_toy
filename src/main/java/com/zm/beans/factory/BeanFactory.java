package com.zm.beans.factory;

import com.zm.beans.BeanDefinition;

public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String beanId);
}
