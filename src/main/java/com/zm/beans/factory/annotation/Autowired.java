package com.zm.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * 自动注入的标签
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午3:46
 */

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    /**
     * Declares whether the annotated dependency is required.
     * <p>Defaults to {@code true}.
     */
    boolean required() default true;

}
