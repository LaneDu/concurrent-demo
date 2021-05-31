package com.concurrent.demo5;

/**
 * @author lane
 * @date 2021年05月21日 下午2:28
 */
public class Business {

    private int number =0;

    public Business(int number) {
        this.number = number;
    }
    //1. 注意必须加sync才可以使用wait和notify
    //2. 不能使用if，if醒来之后不会判断，while会判断
    public synchronized void produce(){
        while (number!=0){

            System.out.println(Thread.currentThread().getName()+"number为"+number );
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        number++;
        notifyAll();

    }
    public synchronized void consume(){
        while (number==0){

            System.out.println(Thread.currentThread().getName()+"number为"+number );
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        notifyAll();

    }
}
