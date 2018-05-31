/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java.multithreading.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author hliang
 */
public class AtomicTest {
    
    private static AtomicInteger count = new AtomicInteger(0);
    
    public synchronized int multiAdd(){

        try{
            Thread.sleep(100);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + " is adding starts.");
        
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);
        System.out.println(Thread.currentThread().getName() + " is adding finishes.");
        return count.get();
    }
    
    public static void main(String[] args) {
        final AtomicTest a = new AtomicTest();
        List<Thread> ts = new ArrayList<>();
        for(int i = 0; i< 100; i ++){
            ts.add(new Thread(() ->  {
                System.out.println(Thread.currentThread().getName() + " " + a.multiAdd());
                    
          }));
        }
        
        ts.stream().forEach(t -> t.start());
    }
}
