package com.lei.problem1;

import org.junit.Test;

public class CachedDataTest {
    @Test
    public void testCacheValue() throws InterruptedException {
        CachedData cacheValue = new CachedData();
        Thread thread = new Thread(() -> {
            while (true) {
                cacheValue.processCachedData("testValue");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (true) {
                cacheValue.processCachedData("testValue");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
         thread.start();
         thread1.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
