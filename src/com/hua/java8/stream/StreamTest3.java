package com.hua.java8.stream;

import com.hua.java8.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest3 {

    List<Employee> employees = Arrays.asList(
            new Employee("王五", 23, 4332.2, Employee.Status.BUSY),
            new Employee("张三", 23, 3343.55, Employee.Status.VACATION),
            new Employee("李四", 34, 12345.23, Employee.Status.BUSY),
            new Employee("赵六", 43, 23534.55, Employee.Status.VACATION),
            new Employee("张三", 23, 3343.55, Employee.Status.VACATION),
            new Employee("田七", 13, 7545.12, Employee.Status.BUSY));


    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    /*Reduce*/
    @Test
    public void test2() {
        // 有初始值，所以返回double
        Double sum = employees.stream().map(Employee::getSalary).reduce(0d, (x, y) -> x + y);
        System.out.println(sum);

        // 无初始值，所以可能为null，返回optional
        Optional<Double> optionalADouble = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(optionalADouble.get());
    }

    /*Collect*/
    @Test
    public void test3() {
        employees.stream().collect(Collectors.toSet()).forEach(System.out::println);
    }

    @Test
    public void test4() {
        employees.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void test5() {
        employees.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
    }

    @Test
    public void test6() {
        System.out.println(employees.stream().collect(Collectors.counting()));
    }

    @Test
    public void test7() {
        System.out.println(employees.stream().collect(Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));
    }

    @Test
    public void test8() {
        Map<Employee.Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    @Test
    public void test9() {
        final Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println(map);
    }

    @Test
    public void test10() {
        String s = employees.stream().map(Employee::getName).distinct().collect(Collectors.joining(",", "$", "^"));
        System.out.println(s);
    }
}
