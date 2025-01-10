package com.ahmetkemal;

public class Main {
    private static int a = 0;
    private static boolean b = false;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(a);
            b = true;
        }).start();

    }
}