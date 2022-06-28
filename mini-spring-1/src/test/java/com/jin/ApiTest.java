package com.jin;

import com.jin.bean.UserService;
import org.junit.jupiter.api.Test;

//测试类
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();
        //把这个bean包装成一个beanDefinition之后注册到工厂中
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        //注册到工厂中
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        //通过工厂获取bean之后在执行方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
