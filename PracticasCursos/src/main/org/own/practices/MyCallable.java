package org.own.practices;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

    private long waitTime;

    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }

    @Override
    public String call() throws Exception {

        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("wait time " + waitTime);
        return Thread.currentThread().getName();

    }
}
