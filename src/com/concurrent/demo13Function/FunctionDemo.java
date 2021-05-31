package com.concurrent.demo13Function;

import java.util.function.Function;

/**
 * Function 函数型接口, 有一个输入参数，有一个输出
 * 只要是 函数型接口 可以 用 lambda表达式简化
 * @author lane
 * @date 2021年05月26日 下午4:40
 */
public class FunctionDemo {

    public static void main(String[] args) {
        //匿名内部类实现
        Function<Integer,String> function = new Function<Integer,String> () {
            @Override
            public String apply(Integer i) {
                System.out.println("执行了apply方法"+i);
                return "re:"+i;
            }
        };

        //lambda实现
        Function<Integer,String> function2 = (integer)->{
            System.out.println("执行了apply方法"+integer);
            return "re"+integer;
        };
        function.apply(1024);
        System.out.println("===========================");
        function2.apply(2048);

    }



}
