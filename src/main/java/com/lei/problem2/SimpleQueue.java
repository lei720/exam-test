package com.lei.problem2;

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
//including push, pop, peekData, emptyData methods.
    public void pushData(Integer num) {
        if (currentSize == queueArr.length) {
            throw new RuntimeException("队列已经满了");
        }
        queueArr[last] = num;
        currentSize++;
        if (last == queueArr.length - 1) {
            last = 0;
        } else {
            last++;
        }
    }

    public Integer pollData() {
        if (currentSize == 0) {
            throw new RuntimeException("队列不能为空");
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

    public Integer peekData(){
        if (currentSize == 0){
            return null;
        }
        return queueArr[first];
    }

    public void emptyData(){
        queueArr = new Integer[queueArr.length];
        currentSize = 0;
        first = 0;
        last = 0;
    }


    public Integer[] getArrayData() {
        return queueArr;
    }


    public Integer getCurrentSize() {
        return currentSize;
    }


}
