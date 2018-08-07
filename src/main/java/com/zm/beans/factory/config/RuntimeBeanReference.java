package com.zm.beans.factory.config;

public class RuntimeBeanReference {
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }
}
