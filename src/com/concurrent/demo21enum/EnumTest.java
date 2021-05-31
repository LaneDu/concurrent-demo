package com.concurrent.demo21enum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lane
 * @date 2021年05月30日 上午11:02
 */
public class EnumTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("Result.SUCCESS.toString():"+Result.SUCCESS);
        System.out.println("Result.SUCCESS.name():"+Result.SUCCESS.name());
        System.out.println("Result.SUCCESS.ordinal():"+Result.SUCCESS.ordinal());
        System.out.println("～～～～～～～华丽的分割线～～～～～～～～自己定义的方法～～～～～");
        System.out.println("Result.SUCCESS.code():"+Result.SUCCESS.code());
        System.out.println("Result.SUCCESS.message():"+Result.SUCCESS.message());
        System.out.println("Result.ERROR:"+Result.ERROR);


        System.out.println(Week.Monday);
        Class<Week> weekClass = Week.class;

//        Constructor<Week> declaredConstructor = weekClass.getDeclaredConstructor(null);
        Constructor<Week> declaredConstructor = weekClass.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance();

    }
}
