package org.own.practices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrincipalCallable {

    public static void main(String[]args){

        MyCallable callable1 = new MyCallable(5000);
        MyCallable callable2 = new MyCallable(10000);



        try{
            ExecutorService executor = Executors.newFixedThreadPool(2);
            Future<String> resultadoFuture1 = executor.submit(callable1);
            Future<String> resultadoFuture2 = executor.submit(callable2);

            System.out.println("Do something else while callable is getting executed ");

            System.out.println("Retrieve the result of the future");
            // Future.get() blocks until the result is available
            String result = resultadoFuture1.get();
            String result2 = resultadoFuture2.get();

            System.out.println(result);
            System.out.println(result2);

            executor.shutdown();

        }catch(InterruptedException ie){
            ie.printStackTrace();
        }catch(ExecutionException ee){
            ee.printStackTrace();
        }
    }
}
