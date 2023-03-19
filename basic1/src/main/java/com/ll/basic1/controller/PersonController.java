package com.ll.basic1.controller;

import com.ll.basic1.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class PersonController {
    private final List<Person> personList = new ArrayList<>();
    private int n;

    public PersonController() {
        n = 1;
    }

    @GetMapping("/addPerson")
    public String addPerson(@RequestParam String name, @RequestParam int age) {
        Person person = new Person(n, name, age);
        personList.add(person);
        return n++ + "번 사람이 추가되었습니다.";
    }

    @GetMapping("/people")
    public List<Person> people() {
        return personList;
    }

    @GetMapping("/removePerson")
    public void remove(@RequestParam int id) {
        personList.removeIf(person -> person.getId() == id);
    }

    @GetMapping("/updatePerson")
    public void update(@RequestParam String name, int age) {

    }


}
