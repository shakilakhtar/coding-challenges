package com.challenge.leetcode.systemdesign.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterApplication {
    public static void main(String[] args) {
        BucketCreator bc = new BucketCreator(1);
        ExecutorService executorService= Executors.newFixedThreadPool(12);
        for (int i =0; i < 12; i++){
            executorService.execute(()->bc.accessApplication(1));
        }
        executorService.shutdown();
    }
}
