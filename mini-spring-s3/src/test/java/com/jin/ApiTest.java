package com.jin;

import com.jin.bean.UserService;
import com.jin.factory.config.BeanDefinition;
import com.jin.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ApiTest {
    @Test
    public void test_Beanfactory(){
        //用最下层的beanFactory类实例化BF
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注入bean首先包装成一个BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        //包装完之后就就把bean名称和bean定义注册到IOC容器中
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        //从工厂中获取bean,并且获取的是带参数的bean，当然采用的是CGLIB形式
        UserService userService =(UserService) beanFactory.getBean("userService", "库赞");
        //调用bean获取方法
        userService.queryUserInfo();
    }

    @Test
    //测试利用无参构造函数new出对象
    public void test_newInstance() throws InstantiationException, IllegalAccessException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    //测试有参构造函数实例化
    public void test_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> constructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = constructor.newInstance("库赞");
        System.out.println(userService);
    }

    @Test
    //获取构造函数的信息
    public void test_parameterTypes() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<?>[] constructors = userServiceClass.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("库赞");
        System.out.println(userService);
    }

    @Test
    //CGLIB测试
    public void test_cglib(){
        Enhancer enhancer = new Enhancer();
        //指定父类
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object userService = enhancer.create(new Class[]{String.class}, new Object[]{"库赞"});
        System.out.println(userService);
    }
}
