package com.concurrent.demo20Single;

/**
 * 静态内部类创建单例模式
 * @author lane
 * @date 2021年05月30日 上午12:02
 */
public class InnerDemo {

    private InnerDemo(){
        System.out.println(Thread.currentThread().getName()+"单例创建");
    }
    public static InnerDemo getInstance(){
        return InnerClass.innerDemo;
    }
    private static class InnerClass {
        private static final InnerDemo innerDemo = new InnerDemo();

    }

    public static void main(String[] args) {
        //测试下线程是否安全的
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                InnerDemo innerDemo = InnerDemo.getInstance();
            }).start();
        }

        InnerDemo innerDemo1 = InnerDemo.getInstance();
        InnerDemo innerDemo2 = InnerDemo.getInstance();
        System.out.println(innerDemo1 == innerDemo2);
    }





}
