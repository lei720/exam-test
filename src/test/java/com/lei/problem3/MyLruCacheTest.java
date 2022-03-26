package com.lei.problem3;

import com.lei.problem3.MyLruCache;
import org.junit.Test;

public class MyLruCacheTest {
    @Test
    public void testMyLruCache() {
        MyLruCache myLruCache = new MyLruCache(2);

        myLruCache.put(1, 1);
        myLruCache.put(2, 2);
        //// 返回 1
        System.out.println(myLruCache.get(1));;
        //key 2 被剔除
        myLruCache.put(3, 3);
        //验证key 2不存在了
        System.out.println( myLruCache.get(2));
        //LRU key 1 被剔除了
        myLruCache.put(4, 4);
        //返回 -1 key 为 1被剔除了
        System.out.println( myLruCache.get(1));;
        //key 3 任然存在
        System.out.println(myLruCache.get(3));;
        //key 4 任然存在
        System.out.println( myLruCache.get(4));;
    }
}
