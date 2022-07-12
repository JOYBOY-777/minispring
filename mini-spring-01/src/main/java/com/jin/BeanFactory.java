package com.jin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//bean的工厂，包括对bean的获取还有注册(把bean放到这个工厂中)
public class BeanFactory {
    //用一个map来存储bean的定义
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    //根据名字获取bean,体现这个工厂的作用，根据key获取value
    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }
    //注册beanDefinition到这个工厂中来
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
