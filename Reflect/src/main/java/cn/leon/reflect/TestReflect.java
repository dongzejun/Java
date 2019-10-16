package cn.leon.reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class TestReflect {
    @Test
    public void testReflect(){
        List<Object> animals = createAnimals();
        for (Object animal : animals){
            System.out.println(invokeGetType(animal));
        }
    }

    private final String[] ANIMAL_TYPES = new String[]{
            "cn.leon.reflect.impl.Cat",
            "cn.leon.reflect.impl.Elephant",
            "cn.leon.reflect.impl.Dog"
    };

    /**
     * 反射允许我们在运行时获取类型信息
     * @return
     */
    private List<Object> createAnimals() {
        List<Object> animals = new ArrayList<>();
        for (String cls : ANIMAL_TYPES){
            animals.add(instanceByReflect(cls));
        }
        return animals;
    }

    /**
     * 使用反射机制，在运行时动态的实例化对象(等同于new关键字)
     * @param clsStr
     * @return
     */
    private Object instanceByReflect(String clsStr) {
        try {
            // 通过反射获取类型信息
            Class cls = Class.forName(clsStr);
            // 通过Class实例化对象
            Object object = cls.newInstance();
            return object;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 利用反射API执行getType方法（等同于animal.getType）
     * @param animal
     * @return
     */
    private String invokeGetType(Object animal){
        try {
            Method getTypeMethod = Animal.class.getMethod("getType");
            return (String) getTypeMethod.invoke(animal);
        }catch (Exception e){
            return null;
        }

    }

}
