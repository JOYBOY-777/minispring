package com.jin.factory;

import com.jin.BeansException;

/*
* bean工厂接口，提供获取bean的功能
* */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
