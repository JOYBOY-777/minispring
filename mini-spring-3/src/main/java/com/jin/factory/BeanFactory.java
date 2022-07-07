package com.jin.factory;

import com.jin.BeansException;

/*
* bean工厂接口，提供获取bean的功能
* */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    //新增了一个重载的抽象方法，次方法提供传递入参给构造函数实例化了
    Object getBean(String name,Object... ages) throws BeansException;
}
