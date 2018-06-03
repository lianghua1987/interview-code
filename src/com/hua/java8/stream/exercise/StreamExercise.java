package com.hua.java8.stream.exercise;

import com.hua.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamExercise {

    List<Employee> employees = Arrays.asList(
            new Employee("王五", 23, 4332.2),
            new Employee("张三", 23, 3343.55),
            new Employee("李四", 34, 12345.23),
            new Employee("赵六", 43, 23534.55),
            new Employee("田七", 13, 7545.12),
            new Employee("王五", 23, 4332.2),
            new Employee("赵六", 43, 23534.55),
            new Employee("王五", 23, 4332.2));

    /*数字列表，返回平方
     * 输入：【1，2，3，4，5】
     * 输出：【1，4，9，16，25】*/
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(e -> e * e).forEach(System.out::println);
    }

    /*map-reduce流中employee个数*/
    @Test
    public void test2() {
        System.out.println(employees.stream().map(e -> 1).reduce(Integer::sum).get());
    }
}
