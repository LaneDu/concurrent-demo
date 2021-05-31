package com.concurrent.demo20Single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lane
 * @date 2021年05月29日 下午4:48
 */
public class SingleTest {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {

      //  hungryTest();
        LazyTest();
        
    }
    //懒汉式测试
    private static void LazyTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        LazyDemo lazyDemo1 =LazyDemo.getInstance();
        LazyDemo lazyDemo2 =LazyDemo.getInstance();
        System.out.println("懒汉式测试是否单例："+(lazyDemo1==lazyDemo2));//true
        //反射创建
        Class<LazyDemo> lazyDemoClass = LazyDemo.class;
        //反射获取无参构造器
        Constructor<LazyDemo> declaredConstructor = lazyDemoClass.getDeclaredConstructor(null);
       //允许访问私有构造
        declaredConstructor.setAccessible(true);
        LazyDemo lazyDemo11 = declaredConstructor.newInstance();
        LazyDemo lazyDemo12 = declaredConstructor.newInstance();
        System.out.println("懒汉式测试反射是否单例："+(lazyDemo11==lazyDemo12));//false
        //除非知道字段否名称，否则无法再次破坏了
        Field num = lazyDemoClass.getDeclaredField("num");
        num.set(lazyDemo11,0);

    }


    //测试饿汉式
    public static void hungryTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //正常测试饿汉式单例
        SingleDemoHungry singleDemoHungry1  = SingleDemoHungry.getInstance();
        SingleDemoHungry singleDemoHungry2  = SingleDemoHungry.getInstance();
        System.out.println("饿汉式测试是否单例："+(singleDemoHungry1==singleDemoHungry2));//true
        //反射测试饿汉
        Class<SingleDemoHungry> singleDemoHungryClass = SingleDemoHungry.class;
        Constructor<SingleDemoHungry> constructor = singleDemoHungryClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingleDemoHungry singleDemoHungry11 = constructor.newInstance();
        System.out.println("饿汉式测试反射是否单例："+(singleDemoHungry11==singleDemoHungry1));//false

    }



}
