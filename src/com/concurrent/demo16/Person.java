package com.concurrent.demo16;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author lane
 * @date 2021年05月27日 下午7:37
 */

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Integer birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 1024;
    }

    public Integer getBirthday() {

        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}

