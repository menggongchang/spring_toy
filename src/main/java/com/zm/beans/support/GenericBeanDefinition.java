package com.zm.beans.support;

import com.zm.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String className;
    private boolean singleton = true;
    private boolean prototype = false;
    private String scope = SCOPE_DEFAULT;

    public GenericBeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public boolean isPrototype() {
        return this.prototype;
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
