package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.PriorityQueue;

public class Example {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Class<?>clazz =Person.class;
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object john = constructor.newInstance("John", 25);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println("Name: "+name.get(john));

        name.set(john,"Jane");
        System.out.println("Name: "+name.get(john));

        Method greet = clazz.getMethod("greet", String.class);
        greet.invoke(john, "Hello");

        PriorityQueue<Integer> objects = new PriorityQueue<>(Collections.reverseOrder());

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet(String message) {
        System.out.println(name + " says: " + message);
    }
}
