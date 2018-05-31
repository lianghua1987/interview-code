/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * @author hliang
 */


public class LambdaTest5 {

    public static void main(String[] args) {

        Consumer<String> consumer = (x) -> System.out.println(x);
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("abcdefg");
        System.out.println("-----------------------------------------");

        Employee employee = new Employee();
        employee.setAge(10);
        employee.setName("Hua Liang");
        Supplier<Integer> sup = employee::getAge;
        System.out.println(sup.get());
        System.out.println("-----------------------------------------");

        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> comparator1 = Integer::compare;


        BiPredicate<String, String> biPredicate = (x,y) -> x.equals(y);
        BiPredicate<String, String> biPredicate1 = String::equals;

        System.out.println("-----------------------------------------");

        Supplier<Employee> supplier = () -> new Employee();
        sup.get();

        Supplier<Employee> supplier1 = Employee::new;

        Supplier<Employee> supplier2 = Employee::new;

        System.out.println("-----------------------------------------");
        Function<String, Employee> function = (x) -> new Employee(x);
        Function<String, Employee> function1 = Employee::new;
        Employee employee1 = function1.apply("Hua Liang");
        System.out.println(employee1);

        BiFunction<String, Integer, Employee> biFunction = Employee::new;
        Employee employee2 = biFunction.apply("Hua", 31);
        System.out.println(employee2);

        System.out.println("-----------------------------------------");

        Function<Integer, String[]> function2 = (x) -> new String[x];
        String[] strings = function2.apply(10);
        System.out.println(strings.length);

        Function<Integer, String[]> function3 = String[]::new;
        String[] strings1 =function3.apply(20);
        System.out.println(strings1.length);
    }


}
