package com.concurrent.demo21enum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举单例
 * @author lane
 * @date 2021年05月31日 下午6:11
 */
public enum  Single {
    INS;

    private Single (){}

    public static Single getInstance(){
        return INS;
    }

}

class EnumDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Single instance1 = Single.getInstance();
        Single instance2 = Single.getInstance();
        System.out.println("枚举是否单例" +(instance1 == instance2));

        Class<Single> singleClass = Single.class;
        //因为枚举默认继承Enum类，必须两个参数的构造
//        singleClass.getDeclaredConstructor(null);
        Constructor<Single> declaredConstructor = singleClass.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Single single1 = declaredConstructor.newInstance();
        Single single2 = declaredConstructor.newInstance();
        System.out.println("反射下看枚举单例能否被破坏："+(single1==single2));




    }

}
