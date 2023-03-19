package com.ll.basic1.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private int id;

    private String name;

    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
