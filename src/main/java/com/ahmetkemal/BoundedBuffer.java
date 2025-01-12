package com.ahmetkemal;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private static final int BUFFER_SIZE = 16;
    private static LinkedList<Integer> itemBuffer = new LinkedList<>();
    private static Semaphore full = new Semaphore(0);
    private static Semaphore empty = new Semaphore(BUFFER_SIZE);
    private static ReentrantLock mutex = new ReentrantLock();

    public static void waitMutex() {
        mutex.lock();
    }
    public static void signalMutex(){
        mutex.unlock();
    }

    public static void waitFull() {
        try {
            full.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void signalFull(){
        full.release();
    }

    public static void waitEmpty() {
        try {
            empty.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void signalEmpty(){
        empty.release();
    }

    public static void addItem(Integer item){
        itemBuffer.add(item);
    }
    public static Integer getItem(){
        return itemBuffer.removeFirst();
    }

    public static int getBufferSize(){
        return BUFFER_SIZE;
    }

}
