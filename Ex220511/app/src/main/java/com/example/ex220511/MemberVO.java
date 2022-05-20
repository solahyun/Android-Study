package com.example.ex220511;

import java.io.Serializable;
import java.util.Arrays;

public class MemberVO implements Serializable {

    private String name;
    private int age;
    private String[] hobby;

    @Override
    public String toString() {
        return "MemberVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }

    public MemberVO() {

    }

    public MemberVO(String name, int age, String[] hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
