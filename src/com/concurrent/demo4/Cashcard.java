package com.concurrent.demo4;

import java.util.Scanner;

/**
 * @author lane
 * @date 2021年05月21日 上午11:05
 */
public class Cashcard implements Runnable {
    private  final Object obj =new Object();
    private int cash = 10000;
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
         while (true){
             if (cash>0){
                 System.out.println(Thread.currentThread().getName()+"请输入取款金额");
             }else {
                 System.out.println(Thread.currentThread().getName()+"金额不足");
             }
             int i = scanner.nextInt();
             if (i>cash){
                 System.out.println("请输入一个小于"+cash+"的数字");
                 continue;
             }else {
                 cash = cash-i;
                 System.out.println("取款成功！"+"剩余金额"+cash);
                 break;
             }


         }



    }


}
