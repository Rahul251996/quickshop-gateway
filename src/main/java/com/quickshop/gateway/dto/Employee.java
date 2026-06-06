package com.quickshop.dto;

import lombok.*;


@ToString
@Getter
@Setter
public class Employee {

    long id;
    String name;
    String dept;

    Long salary;

    public Employee(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

