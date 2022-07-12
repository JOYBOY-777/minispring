package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//这个接口提供实例化策略接口，一种是在JDK中自带的动态代理，一种是用CGLIB进行动态代理
public interface InstantiationStrategy {
    //既然是bean的实例化策略那么参数就是bean的定义，bean名称，构造器，以及构造起的参数等
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args) throws BeansException;
}
