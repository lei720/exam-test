package com.lei;

public class SimpleQueue {

    private Integer[] queueArr;
    private Integer currentSize;
    private Integer first;
    private Integer last;

    public SimpleQueue() {
    }

    public SimpleQueue(Integer size){
        if (size < 0){
            throw new RuntimeException("队列小于0");
        }
        queueArr = new Integer[size];
        currentSize = 0;
        first = 0;
        last = 0;
    }

    public void push(Integer num) {
        if (currentSize == queueArr.length) {
            throw new RuntimeException("队列已满");
        }
        queueArr[last] = num;
        currentSize++;
        if (last == queueArr.length - 1) {
            last = 0;
        } else {
            last++;
        }
    }

    public Integer poll() {
        if (currentSize == 0) {
            throw new RuntimeException("队列为空");
        }
        int tempIndex = first;
       currentSize--;
        if (first == queueArr.length - 1) {
            first = 0;
        } else {
            first++;
        }
        return queueArr[tempIndex];
    }

    public Integer peek(){
        if (currentSize == 0){
            return null;
        }
        return queueArr[first];
    }

    public void empty(){
        queueArr = new Integer[queueArr.length];
        currentSize = 0;
        first = 0;
        last = 0;
    }


    public Integer[] getArray() {
        return queueArr;
    }


    public Integer getCurrentSize() {
        return currentSize;
    }


}
