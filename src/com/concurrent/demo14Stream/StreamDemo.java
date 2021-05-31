package com.concurrent.demo14Stream;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有5个用户！筛选：
 * 1、ID 必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户！
 * @author lane
 * @date 2021年05月26日 下午7:42
 */
public class StreamDemo {

    public static void main(String[] args) {
        User user1 = new User(1,"zhangsan",25);
        User user2 = new User(2,"lisi",27);
        User user3 = new User(3,"wangwu",26);
        User user11 = new User(4,"zhangsan",28);
        User user22 = new User(5,"lisi",15);
        User user33 = new User(6,"wangwu",23);
        List<User> userList = Arrays.asList(user1, user2, user3,user11,user22,user33);

        userList.stream()
                //参数为predicate<T>有1参数,返回布尔
                .filter((user)->{return user.getId()%2==0;})
                .filter((user)->{return user.getAge()>23;})
                //参数为function<T,R>有1参数和返回值
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((u1,u2)->{return u2.compareToIgnoreCase(u1);})
                .limit(2)
                //返回值是consumer<T>有1个参数,无返回值
                .forEach((user)->{
                    System.out.println(user);
                });

    }

}
