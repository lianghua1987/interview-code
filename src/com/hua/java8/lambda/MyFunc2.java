/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java8.lambda;

/**
 *
 * @author hliang
 *
 */
@FunctionalInterface
public interface MyFunc2<T, R> {

    public R getValue(T t1, T t2);
}
