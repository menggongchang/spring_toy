package com.zm.context;

import com.zm.beans.factory.BeanFactory;

public interface ApplicationContext extends BeanFactory {
    @Override
    default Object getBean(String beanId) {
        return null;
    }
}
