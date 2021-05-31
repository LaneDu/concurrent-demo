package com.concurrent.demo3;

/**
 * @author lane
 * @date 2021年05月21日 上午10:53
 */
public class Control {

    public static void main(String[] args) {
        ThreadA threadA =new ThreadA();
        ThreadB threadB = new ThreadB(threadA);
        threadA.start();
        threadB.start();
    }

}
