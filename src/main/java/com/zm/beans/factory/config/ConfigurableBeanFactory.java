package com.zm.beans.factory.config;

import java.util.List;

public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory {
    ClassLoader getBeanClassLoader();
    void setBeanClassLoader(ClassLoader beanClassLoader);

    void addBeanPostProcessor(BeanPostProcessor postProcessor);
    List<BeanPostProcessor> getBeanPostProcessors();

}
