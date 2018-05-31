package com.hua.java.collection.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingQueueTest {

    public static class Basket {

        BlockingQueue<String> basket = new ArrayBlockingQueue<>(10);
       

        public void produce() throws InterruptedException {
            basket.put("An apple");
        }

        public String consume() throws InterruptedException {
            String apple = basket.take();
            return apple;
        }

        public int getAppleNumber() {
            return basket.size();
        }

    }

    public static void main(String[] args) {
        final Basket basket = new Basket();
        class Producer implements Runnable {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("生产者准备生产苹果："
                                + System.currentTimeMillis());
                        basket.produce();
                        System.out.println("生产者生产苹果完毕："
                                + System.currentTimeMillis());
                        System.out.println("生产完后有苹果：" + basket.getAppleNumber() + "个");
                        Thread.sleep(1500);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }

        class Consumer implements Runnable {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("消费者准备消费苹果："
                                + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("消费者消费苹果完毕："
                                + System.currentTimeMillis());
                        System.out.println("消费完后有苹果：" + basket.getAppleNumber() + "个");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(new Producer());
        service.submit(new Consumer());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        service.shutdownNow();
    }
}
