package com.concurrent.demo15Lambda;

/**
 * @author lane
 * @date 2021年05月26日 下午11:20
 */
public interface TestLambda {

    public abstract void test(String aa);

    //public abstract void testTwo();

    default void testDefault(){
        System.out.println("接口中default的方法执行了");
    }

}
