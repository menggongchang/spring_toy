package com.zm.beans.support;

import com.zm.beans.BeanDefinition;
import com.zm.beans.factory.BeanCreationException;
import com.zm.beans.factory.BeanDefinitionStoreException;
import com.zm.beans.factory.BeanFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DefaultBeanFactory implements BeanFactory {

    private final static String ID_ATTRIBUTE = "id";
    private final static String CLASS_ATTRIBUTE = "class";
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public DefaultBeanFactory(String configFile) {
        loadBeanDefinition(configFile);
    }

    //解析xml配置文件
    private void loadBeanDefinition(String configFile) {
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
            inputStream = classLoader.getResourceAsStream(configFile);

            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();//beans
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String id = element.attributeValue(ID_ATTRIBUTE);
                String className = element.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition beanDefinition = new GenericBeanDefinition(id, className);
                this.beanDefinitionMap.put(id, beanDefinition);
            }
        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("IOException parsing xml.", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    @Override
    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = getBeanDefinition(beanId);
        if (beanDefinition == null) {
            throw new BeanCreationException("Bean definition doesn't exit");
        }
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        String beanClassName = beanDefinition.getBeanClassName();
        try {
            Class<?> clz = classLoader.loadClass(beanClassName);
            return clz.newInstance();//反射
        } catch (Exception e) {
            throw new BeanCreationException("Create bean for " + beanId + "failed. ", e);
        }
    }
}
