package org.own.practices;

import java.util.concurrent.*;

public class CallableLambdas {

    public static void main(String[]args) throws InterruptedException,ExecutionException{

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}
