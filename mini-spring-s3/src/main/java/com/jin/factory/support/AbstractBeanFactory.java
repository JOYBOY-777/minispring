package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.BeanFactory;
import com.jin.factory.config.BeanDefinition;

/*
* 关键的抽象工厂类，里面定义几种模板方法，为了以后给他的子类自定义实现,抽象类不必实现接口，也可以实现接口中全部方法
* 或者部分方法，如果实现的是部分的方法，如果一个类只需要用到接口中的部分方法，那么让他去继承这个类就可以用接口中的部分方法了，
* 有点前人栽树，后人乘凉的意思
* */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    //通过无参构造获取bean
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    //通过有参构造获取bean
    public Object getBean(String name, Object... ages) throws BeansException {
        return doGetBean(name,ages);
    }

    //提供有参或者无参的方式获取bean
    protected <T> T doGetBean(final String name,final Object[] args){
        //首先尝试去获取单例的bean
        Object bean = getSingleton(name);
        if (bean != null) return (T) bean;
        //如果拿不到的话就去拿Bean的定义，然后在去创建一个bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }

    //根据bean名字去获取bean的定义
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    //根据bean的名字，bean包装的定义还有构造器的参数等来创建一个bean，这个参数可以传空
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeansException;
}
