package cn.leon.reflect;

import cn.leon.reflect.impl.Cat;
import cn.leon.reflect.impl.Dog;
import cn.leon.reflect.impl.Elephant;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_RTTI_Obj {

    /**
     * RTTI假定我们在编译时已经知道了所有的类型
     * @return
     */
    private static List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Cat()); // 已知类型Cat
        animals.add(new Elephant()); // 已知类型Elephant
        animals.add(new Dog()); // 已知类型 Dog
        return animals;
    }

    @Test
    public void testRTTI(){
        List<Animal> animals = createAnimals();
        for (Animal animal : animals){
            System.out.println(animal.getType());
        }
    }

}
