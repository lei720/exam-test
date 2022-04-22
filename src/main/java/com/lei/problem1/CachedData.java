package com.lei.problem1;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CachedData {
    private static HashMap<String, Object> data = new HashMap<>();
    private volatile static boolean cacheValid = false;
    private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object processCachedData(String key) {
        rwl.readLock().lock();
        if (!cacheValid) {
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                if (!cacheValid) {
                    String dataString = "mydata";
                    System.out.println(Thread.currentThread().getName() + "-----get data from db, the dbdata is :" + dataString);
                    data.put(key, dataString);
                    cacheValid = true;
                  // return dataString;
                }
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock();
            }
        }
        try {
            return getCache(key);
        } finally {
            rwl.readLock().unlock();
        }
    }

    private Object getCache(String key) {
        Object result = data.get(key);
        System.out.println(Thread.currentThread().getName() + " get data from cache, the cache data is :" + result);
        return result;
    }
}