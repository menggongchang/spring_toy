package com.zm.beans.factory.config;

public interface SingletonBeanRegistry {
    void registrySingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
