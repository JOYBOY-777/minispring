package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;

/*
* 这个类是对Bean进行实例化的主要实现
* */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            //通过bean的定义获取Bean的class对象，在通过反射得到这个bean的实例化对象
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException |IllegalAccessException e) {
            throw new RuntimeException("Instantiation of bean failed ", e);
        }
        //通过反射获取到bean以后在添加到单例的缓存中去
        addSingleton(beanName,bean);
        return bean;
    }
}
