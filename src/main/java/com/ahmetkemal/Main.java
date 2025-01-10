package com.ahmetkemal;

public class Main {
    private static int a = 0;
    private static boolean b = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            Producer p1 = new Producer();
        }).start();

        new Thread(() -> {
            Consumer c1 = new Consumer();
        }).start();


    }
}