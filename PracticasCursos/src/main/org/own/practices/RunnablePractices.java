package org.own.practices;

public class RunnablePractices implements Runnable{

    @Override
    public void run() {

        int total = 0;
        for (int i=0; i<5;i++) {
            total +=i;
            try{
                Thread.sleep(300);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName());
        System.out.println(total);
    }
}
