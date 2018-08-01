package com.zm.beans.factory.config;

import com.zm.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
    ClassLoader getBeanClassLoader();

    void setBeanClassLoader(ClassLoader beanClassLoader);
}
