/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author hliang
 */
public class LambdaTest {

    public static void main(String args[]) {

        //匿名内部类
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }

        };
        Set<Integer> set = new TreeSet<>(comp);

        Comparator<Integer> comp1 = (Integer o1, Integer o2) -> Integer.compare(o1, o2);

        List<Employee> employees = Arrays.asList(new Employee("张三", 23, 3343.55),
                new Employee("李四", 34, 12345.23),
                new Employee("王五", 23, 4332.2),
                new Employee("赵六", 43, 23534.55),
                new Employee("田七", 13, 7545.12));

        // 优化模式1： 策略模式 strategy design pattern
        System.out.println("策略模式");
        List<Employee> emps = filterEmployee(employees, new FilterEmployeeByAge());
        emps.stream().forEach(System.out::println);

        //匿名内部类
        System.out.println("匿名内部类");
        List<Employee> emps1 = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getSalary() > 10000;
            }

        });
        emps1.stream().forEach(System.out::println);

        // lambda
        System.out.println("lambda");
        List<Employee> emps2 = filterEmployee(employees, e -> ((Employee) e).getSalary() > 20000);
        emps2.stream().forEach(System.out::println);

        System.out.println("lambda22");
        List<Employee> emps22 = filterEmployee1(employees, e -> ((Employee) e).getSalary() > 20000);
        emps22.stream().forEach(System.out::println);

        
        // 优化方式4
        System.out.println("stream");
        employees.stream().filter(e -> e.getSalary() > 1000).forEach(System.out::println);

        System.out.println("stream 3");
        employees.stream().filter(e -> e.getSalary() > 1000).limit(3).forEach(System.out::println);

        System.out.println("stream name only");
        employees.stream().map(Employee::getName).forEach(System.out::println);

    }

    public static List<Employee> filterEmployee(List<Employee> list, MyPredicate mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : list) {
            if (mp.test(e)) {
                emps.add(e);
            }
        }
        return emps;
    }

    public static List<Employee> filterEmployee1(List<Employee> list, MyPredicate mp) {

        return list.stream().filter(e -> mp.test(e) == true).collect(Collectors.toList());
    }

}
