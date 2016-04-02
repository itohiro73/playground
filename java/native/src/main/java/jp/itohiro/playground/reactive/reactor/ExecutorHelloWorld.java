package jp.itohiro.playground.reactive.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by hiroshi on 6/26/15.
 */
public class ExecutorHelloWorld {
    private static ExecutorService executorService = Executors.newFixedThreadPool(8);
    public static void main(String[] args) throws Exception {
        List<String> batches = new ArrayList<>();

        Callable<String> callable = ()->{
            synchronized (batches){
                String result = callDatabase();
                batches.add(result);
                return result;
            }
        };

        Future<String> future = executorService.submit(callable);
        String result = future.get();
        System.out.println("Result is: " + result + ", batches have: " + batches.get(0));
    }

    private static String callDatabase() throws InterruptedException {
        Thread.sleep(100);
        return "Result";
    }
}
