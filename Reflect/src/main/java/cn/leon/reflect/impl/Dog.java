package cn.leon.reflect.impl;

import cn.leon.reflect.Animal;

public class Dog implements Animal {
    @Override
    public String getType() {
        return "狗";
    }
}
