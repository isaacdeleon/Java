package com.udemy.practices;

public interface InterfaceA {

    public void saySomething();

    public default void sayHi(){
        System.out.println("Hi A");
    }

}
