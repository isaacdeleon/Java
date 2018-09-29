package com.udemy.practices;

public interface InterfaceB {

    public default void sayHi(){
        System.out.println("Hi B");
    }

}
