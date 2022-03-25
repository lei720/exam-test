package com.lei;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheValue {

    private static Map<String, Object> cacheData = new HashMap<>();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    private static  ReentrantReadWriteLock.WriteLock readLock = readWriteLock.writeLock();

    /**
     *缓存数据
     * @param key
     * @return
     */
     Object CacheValue(String key) {
         try {
             readLock.lock();
             Object result = cacheData.get(key);
             if (result != null) {
                 System.out.println(Thread.currentThread()+"----得到缓存数据: "+result);
                 return result;
             }

             try {
                 writeLock.lock();
                 String  value = "dbValues";
                 System.out.println(Thread.currentThread()+"----从数据库中查询得到数据"+value+"并存入缓存中");
                 cacheData.put(key, value);
                 return  value;
             }finally {
                 writeLock.unlock();
             }
         } finally {
             readLock.unlock();
         }


    }
}


