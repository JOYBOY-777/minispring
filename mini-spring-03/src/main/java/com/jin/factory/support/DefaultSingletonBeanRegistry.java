package com.jin.factory.support;

import com.jin.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/*
* 这个类提供获取单例Bean的实现，并且还额外实现了一个受保护的添加单例的方法
* */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    //用hashmap来存放单例的bean，并且根据名字获取bean对象
    private Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
