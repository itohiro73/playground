package jp.itohiro.playground.amqp;

import java.util.concurrent.CountDownLatch;

public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void process(String msg){
        System.out.println("Received: " + msg);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
