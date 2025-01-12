package com.ahmetkemal;

import java.util.Random;

public class Producer {

    public Producer()  {
        while(true) {
            BoundedBuffer.waitEmpty();
            BoundedBuffer.waitMutex();

            Integer item = produceItem();
            BoundedBuffer.addItem(item);

            BoundedBuffer.signalMutex();
            BoundedBuffer.signalFull();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Integer produceItem(){
        Random random = new Random();
        return random.nextInt();
    }
}
