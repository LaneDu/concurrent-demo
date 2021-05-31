package com.concurrent.demo6;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lane
 * @date 2021年05月22日 上午11:19
 */
public class MapConcurrent {

    public static void main(String[] args) {
        //不安全的
//        Map<String,Object> map = new HashMap<>();
        //安全的
        Map<String,Object> map = new ConcurrentHashMap<>();



        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(1,3));
                System.out.println(map);

            }).start();
        }


    }
}


