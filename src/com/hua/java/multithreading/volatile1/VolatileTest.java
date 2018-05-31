/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hua.java.multithreading.volatile1;

/**
 *
 * @author hliang
 */
public class VolatileTest extends Thread{
    
    //private volatile boolean isRunning = true;
    
    private boolean isRunning = true;
    
    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    
    @Override
    public void run(){
        System.out.println("进入run方法");
        while(isRunning){
            System.out.println(isRunning);
                    
        }
        System.out.println("线程终止");
    }
    
    public static void main(String[] args) throws InterruptedException {
        VolatileTest v = new VolatileTest();
        v.start();
        
        Thread.sleep(1000);
        v.setRunning(false);
        System.out.println("isRunning被修改为false");
        Thread.sleep(1000);
        System.out.println(v.isRunning);
        
    }
    
    
}
