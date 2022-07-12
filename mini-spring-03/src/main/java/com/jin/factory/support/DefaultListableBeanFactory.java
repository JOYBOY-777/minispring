package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/*
* 能够生产出成熟的，可用的bean定义的工厂类,并且也提供注册的功能
* */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    //定义一个存放beanDefinition的hashmap
    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    protected BeanDefinition getBeanDefinition(String BeanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(BeanName);
        if (beanDefinition == null) throw new BeansException("No bean named" + BeanName + "is defined");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
