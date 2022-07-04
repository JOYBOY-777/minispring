package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//这个接口提供实例化策略接口，一种是在JDK中自带的动态代理，一种是用CGLIB进行动态代理
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args) throws BeansException;
}
