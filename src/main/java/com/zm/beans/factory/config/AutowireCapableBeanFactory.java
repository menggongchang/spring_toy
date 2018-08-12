package com.zm.beans.factory.config;

import com.zm.beans.factory.BeanFactory;

/**
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/8/12 下午3:54
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object resolveDependency(DependencyDescriptor descriptor);
}
