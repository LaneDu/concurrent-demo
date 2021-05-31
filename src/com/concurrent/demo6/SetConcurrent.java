package com.concurrent.demo6;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lane
 * @date 2021年05月21日 下午5:50
 */
public class SetConcurrent {

    public SetConcurrent() {
    }

    public static void main(String[] args) {
        //不安全的
//        Set<String>  set = new HashSet<>();
        //安全的
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new  CopyOnWriteArraySet<>();




        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                UUID uuid = UUID.randomUUID();
                String s = uuid.toString().substring(0,2);
                set.add((s) );
                System.out.println(set);
            }).start();
        }
    }



}
