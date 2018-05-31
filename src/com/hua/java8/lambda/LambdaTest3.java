/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hliang
 */
public class LambdaTest3 {

            
    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 5343.55),
            new Employee("李四", 34, 12345.23),
            new Employee("王五", 23, 4332.2),
            new Employee("赵六", 43, 23534.55),
            new Employee("田七", 13, 7545.12));

    public static void main(String[] args) {
        Collections.sort(employees, (e1, e2) -> {
            return e1.getAge() - e2.getAge();

        });

        employees.stream().forEach(System.out::println);
        
        
        System.out.println("-----------------------------------------------");
        
        
        System.out.println(operation("abcasq3wrtdffas", t -> t.toUpperCase()));
        
        System.out.println("-----------------------------------------------");
        
        operation1(10L, 100L, (x, y) -> Long.toString(x * y) + "a");
        
    }

    public static String operation(String str, MyFunc1 mf){
        return mf.getValue(str);
    }
    
     public static void operation1(Long l1, Long l2, MyFunc2<Long, String> mf){
         System.out.println(mf.getValue(l1, l2));
    }
}
