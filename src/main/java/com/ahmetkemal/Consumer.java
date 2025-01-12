package com.ahmetkemal;

public class Consumer {

    public Consumer() {
        while (true){
            BoundedBuffer.waitFull();
            BoundedBuffer.waitMutex();

            Integer item = BoundedBuffer.getItem();

            BoundedBuffer.signalMutex();
            BoundedBuffer.signalEmpty();

            System.out.println(item); //consume item
        }
    }
}
