package com.concurrent.demo13Function;

import java.util.function.Predicate;

/**
 * 有一个参数，返回值只能是布尔
 * @author lane
 * @date 2021年05月26日 下午7:10
 */
public class PredicateDemo {

    public static void main(String[] args) {
        //匿名内部类方式
        Predicate<String>  predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println("执行了predicate方法");
                return s.isEmpty();
            }
        };

        System.out.println(predicate.test("1024"));

        //lambda方式实现

        Predicate<String> predicate2 = (string)->{
            System.out.println("lambda执行了predicate方法");
            return string.isEmpty();};

        System.out.println(predicate2.test(""));


    }

}
