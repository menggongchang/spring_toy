package com.zm.beans.factory.annotation;

import com.zm.beans.BeanDefinition;
import com.zm.core.type.AnnotationMetadata;

public interface AnnotatedBeanDefinition extends BeanDefinition {
    AnnotationMetadata getMetadata();
}