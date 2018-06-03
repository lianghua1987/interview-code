package com.hua.java8.stream;

import com.hua.java8.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest2 {

    List<Employee> employees = Arrays.asList(
            new Employee("王五", 23, 4332.2, Employee.Status.BUSY),
            new Employee("张三", 23, 3343.55, Employee.Status.VACATION),
            new Employee("李四", 34, 12345.23, Employee.Status.BUSY),
            new Employee("赵六", 43, 23534.55, Employee.Status.VACATION),
            new Employee("田七", 13, 7545.12, Employee.Status.BUSY));


    @Test
    public void test1() {
        boolean b = employees.stream().allMatch(e -> e.getStatus() == Employee.Status.VACATION);
        System.out.println(b);

        b = employees.stream().anyMatch(e -> e.getStatus() == Employee.Status.VACATION);
        System.out.println(b);

        b = employees.stream().noneMatch(e -> e.getStatus() == Employee.Status.AVAILABLE);
        System.out.println(b);
    }

    @Test
    public void test2() {
        // 解决空指针异常
        Optional<Employee> optionalEmployee = employees.stream().sorted((e1, e2) -> Double.compare(e1.getAge(), e2.getAge())).findFirst();
        optionalEmployee.orElse(null); // ifNull
        System.out.println(optionalEmployee);

    }

    @Test
    public void test3() {
        Employee emp = employees.stream().filter(e -> e.getAge() == 23).findFirst().get();
        System.out.println(emp);
    }

    @Test
    public void test4() {
        Employee emp = employees.parallelStream().filter(e -> e.getAge() == 23).findAny().get();
        System.out.println(emp);
    }

    @Test
    public void test5() {
        System.out.println(employees.parallelStream().count());
        System.out.println(employees.parallelStream().max((e1, e2) -> e1.getAge() - e2.getAge()));
    }

    @Test
    public void test6() {
        System.out.println(employees.parallelStream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(employees.parallelStream().map(Employee::getSalary).min(Double::compareTo));

    }
}
