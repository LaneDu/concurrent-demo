package com.concurrent.demo6;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lane
 * @date 2021年05月21日 下午5:50
 */
public class ListConcurrent {

    public static void main(String[] args) {
        //线程不安全的
//        List<String> list = new ArrayList<>();
        //线程安全的
//        List<String> list = new Vector<String>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list =new CopyOnWriteArrayList<>();
//        Queue<String> list =new ConcurrentLinkedDeque<String>();


        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                UUID uuid = UUID.randomUUID();
                String s = uuid.toString().substring(0,2);
                list.add((s) );
                System.out.println(list);
            }).start();
        }
    }



}
