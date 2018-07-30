package com.zm;

import com.zm.beans.factory.BeanFactory;
import com.zm.beans.support.DefaultBeanFactory;

/**
 * @author zhoumeng.zm@bytedance.com
 * @date 2018/7/30 上午10:40
 */
public class Java {
    public static void main(String args[]) {
        BeanFactory factory = new DefaultBeanFactory("test.xml");
    }

}
