package com.jin;

import com.jin.bean.UserService;
import com.jin.factory.config.BeanDefinition;
import com.jin.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册Bean，先把这个原装的bean给包装成为一个beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        //在把这个BeanDefinition注册到容器中
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        //从容器中把这个实例化的beanDefinition对象拿出并使用
        UserService userService = (UserService) beanFactory.getBean("userService");
        //使用这个实例化的bean
        userService.queryUserInfo();
        //下面测试单例bean的获取,因为这个bean已经在容器总存在了，并且优先从容器中获取，进行判断
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        //执行方法
        userService1.queryUserInfo();
    }
}
