package com.zm.beans;

import java.util.List;

public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    String SCOPE_DEFAULT = "singleton";
    void setScope(String scope);
    String getScope();
    boolean isSingleton();
    boolean isPrototype();

    String getID();
    String getBeanClassName();

    List<PropertyValue> getPropertyValues();
    ConstructorArgument getConstructorArgument();
    boolean hasConstructorArgumentValues();

    Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException;
    Class<?> getBeanClass() throws IllegalStateException ;
    boolean hasBeanClass();
}
