package com.concurrent.demo3;

/**
 * 线程A随机打印1～100数字
 * @author lane
 * @date 2021年05月21日 上午10:54
 */
public class ThreadA extends Thread {
    private boolean loop = true;
    @Override
    public void run() {

         while (loop){
             System.out.println((int) (Math.random()*100+1));
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
