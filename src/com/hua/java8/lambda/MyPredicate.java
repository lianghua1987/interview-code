/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

/**
 *
 * @author hliang
 */
@FunctionalInterface
public interface MyPredicate<T> {
    
    public boolean test(T t); 
    
     //public boolean test1(T t); 
}
