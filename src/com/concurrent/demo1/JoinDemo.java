package com.concurrent.demo1;

/**
 * @author lane
 * @date 2021年05月19日 下午4:11
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {


     Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行");
            }
        };
        myThread.start();
        myThread.join();

        System.out.println("main线程执行结束");


    }
}
