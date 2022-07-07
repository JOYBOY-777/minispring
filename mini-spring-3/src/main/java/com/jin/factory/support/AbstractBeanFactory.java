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
    public Object getBean(String name) throws BeansException {
        //对单例bean对象的获取
        Object bean = getSingleton(name);
        if(bean!=null) return bean;
        //拿不到的话就去那bean的定义，根据名字还有bean定义去实例化Bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);

    }

    @Override
    public Object getBean(String name, Object... ages) throws BeansException {

        return null;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException;
}
