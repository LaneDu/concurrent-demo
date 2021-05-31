package com.concurrent.demo1;

/**
 * @author lane
 * @date 2021年05月25日 下午3:46
 */
public class Test {

    public static void main(String[] args) {
        // 获取cpu的核数
        // CPU 密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
