package com.hua.java8.stream;

import com.hua.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    /*
     * 1. create stream
     * 2. operation
     * 3. end
     */

    @Test
    public void test1() {
        // 通过Collection提供的stream() 或者 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();


        // 通过Arrays中的静态方法stream获取数组
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 通过stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 创建无限流 - 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }
}
