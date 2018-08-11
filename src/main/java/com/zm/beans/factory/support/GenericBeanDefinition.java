package com.zm.beans.factory.support;

import com.zm.beans.BeanDefinition;
import com.zm.beans.ConstructorArgument;
import com.zm.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String className;
    private boolean singleton = true;
    private boolean prototype = false;
    private String scope = SCOPE_DEFAULT;
    private List<PropertyValue> propertyValues = new ArrayList<>();
    private ConstructorArgument constructorArgument = new ConstructorArgument();

    public GenericBeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public GenericBeanDefinition() {

    }

    public void setBeanClassName(String className){
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
    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }

    @Override
    public ConstructorArgument getConstructorArgument() {
        return this.constructorArgument;
    }

    @Override
    public boolean hasConstructorArgumentValues() {
        return !this.constructorArgument.isEmpty();
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "GenericBeanDefinition{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
