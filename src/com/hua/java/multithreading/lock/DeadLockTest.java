/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java.multithreading.lock;
/**
 *
 * @author hliang
 */
public class DeadLockTest {

    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a) {
                    System.out.println(Thread.currentThread().getName() + " get resource a");
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_b) {
                            System.out.println(Thread.currentThread().getName() + " get resource b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b) {
                    System.out.println(Thread.currentThread().getName() + " get resource b");
                    synchronized (resource_a) {
                        System.out.println(Thread.currentThread().getName() + " get resource a");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

    }
}
