package com.concurrent.demo20Single;

/**
 * 饿汉式
 * 1. 直接创建对象
 * 2. 如果创建大量不使用的对象就是资源的浪费
 * 3. 饿汉式不会出现线程问题
 * 4，反射可能会出现非单例问题
 * @author lane
 * @date 2021年05月29日 下午4:44
 */
public class SingleDemoHungry {

    public static SingleDemoHungry singleDemoHungry = new SingleDemoHungry();
//    private SingleDemoHungry(){}
    private SingleDemoHungry(){
        if (singleDemoHungry!=null){
            throw new RuntimeException("小老弟，没想到吧，防御一手");
        }

    }
    public static SingleDemoHungry getInstance(){

        return singleDemoHungry;

    }



}
