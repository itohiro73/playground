package jp.itohiro.playground.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * Created by hiroshi on 6/29/15.
 */
public class CompletableFutureExamples {
    public static void main(String[] args) {
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(CompletableFutureExamples::doSomeSlowWork);

        futureA.thenRun(CompletableFutureExamples::doAnotherSlowWork);

    }

    private static void doAnotherSlowWork() {
        //slow work here
    }

    private static void doSomeSlowWork() {
        //slow work here
    }
}
