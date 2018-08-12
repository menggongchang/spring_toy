package com.zm.context.support;

import com.zm.beans.factory.annotation.AutowiredAnnotationProcessor;
import com.zm.beans.factory.config.ConfigurableBeanFactory;
import com.zm.beans.factory.xml.XmlBeanDefinitionReader;
import com.zm.beans.factory.support.DefaultBeanFactory;
import com.zm.context.ApplicationContext;
import com.zm.core.io.Resource;
import org.springframework.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory;
    private ClassLoader classLoader;

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinition(resource);
        factory.setBeanClassLoader(this.getBeanClassLoader());
        registerBeanPostProcessors(factory);
    }

    protected abstract Resource getResourceByPath(String path);

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }

    public ClassLoader getBeanClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.classLoader = beanClassLoader;
    }

    //注册钩子处理器
    protected void registerBeanPostProcessors(ConfigurableBeanFactory beanFactory) {
        AutowiredAnnotationProcessor postProcessor = new AutowiredAnnotationProcessor();
        postProcessor.setBeanFactory(beanFactory);
        beanFactory.addBeanPostProcessor(postProcessor);
    }
}
