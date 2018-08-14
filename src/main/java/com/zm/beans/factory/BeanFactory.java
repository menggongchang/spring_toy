package com.zm.beans.factory;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public interface BeanFactory {
    Object getBean(String beanId);
    Class<?> getType(String beanId) throws NoSuchBeanDefinitionException;
}
