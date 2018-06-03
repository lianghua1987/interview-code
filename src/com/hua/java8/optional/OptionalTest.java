package com.hua.java8.optional;

import com.hua.java8.lambda.Employee;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalTest {

    /*- Optional.of(T t);
    - Optional.empty();
    - Optional.ofNullable(T t): 若t不为null，创建Optional实例，否则创建空实例
    - isPresent();
    - orElse(T t);
    - orElseGet(Supplier s)
    - map(Function f);
    - flatMap(Function mapper)
    */

    @Test
    public void test1() {
        Optional<Employee> optionalEmployee = Optional.of(new Employee());
        Employee employee = optionalEmployee.get();
        System.out.println(employee);
    }

    @Test
    public void test2() {
        Optional<Employee> optionalEmployee = Optional.of(null);// null pointer exception as earlier as possible
        Employee employee = optionalEmployee.get();
        System.out.println(employee);
    }

    @Test
    public void test3() {
        Optional<Employee> optionalEmployee = Optional.empty();
        System.out.println(optionalEmployee.get());// null pointer exception
    }

    @Test
    public void test4() {
        Optional<Employee> optionalEmployee = Optional.ofNullable(new Employee("Hua Liang"));
        System.out.println(optionalEmployee.get());// null pointer exception

        optionalEmployee = Optional.ofNullable(null);
        System.out.println(optionalEmployee.get());// null pointer exception
    }

    @Test
    public void test5() {
        Optional<Employee> optionalEmployee = Optional.ofNullable(null);
        if (optionalEmployee.isPresent()) {
            System.out.println(optionalEmployee.get());
        } else {
            System.out.println("optionalEmployee.isPresent() == false");
        }
        Employee employee = optionalEmployee.orElse(new Employee("OR_ELSE"));
        System.out.println(employee);

        System.out.println("------------------------------------------");

        optionalEmployee = Optional.ofNullable(new Employee("Hua Liang"));
        if (optionalEmployee.isPresent()) {
            System.out.println(optionalEmployee.get());
        } else {
            System.out.println("optionalEmployee.isPresent() == false");
        }
    }


    @Test
    public void test6() {
        Man man = new Man();
        String name = getLadyName1(man); // NPE
    }

    @Test
    public void test7() {
        Man man = new Man();
        String name = getLadyName(man); // NPE
    }

    @Test
    public void test8() {
        Optional<NewMan> op = Optional.ofNullable(null);
        String name = getLadyName2(op); // NPE
        System.out.println(name);
    }

    @Test
    public void test9() {
        Optional<Lady> optionalLady = Optional.ofNullable(new Lady("Hot Girls"));
        Optional<NewMan> op = Optional.ofNullable(new NewMan(optionalLady));
        String name = getLadyName2(op); // NPE
        System.out.println(name);
    }

    public String getLadyName1(Man man) {
        return man.getLady().getName();
    }

    public String getLadyName(Man man) {
        if (man != null && man.getLady() != null)
            return man.getLady().getName();

        return null;
    }

    public String getLadyName2(Optional<NewMan> man) {
        return man.orElse(new NewMan()).getLady().orElse(new Lady("Peiceng Hou")).getName();
    }
}
