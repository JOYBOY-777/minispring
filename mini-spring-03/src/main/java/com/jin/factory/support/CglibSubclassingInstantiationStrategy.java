package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/*
* 次方法采用动态代理中的CGLIB方式将构造方法实例化，
* 与之对应的是采用反射机制进行实例化的操作，当然这个是采用的springboot默认集成的cglib
* */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        //采用CGLIB方式实例化对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        //使用构造器默认创建对象
        if (ctor == null) return enhancer.create();
        //根据参数实例化对象
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
