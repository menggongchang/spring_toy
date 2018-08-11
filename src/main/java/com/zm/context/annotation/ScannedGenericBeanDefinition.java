package com.zm.context.annotation;

import com.zm.beans.factory.annotation.AnnotatedBeanDefinition;
import com.zm.beans.factory.support.GenericBeanDefinition;
import com.zm.core.type.AnnotationMetadata;

//扫描包下的class文件，依据注解生成的beanDifinition
public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

    private final AnnotationMetadata metadata;


    public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
        super();

        this.metadata = metadata;

        setBeanClassName(this.metadata.getClassName());
    }


    public final AnnotationMetadata getMetadata() {
        return this.metadata;
    }

}