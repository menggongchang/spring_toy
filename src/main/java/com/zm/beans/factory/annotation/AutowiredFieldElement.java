package com.zm.beans.factory.annotation;

import com.zm.beans.factory.BeanCreationException;
import com.zm.beans.factory.config.AutowireCapableBeanFactory;
import com.zm.beans.factory.config.DependencyDescriptor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午4:24
 */
public class AutowiredFieldElement extends InjectionElement {
    boolean required;

    public AutowiredFieldElement(Field f, boolean required, AutowireCapableBeanFactory factory) {
        super(f, factory);
        this.required = required;
    }

    public Field getField() {
        return (Field) this.member;
    }

    //给字段赋值
    @Override
    public void inject(Object target) {
        Field field = this.getField();
        try {
            DependencyDescriptor desc = new DependencyDescriptor(field, this.required);
            Object value = factory.resolveDependency(desc);//字段的对象
            if (value != null) {
                ReflectionUtils.makeAccessible(field);
                field.set(target, value);
            }
        } catch (Throwable ex) {
            throw new BeanCreationException("Could not autowire field: " + field, ex);
        }
    }

}
