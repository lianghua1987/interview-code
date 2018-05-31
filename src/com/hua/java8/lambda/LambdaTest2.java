/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author hliang
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        int num = 0; //jdk1.7以前必须为final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Hua " + num);
            }
        };
        r.run();

        System.out.println("-----------------------------------------------");
        Runnable r1 = () -> System.out.println("Hello Hua " + num);

        //Runnable r1 = () -> System.out.println("Hello Hua " + num++); // final
        r1.run();
        System.out.println("-----------------------------------------------");

        Consumer<String> c = (x) -> System.out.println(x);
        c.accept("Hello Hua");

        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = (x, y) -> {
            return Integer.compare(x, y);
        };

        String[] strs = {"aaa", "bbb", "ccc"};
        Object[] objs = {"aaa", "bbb", "ccc", 1, true};

        map(new HashMap<>());
        
        System.out.println("-----------------------------------------------");
        System.out.println(operation(100, v ->  v * v + 50)); 

    }

    public static void map(Map<String, String> map) {

    }

    public static Integer operation(Integer value, MyFunc mf) {

        return mf.getValue(value);
    }

}
