package com.concurrent.demo2;

/**
 * @author lane
 * @date 2021年05月20日 下午6:34
 */
public class SuperSale {

    public static void main(String[] args) {
        //runnable
        SaleWindow windowOne = new SaleWindow();

        Thread thread1 = new Thread(windowOne);
        Thread thread2 = new Thread(windowOne);
        Thread thread3 = new Thread(windowOne);

       /* thread1.start();
        thread2.start();
        thread3.start();*/
        //thread
        new SaleWindowThread().start();
        new SaleWindowThread().start();
        new SaleWindowThread().start();


    }



}
