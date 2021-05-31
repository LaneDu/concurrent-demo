package com.concurrent.demo13Function;

import java.util.function.Consumer;

/**
 * 消费型接口只有输入没有返回值
 * @author lane
 * @date 2021年05月26日 下午7:17
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> consumer = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println("内部类执行了accept方法"+s);
            }

            @Override
            public Consumer<String> andThen(Consumer<? super String> after) {
                return null;
            }
        };
        consumer.accept("1024");

        Consumer<String> consumer1 = (s->{
            System.out.println("lambda执行了consumer方法"+s);
        });

        consumer1.accept("1024");


    }


}
