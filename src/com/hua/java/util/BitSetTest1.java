/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java.util;

import java.util.BitSet;

/**
 *
 * @author hliang
 */
public class BitSetTest1 {

    public static void main(String args[]) {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);

        String url = "http://baidu.com/c";
        System.out.println(url.hashCode());
        int hashcode = url.hashCode() & 0x7FFFFFFF;
        System.out.println(hashcode);
        bitSet.set(hashcode);
        bitSet.set(2);
        System.out.println(bitSet.cardinality());
        System.out.println(bitSet.get(hashcode));
        bitSet.clear(hashcode);
    }
}
