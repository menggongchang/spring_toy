package com.zm.beans.support;

import com.zm.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String className;


    public GenericBeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public String getBeanClassName() {
        return this.className;
    }

    @Override
    public String toString() {
        return "GenericBeanDefinition{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
