package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//提供jdk中的动态代理的具体实现方法
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        //获取这个beanDefinition的class对象
        Class clazz = beanDefinition.getBeanClass();
        try {
            if(ctor!= null) {
                //此方法返回具有指定参数列表构造函数的构造函数对象,没有指定获取那个参数类型的构造器，那么就直接默认获取有的：ctor.getParameterTypes()
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
                }
            }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new BeansException("Failed to instantiate [" + clazz.getName()+"]",e);
            }
    }
}
