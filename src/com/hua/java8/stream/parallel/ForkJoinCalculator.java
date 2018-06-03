package com.hua.java8.stream.parallel;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculator extends RecursiveTask<Long> {


    private long start;

    private long end;

    private static final long THRESHOLD = 10000L;

    public ForkJoinCalculator(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            ForkJoinCalculator left = new ForkJoinCalculator(start, mid);
            left.fork();
            ForkJoinCalculator right = new ForkJoinCalculator(mid + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}
