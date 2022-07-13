package com.jin.bean;

public class UserService {
    private String name;

    public UserService() {
    }

    //多出来一个构造函数来进行测试实例化带参数的构造函数
    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息: " + name);
    }

    @Override
    public String toString() {
        //给这个StringBuilder一个初始化的值
        final StringBuilder sb = new StringBuilder("");
        sb.append(" ").append(name);
        return sb.toString();
    }
}
