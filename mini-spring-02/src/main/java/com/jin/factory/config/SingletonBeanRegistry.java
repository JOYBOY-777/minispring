package com.jin.factory.config;
/*
* 这个是单例注册接口，提供获取单例对象的功能
* */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
