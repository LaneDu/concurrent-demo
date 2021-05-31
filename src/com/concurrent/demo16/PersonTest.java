package com.concurrent.demo16;

import java.util.*;

/**
 * @author lane
 * @date 2021年05月27日 下午7:03
 */
public class PersonTest {

    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        List<Person> list = new ArrayList<>();
        p1.setBirthday(20);p2.setBirthday(12);p3.setBirthday(22);
        list.add(p1);
        list.add(p2);
        list.add(p3);


        Person[] rosterAsArray = list.toArray(new Person[list.size()]);


        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        //工具类排序方法
//        static <T> void sort(T[] a, Comparator<? super T> c)


        //方式一：创建类重写接口
        Arrays.sort(rosterAsArray, new PersonAgeComparator());
        //方式二：lambda
        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );
        //方式三：最简化版lambda，参数类型可以省区，只有一行的时候可以省略掉 return 和 {}
        Arrays.sort(rosterAsArray, (a,b) -> a.getBirthday().compareTo(b.getBirthday()));

        //方式四：
        Arrays.sort(rosterAsArray,  (a, b) -> Person.compareByAge(a, b));
        //可以是随便一个类的类似方法，只要推断没错
        Arrays.sort(rosterAsArray,  (a, b) -> Human.compareByAge(a, b));
        //方式五：::表达式版 你是不是一脸懵逼（其实就是推断出来的）
        Arrays.sort(rosterAsArray, Person::compareByAge);
        Arrays.sort(rosterAsArray,Human::compareByAge);
        for (int i = 0; i <rosterAsArray.length ; i++) {
            System.out.println(rosterAsArray[i]);
        }
       // Arrays.stream(rosterAsArray).forEach((ro)->System.out.println(ro));
       //  Arrays.stream(rosterAsArray).forEach(System.out::println);

    }
}

