package com.lei;

import org.junit.Test;

import java.util.TimerTask;

public class CacheValueTest {
    @Test
    public void testCacheValue() throws InterruptedException {
        CacheValue cacheValue = new CacheValue();
        Thread thread = new Thread(() -> {
            while (true) {
                cacheValue.CacheValue("testValue");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (true) {
                cacheValue.CacheValue("testValue");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
         thread.start();
         thread1.start();
         Thread.sleep(5000);

    }
}
