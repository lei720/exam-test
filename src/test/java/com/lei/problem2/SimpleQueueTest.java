package com.lei.problem2;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

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
            simpleQueue.pushData(integer);
        }
        Integer[] array = simpleQueue.getArrayData();
        assertArrayEquals(array, integers);


    }

    @Test
    public  void pollTest() {
        simpleQueue.pushData(1);
        simpleQueue.pushData(2);
        simpleQueue.pushData(3);

        Integer poll = simpleQueue.pollData();
        Integer[] array = simpleQueue.getArrayData();
      assertTrue(poll==1);
    }

    @Test
    public void peekTest() {
        assertTrue(simpleQueue.peekData() == null);
        simpleQueue.pushData(1);
        simpleQueue.pushData(2);
        simpleQueue.pushData(3);

        Integer peek = simpleQueue.peekData();
     //   assertEquals(peekData,1);
    }

    @Test
    public  void emptyTest() {
        simpleQueue.pushData(1);
        simpleQueue.pushData(2);
        simpleQueue.pushData(3);

        simpleQueue.emptyData();
        assertTrue(simpleQueue.getCurrentSize()==0);
    }
}