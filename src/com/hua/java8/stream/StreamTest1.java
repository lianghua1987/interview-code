package com.hua.java8.stream;

import com.hua.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    List<Employee> employees = Arrays.asList(
            new Employee("王五", 23, 4332.2),
            new Employee("张三", 23, 3343.55),
            new Employee("李四", 34, 12345.23),
            new Employee("赵六", 43, 23534.55),
            new Employee("田七", 13, 7545.12),
            new Employee("王五", 23, 4332.2),
            new Employee("赵六", 43, 23534.55),
            new Employee("王五", 23, 4332.2));


    /*
     * 1. filter
     * 2. limit
     * 3. skip(n)
     * 4. distinct
     * */
    @Test
    public void test1() {
        employees.stream().filter(e -> e.getAge() > 25).forEach(System.out::println);
    }

    @Test
    public void test2() {
        //短路
        employees.stream().filter(e -> {
            System.out.println("短路");
            return e.getAge() > 0;
        }).limit(2).forEach(System.out::println);
    }

    @Test
    public void test3() {

        employees.stream().filter(e -> e.getAge() > 0)
                .skip(2).forEach(System.out::println);
    }


    @Test
    public void test4() {
        employees.stream().filter(e -> e.getAge() > 0)
                .distinct().forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        employees.stream().map(Employee::getName).forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");

        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::filter);

        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");

        Stream<Character> s = list.stream().flatMap(StreamTest1::filter);

        s.forEach(System.out::println);

    }


    public static Stream<Character> filter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }


    @Test
    public void test8() {
        List<String> list = Arrays.asList("eee", "fff", "aaa", "ggg", "ccc", "999");

        list.stream().sorted().forEach(System.out::println);

    }

    @Test
    public void test9() {
        List<String> list = Arrays.asList("eee", "fff", "aaa", "ggg", "ccc", "999");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    @Test
    public void test10() {
        employees.stream().sorted((e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getSalary().compareTo(e2.getSalary());
            } else{
                return e1.getAge() - e2.getAge();
            }
        }).forEach(System.out::println);
    }

}
