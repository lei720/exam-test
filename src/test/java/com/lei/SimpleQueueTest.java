package com.lei;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    public static SimpleQueue simpleQueue;
   @Before
    public void beforeExecute() {
       simpleQueue = new SimpleQueue(3);
    }


    @Test
    public void pushTest() {
        Integer[] integers = {22, 33, 44};
        for (Integer integer : integers) {
            simpleQueue.push(integer);
        }
        Integer[] array = simpleQueue.getArray();
        assertArrayEquals(array, integers);


    }

    @Test
    public  void pollTest() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        Integer poll = simpleQueue.poll();
        Integer[] array = simpleQueue.getArray();
      assertTrue(poll==1);
    }

    @Test
    public void peekTest() {
        assertTrue(simpleQueue.peek() == null);
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        Integer peek = simpleQueue.peek();
     //   assertEquals(peek,1);
    }

    @Test
    public  void emptyTest() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        simpleQueue.empty();
        assertTrue(simpleQueue.getCurrentSize()==0);
    }
}