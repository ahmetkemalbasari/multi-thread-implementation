package com.ahmetkemal;

import java.util.Random;

public class Producer extends BoundedBuffer {

    public Producer() {
        while(true) {
            Integer item = produceItem();

            waitEmpty();
            waitMutex();

            addItem(item);

            signalMutex();
            signalFull();
        }
    }

    private Integer produceItem(){
        Random random = new Random();
        return random.nextInt();
    }
}
