package com.zm;

import com.zm.beans.factory.xml.XmlBeanDefinitionReader;
import com.zm.beans.support.DefaultBeanFactory;
import com.zm.core.io.FileSystemResource;
import org.springframework.util.NumberUtils;

/**
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/7/30 上午10:40
 */
public class Java {
    public static void main(String args[]) {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinition("test.xml");


        FileSystemResource r = new FileSystemResource("/Users/zhoumeng/workplace/spring_toy/src/main/resources/test.xml");
        System.out.println(r.getDescription());
    }

}
