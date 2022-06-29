package com.jin.factory.config;
/*
这个类还是包装bean定义的类，用Class替换Object，好处是可以把bean实例化的过程放在容器中，
而不是在外面处理,在这个类中提供了让外部获取beanClass的方法
*/

public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
