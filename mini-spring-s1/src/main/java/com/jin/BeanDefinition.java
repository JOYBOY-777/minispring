package com.jin;
//用于存放Bean的定义是什么，比如是一个单例，多例等等，现在用一个object存放这个定义,给这个bean进行了封装
public class BeanDefinition {
    private Object bean;
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
    public Object getBean() {
        return bean;
    }
}
