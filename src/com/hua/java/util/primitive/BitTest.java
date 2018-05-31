/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java.util.primitive;

/**
 *
 * @author hliang
 */
public class BitTest {

    //1111 1111 1111 1111 1111 1111 1111 1011 
    public static void main(String args[]) {
        System.out.println(5 >> 3);//结果是0  
        System.out.println(-5 >> 3);//结果是-1  
        System.out.println(-5 >>> 3);//结果是536870911 
    }
}
