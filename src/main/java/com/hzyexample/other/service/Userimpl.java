package com.hzyexample.other.service;

/**
 * @author hzy
 * @date 2021-12-08
 */
public class Userimpl implements User{
    @Override
    public String getName(String name) {
        System.out.println("实现类");
        return name;
    }
}
