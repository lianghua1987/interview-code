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
public class FilterEmployeeByAge implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee e) {
        return e.getAge() > 25;
    }
    
}
