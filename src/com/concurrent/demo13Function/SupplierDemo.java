package com.concurrent.demo13Function;

import java.util.function.Supplier;

/**
 * Supplier 供给型接口 没有参数，只有返回值
 * @author lane
 * @date 2021年05月26日 下午7:26
 */
public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>(){
            @Override
            public String get() {
                System.out.println("匿名内部类执行get方法");
                return "1024";
            }
        };
    supplier.get();
        Supplier<String> supplier1 =()->{
            System.out.println("lambda执行get方法");
            return "1024";
        };

        supplier1.get();

    }
}
