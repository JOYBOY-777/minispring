package com.jin.factory.support;

import com.jin.factory.config.BeanDefinition;
//这个是注册bean定义的接口，提供功能
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
