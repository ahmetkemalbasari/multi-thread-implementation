package com.ahmetkemal;

public class BoundedBuffer {
    private static final int BUFFER_SIZE = 16;
    private static Object[] itemBuffer;
    private static int full = 0;
    private static int empty = BUFFER_SIZE;
    private static boolean mutex = false;

    public static void waitMutex(){
        while(mutex){};
        mutex = true;
    }
    public static void signalMutex(){
        mutex = false;
    }

    public static void waitFull(){
        while(full == 0);
        full++;
    }
    public static void signalFull(){
        full--;
    }

    public static void waitEmpty(){
        while(empty == 0);
        empty--;
    }
    public static void signalEmpty(){
        empty++;
    }

}
