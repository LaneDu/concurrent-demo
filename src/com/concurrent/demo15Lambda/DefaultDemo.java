package com.concurrent.demo15Lambda;

import java.security.ProtectionDomain;

/**
 * @author lane
 * @date 2021年05月27日 上午1:04
 */
public class DefaultDemo {

    public static void main(String[] args) {
        TestLambda testLambda = (s)->{
            System.out.println("lambda执行接口test方法");
        };

        testLambda.test("helloworld");
        testLambda.testDefault();
    }

}
