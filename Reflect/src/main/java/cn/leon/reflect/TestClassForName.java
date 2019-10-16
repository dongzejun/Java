package cn.leon.reflect;

import org.junit.Test;

public class TestClassForName {
    /**
     *  测试Class.forName() 和 ClassLoader的区别
     *  测试发现：1. Class.forName加载类是将类进了初始化，初始化了static{}代码块，初始化了静态属性值
     *          2. ClassLoader的loadClass并没有对类进行初始化，只是把类加载到了虚拟机中。
     */
    @Test
    public void test(){
        try {
            Class.forName("cn.leon.reflect.ClassForName");
            System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
            Class aClass = ClassLoader.getSystemClassLoader().loadClass("cn.leon.reflect.ClassForName");
            System.out.println("----------------------");
            Object obj = aClass.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
