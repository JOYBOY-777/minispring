package com.jin.factory.support;

import com.jin.BeansException;
import com.jin.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/*
* 这个类是对Bean进行实例化的主要实现
* */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    //我们选取一种实例化创建Bean的方法，这里就选择CGLIB来进行匹配
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    //这个是真正的通过有参，无参的构造函数实例化的方法
    protected Object createBeanInstance (BeanDefinition beanDefinition,String beanName,Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            //从类中的构造器中找到唯一匹配的构造器进行选择，也就是给外面那么空的构造器赋值,找到了就跳出
            if (args != null && ctor.getParameterTypes().length == args.length){
                constructorToUse  = ctor;
                break;
            }
        }
        //拿到了符合标准的参数之后直接进行CGLIB方式进行
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }



    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


}

