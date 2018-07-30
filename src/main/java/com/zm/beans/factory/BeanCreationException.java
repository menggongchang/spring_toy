package com.zm.beans.factory;

import com.zm.beans.BeanException;

/**
 * bean 创建过程中抛出的异常
 */
public class BeanCreationException extends BeanException {
    private String beanName;

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationException(String beanName, String message) {
        super("Error creating bean with name '" + beanName + "':" + message);
        this.beanName = beanName;
    }

    public BeanCreationException(String beanName, String message, Throwable cause) {
        this(beanName, message);
        initCause(cause);

    }

    public String getBeanName() {
        return beanName;
    }
}
