package com.concurrent.demo10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列四组API
 * 满添加会阻塞
 * 空移除会阻塞
 * @author lane
 * @date 2021年05月26日 上午11:52
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
       /* 测试第一组异常添加删除
        true
        true
        true
        Exception in thread "main" java.lang.IllegalStateException: Queue full
        ======================
        队首元素为：a
        ======================
        a
        b
        c
        Exception in thread "main" java.util.NoSuchElementException*/
//      testAddRemove();

        //    测试第二组不会抛异常，返回false
     /* true
        true
        true
        false
        ======================
        队首元素为：a
        ======================
        a
        b
        c
        null*/
//    testOfferPoll();
      /*  第三组测试put和take会阻塞
        ======================
        队首元素为：a
        ======================
        a
        b
        c
        阻塞。。。*/
//        testPutTake();


        /*第四组超时阻塞
        true
        true
        true
        false
        阻塞2s
        ======================
        队首元素为：a
        ======================
        a
        b
        c
        null
        阻塞2s*/
        testOfferPollTime();




    }

     /**
      * 测试add、remove阻塞时候会抛出异常
      * @author lane
      * @date 2021/5/26 上午11:54
      */
    public static void testAddRemove(){
        //指定队列长度和类型
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
    //    System.out.println(blockingQueue.add("d"));
        System.out.println("======================");
        System.out.println("队首元素为："+blockingQueue.element());
        System.out.println("======================");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());


    }
    /**
     * offer和poll队列满或空的时候不会抛出异常
     * @author lane
     * @date 2021/5/26 下午12:11
     */
    public static void testOfferPoll(){
        //指定队列长度和类型
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));
        System.out.println("======================");
        System.out.println("队首元素为："+blockingQueue.peek());
        System.out.println("======================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());


    }

    /**
     * put和take满空的时候会阻塞
     * @author lane
     * @date 2021/5/26 下午12:12
     */
    public static void testPutTake() throws InterruptedException {

        //指定队列长度和类型
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        //无返回值
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
       // blockingQueue.put("d");
        System.out.println("======================");
        System.out.println("队首元素为："+blockingQueue.peek());
        System.out.println("======================");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());


    }

    /**
     * offert和poll满空的时候会阻塞指定阻塞时间
     * @author lane
     * @date 2021/5/26 下午12:12
     */
    public static void testOfferPollTime() throws InterruptedException {

        //指定队列长度和类型
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));
        System.out.println("阻塞2s");
        System.out.println("======================");
        System.out.println("队首元素为："+blockingQueue.peek());
        System.out.println("======================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println("阻塞2s");

    }




}
