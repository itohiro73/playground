package jp.itohiro.playground.reactive.reactor;

import reactor.Environment;
import reactor.rx.broadcast.Broadcaster;

/**
 * Created by hiroshi on 6/25/15.
 */
public class ReactorHelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Environment.initialize();

        Broadcaster<String> sink = Broadcaster.create(Environment.get());

        sink.dispatchOn(Environment.cachedDispatcher())
                .map(String::toUpperCase)
                .consume(s -> System.out.printf("s=%s\n", s));
        sink.onNext("Hello World!");

        Thread.sleep(500);
    }
}
