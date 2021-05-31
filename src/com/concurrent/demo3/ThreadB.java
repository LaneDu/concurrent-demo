package com.concurrent.demo3;

import java.util.Scanner;

/**
 * @author lane
 * @date 2021年05月21日 上午10:56
 */
public class ThreadB extends Thread {
    private ThreadA threadA;
    private Scanner scanner = new Scanner(System.in);


    public ThreadB(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("请输入你的指令，q代表退出A");
            String next = scanner.next();
            if (next.equals("q")){
                threadA.setLoop(false);
                break;
            }
        }

    }
}
