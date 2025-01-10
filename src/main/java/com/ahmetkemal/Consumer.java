package com.ahmetkemal;

public class Consumer extends BoundedBuffer {

    public Consumer() {
        while (true){
            waitFull();
            waitMutex();

            Integer item = getItem();

            signalMutex();
            signalEmpty();

            System.out.println(item); //consume item
        }
    }
}
