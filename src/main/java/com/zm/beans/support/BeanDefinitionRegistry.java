package com.zm.beans.support;

import com.zm.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanId);

    void registryBeanDefinition(String beanId, BeanDefinition beanDefinition);
}
