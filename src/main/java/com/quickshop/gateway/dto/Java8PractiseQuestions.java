package com.quickshop.dto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8PractiseQuestions {



//    Find Duplicate Elements


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,2,5,1);

        findSuplicates(list);

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", "IT",20000L),
                new Employee("Anishka", "HR",20000L),
                new Employee("Amit", "IT",50000L),
                new Employee("Sneha", "Finance",30000L),
                new Employee("Ravi", "HR",10000L));

        groupByDept(employees);

//        3. Find First Non-Repeated Character
        String str = "aabbcde";

      char chr=  str.chars().mapToObj((ch->(char)ch)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e-> e.getValue()==1).map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println(chr);

        List<Integer> nums =
                Arrays.asList(10,20,50,40,30);

//        4. Find Second Highest Number
        System.out.println(nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


//        5. Find Longest String

        List<String> names =
                Arrays.asList("Java","Microservices","Spring");

        System.out.println("Find Longest String - "  +names.stream().max(Comparator.comparingInt(String::length)));

//        11. Find Highest Salary Employee Per Department


        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))))
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue().orElseGet(null)));




    }

    private static void groupByDept(List<Employee> employees) {

        Map<String, List<String>> deptEmployees = employees.stream().
                collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.mapping(Employee::getName,Collectors.toList())
                        ));


//        deptEmployees.entrySet().stream().forEach(entry ->
//                System.out.println(entry.getKey() +"->" +entry.getValue()));


        deptEmployees.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(name -> entry.getKey() + "->[" + name + "]"))
                .forEach(System.out::println);


    }

    private static void findSuplicates(List<Integer> list) {

        list.stream().filter(n-> Collections.frequency(list,n)>1).collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
