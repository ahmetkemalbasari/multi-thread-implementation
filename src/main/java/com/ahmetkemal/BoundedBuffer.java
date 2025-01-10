package com.ahmetkemal;

import java.util.LinkedList;

public class BoundedBuffer {
    private static final int BUFFER_SIZE = 16;
    private static LinkedList<Integer> itemBuffer;
    private static int full = 0;
    private static int empty = BUFFER_SIZE;
    private static boolean mutex = false;

    public void waitMutex(){
        while(mutex){};
        mutex = true;
    }
    public void signalMutex(){
        mutex = false;
    }

    public void waitFull(){
        while(full == 0);
        full++;
    }
    public void signalFull(){
        full--;
    }

    public void waitEmpty(){
        while(empty == 0);
        empty--;
    }
    public void signalEmpty(){
        empty++;
    }

    public void addItem(Integer item){
        itemBuffer.addLast(item);
    }
    public Integer getItem(){
        return itemBuffer.removeFirst();
    }

}
