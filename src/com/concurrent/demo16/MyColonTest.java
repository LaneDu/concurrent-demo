package com.concurrent.demo16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.Supplier;

/**
 * 举例子讲解::表达式的及其四种类型
 * @author lane
 * @date 2021年05月27日 下午6:24
 */
public class MyColonTest {

    public static void main(String[] args) {
        test1();

    }

    // 多种方式循序渐进方便理解
    // test1引用特定对象的实例方法
    public static void test1(){

        //方式零：创建一个类MyColonImpl实现MyColon接口
        System.out.println("=============方式零================");
        MyColon myColon0 = new MyColonImpl();
        myColon0.fiveTwoSeven();
        //方式一：匿名内容类方式
        System.out.println("=============方式一================");
        MyColon myColon1 = new MyColon() {
            @Override
            public int fiveTwoSeven() {
                System.out.println("我是方式一：匿名内容类方式，昨天是5月27");
                return 0;
            }
        };
        myColon1.fiveTwoSeven();
        //方式二：lambda标准类型I
        System.out.println("=============方式二================");
        MyColon myColon2 = ()->{
        System.out.println("我是方式二：lambda标准类型I，昨天是5月27");
        return 0;};
        myColon2.fiveTwoSeven();
        //方式三：lambda推断类型II
        //注意：类MyColonDemo和接口MyColon 没有任何关系
        System.out.println("=============方式三================");
        MyColonDemo myColonDemo = new MyColonDemo();
        MyColon myColon3 = ()->{return myColonDemo.fiveTwoSevenDemo();};
        myColon3.fiveTwoSeven();
        //方式四：lambda推断类型II简化版
        System.out.println("=============方式四================");
        MyColon myColon4 = ()->myColonDemo.fiveTwoSevenDemo();
        myColon4.fiveTwoSeven();
        //方式五：lambda推断类型II ::表达式版 对象实例方法
        System.out.println("=============方式五================");
        MyColon myColon5= myColonDemo::fiveTwoSevenDemo;
        myColon5.fiveTwoSeven();
        //方式六： ::表达式版 类型静态方法
        System.out.println("=============方式六================");
        MyColon myColon6= MyColonDemo::staticFiveTwoSevenDemo;
        myColon6.fiveTwoSeven();
        //方式七： ::表达式版 引用特定类型的任意对象的实例方法
        System.out.println("=============方式七================");
        LongBinaryOperator longBinaryOperator = (long a, long b) -> Long.sum(a, b);
        LongBinaryOperator longBinaryOperator2 = Long::sum;
        System.out.println("方式七：引用特定类型如Long的sum方法"+longBinaryOperator2.applyAsLong(1, 2));
        BiFunction<String, String, Boolean> endsWith = String::endsWith;
        System.out.println("方式七：引用特定类型如String的endswith方法"+endsWith.apply("hello", "o"));
       //引用String的排序方法
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        Arrays.stream(stringArray).map(String::toUpperCase).toArray();
        //方式八： ::表达式版 引用构造函数方法，一般还是那种特定类型
        System.out.println("=============方式七================");
        //无返回值的一般不用
       /* public interface MyVoid {
            void test();
        }
        MyVoid myvoid = MyColonDemo::new;*/
        //返回值为该对象的
        Callable<MyColonDemo> myColonDemoCall = MyColonDemo::new;
        //返回值为hashSet
        HashSet<String> hashSet = new HashSet<>();
        Supplier<HashSet<String>> supHash = HashSet<String>::new;
        //返回值为String的
        Supplier<String> supplier = String::new;

    }



}

