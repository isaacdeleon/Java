package org.own.practices;

public class PrincipalRunnable {

    public static void main (String[]args){

        RunnablePractices practices = new RunnablePractices();
        Thread hilo = new Thread(practices);
        hilo.start();
    }
}
