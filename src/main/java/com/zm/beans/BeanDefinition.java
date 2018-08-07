package com.zm.beans;

import java.util.List;

public interface BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "singleton";

    void setScope(String scope);

    String getScope();

    boolean isSingleton();

    boolean isPrototype();

    String getBeanClassName();

    public List<PropertyValue> getPropertyValues();
}
