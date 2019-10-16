package cn.leon.reflect.impl;

import cn.leon.reflect.Animal;

public class Cat  implements Animal {
    @Override
    public String getType() {
        return "猫";
    }
}
