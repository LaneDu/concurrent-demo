package com.concurrent.demo16;

/**
 * @author lane
 * @date 2021年05月28日 上午11:42
 */
public class Human {
    Person person;

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }


}
