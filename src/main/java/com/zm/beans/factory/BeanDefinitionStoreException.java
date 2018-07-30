package com.zm.beans.factory;

import com.zm.beans.BeanException;

/**
 * 解析xml获取BeanDefinition时抛出的异常
 */
public class BeanDefinitionStoreException extends BeanException {
    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
