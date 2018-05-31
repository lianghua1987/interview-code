/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author hliang
 */


public class LambdaTest4 {
    
    public static void main(String[] args) {
        
        // 消费型
        happy(10000, (m) -> System.out.println(m));
        
        System.out.println("-----------------------------------------");
        
        // 供给型
        List list = getNums(10, () -> (int)(Math.random() * 100));
        list.stream().map(t -> t + " ").forEach(System.out::print);
        
        System.out.println("\n-----------------------------------------");
        
        // 函数型
        System.out.println(handler("hua liang", (x) -> x.length()));
        
        System.out.println("-----------------------------------------");

        
        System.out.println(isSubString("iaa", (x) -> "Hua Liang".contains(x)));
    }
    
    
    public static void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    
    
    public static List<Integer> getNums(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
       for(int i = 0; i< num; i++){
           list.add(sup.get());
       }
       return list;
    }
    
    
    public static Integer handler(String str, Function<String, Integer> func){
        return func.apply(str);
    }
    
    public static boolean isSubString(CharSequence cs, Predicate<CharSequence> pred){
        return pred.test(cs);
    }
    
}
