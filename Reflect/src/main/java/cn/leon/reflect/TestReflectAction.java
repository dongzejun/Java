/**
 * 案例参考自
 * https://baijiahao.baidu.com/s?id=1619748187138646880&wfr=spider&for=pc
 */
package cn.leon.reflect;

import cn.leon.reflect.impl.Cat;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectAction {

    /**
     * 反射的三种方式
     */
    @Test
    public void threeWaysOfReflection(){
        //第一种（能实例化就无须反射了，多此一举）
        Cat cat = new Cat();
        Class catC = cat.getClass();
        System.out.println(catC.getName());

        //第二种（须引入Cat类，依赖性强）
        Class cat2 = Cat.class;
        System.out.println(cat2.getName());

        //第三种(常用)
        try {
            Class cat3 = Class.forName("cn.leon.reflect.impl.Cat");
            System.out.println(cat3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射获取构造方法
     */
    @Test
    public void getConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class user = Class.forName("cn.leon.reflect.User");

        System.out.println("=====================获得所有公用的构造方法=====================");
        Constructor[] pubConstructors = user.getConstructors();
        for (Constructor cons : pubConstructors) {
            System.out.println(cons);
        }

        System.out.println("=====================获得所有的构造方法=====================");
        Constructor[] allConstructor = user.getDeclaredConstructors();
        for (Constructor cons : allConstructor) {
            System.out.println(cons);
        }

        System.out.println("=====================获得共有 & 无参的构造方法=====================");
        Constructor pubAndNoParamCon = user.getConstructor(null);
        System.out.println(pubAndNoParamCon);

        System.out.println("=====================获得共有 & 有参的构造方法=====================");
        Constructor pubAndParamCon = user.getConstructor(String.class);
        System.out.println(pubAndParamCon);

        System.out.println("=====================获得私有 & 有参的构造方法=====================");
        Constructor priAndParamCon = user.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(priAndParamCon);
    }

    /**
     * 通过反射获取类属性
     */
    @Test
    public void getClassAttributes() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class userClass = Class.forName("cn.leon.reflect.User");
        System.out.println("=====================获取所有的公共字段=====================");
        Field[] pubFields = userClass.getFields();
        for (Field field : pubFields) {
            System.out.println(field);
        }

        System.out.println("=====================获取所有的段=====================");
        Field[] privateFields = userClass.getDeclaredFields();
        for (Field field : privateFields) {
            System.out.println(field);
        }

        System.out.println("=====================获取公共字段并使用=====================");
        Field pubField = userClass.getField("address");
        Object object = userClass.getConstructor(null).newInstance();
        pubField.set(object, "河南省郑州市");
        User user = (User) object;
        System.out.println(user.getAddress());

        System.out.println("=====================获取私有字段并使用=====================");
        Field priField = userClass.getDeclaredField("name");
        priField.setAccessible(true);
        priField.set(object, "Leon");
        System.out.println(user.getName());
    }

    /**
     * 通过反射获取方法
     */
    @Test
    public void getMethods() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class aClasss = Class.forName("cn.leon.reflect.User");

        System.out.println("=====================获取所有的public修改的方法=====================");
        Method[] pubMethods = aClasss.getMethods();
        for (Method method : pubMethods) {
            System.out.println(method);
        }

        System.out.println("=====================获取所有的方法=====================");
        Method[] allMethods = aClasss.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method);
        }

        System.out.println("=====================获取特定方法（带参）并使用=====================");
        Method paramsMethod = aClasss.getMethod("setName", String.class);
        System.out.println(paramsMethod);

        System.out.println("=====================获取特定方法（不带参）并使用=====================");
        Method noParamMethod = aClasss.getDeclaredMethod("getName");
        System.out.println(noParamMethod);

        System.out.println("=====================获取特定方法（多个参数）并使用=====================");
        Method moreParamMethod = aClasss.getDeclaredMethod("displayPersonalInformation", String.class, int.class, String.class);
        System.out.println(moreParamMethod);
        //获取构造方法，实例化一个对象
        User obj = (User) aClasss.getConstructor().newInstance();
        //给方法传递值
        Object invoke = moreParamMethod.invoke(obj, "Leon", 27, "河南周口");


        System.out.println(invoke);

    }

    /**
     * 反射执行main方法
     */
    @Test
    public void runMainMethod() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        // 获取Class对象
        Class aClass = Class.forName("cn.leon.reflect.User");

        // 获取Main方法
        Method mainMethod = aClass.getMethod("main", java.lang.String[].class);
        // 调用
        mainMethod.invoke(aClass.getConstructor().newInstance(), (Object) new String[]{"a"});
    }


}
