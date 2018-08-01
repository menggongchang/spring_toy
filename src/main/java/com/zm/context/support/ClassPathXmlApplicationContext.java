package com.zm.context.support;

import com.zm.core.io.ClassPathResource;
import com.zm.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {


    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path, this.getBeanClassLoader());
    }
}
