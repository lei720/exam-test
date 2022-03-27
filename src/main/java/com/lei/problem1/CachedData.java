package com.lei.problem1;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CachedData {
    private static HashMap<String, Object> data = new HashMap<>();
    private volatile static boolean cacheValid = false;
    private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object processCachedData(String key) {
        rwl.readLock().lock();
        try {
            Object value = data.get(key);
            if (value!=null) {
                System.out.println(Thread.currentThread().getName()+"获取的缓存不为空");
                //  cacheValid=true;
                return  value;
            }

            rwl.readLock().unlock();
            //升级写锁，此时需要重新判断value值
            rwl.writeLock().lock();
            try {
                Object value2 = data.get(key);
                if (value2!=null) {
                    //  cacheValid=true;
                    return  value2;
                }
                String dataString = "mydata";
                System.out.println(Thread.currentThread().getName() + "-----get data from db, the dbdata is :" + dataString);
                data.put(key, dataString);
                return dataString;

            } finally {
                rwl.writeLock().unlock();
            }
        }finally {

            if (rwl.getReadHoldCount()>0) {
                rwl.readLock().unlock();
            }
        }



    }

    private Object getCache(String key) {
        Object result = data.get(key);
        System.out.println(Thread.currentThread().getName() + " get data from cache, the cache data is :" + result);
        return result;
    }
}