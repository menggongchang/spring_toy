package com.zm.beans.factory.config;

import org.springframework.util.Assert;

import java.lang.reflect.Field;

/**
 * 类的字段描述符，用于autowired
 * 字段、setter、构造函数
 *
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午3:49
 */
public class DependencyDescriptor {
    private Field field;
    private boolean required;

    public DependencyDescriptor(Field field, boolean required) {
        Assert.notNull(field, "Field must not be null");
        this.field = field;
        this.required = required;

    }

    public Class<?> getDependencyType() {
        if (this.field != null) {
            return field.getType();
        }
        throw new RuntimeException("only support field dependency");
    }

    public boolean isRequired() {
        return this.required;
    }
}
