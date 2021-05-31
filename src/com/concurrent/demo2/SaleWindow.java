package com.concurrent.demo2;

/**
 * @author lane
 * @date 2021年05月20日 下午6:34
 */
public class SaleWindow implements Runnable {
    private int count =100;
    private boolean loop = true;
    private Object object = new Object();
    @Override
    public void run() {
        while(loop) {

            saleTickets();
        }

    }
    public /*synchronized*/   void saleTickets(){
        synchronized (object) {
            if (count <= 0) {

                System.out.println("售票结束");
                loop = false;
                return;
            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // System.out.println(Thread.currentThread().getName()+"卖出一张张票");
            System.out.println(Thread.currentThread().getName() + "卖出第" + count + "张票");
            count = count - 1;
            System.out.println("剩余票数为" + count);

        }

    }


}
