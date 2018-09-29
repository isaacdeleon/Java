package com.udemy.practices;

public class DefaultMethod implements InterfaceA, InterfaceB{

    public static void main(String[]args){
        DefaultMethod df = new DefaultMethod();

        df.saySomething();
        df.sayHi();
    }

    @Override
    public void saySomething() {
        System.out.println("Hello world");
    }

    @Override
    public void sayHi() {
        System.out.println("implemetation of sayHi() in MyClass");
        InterfaceA.super.sayHi();
        InterfaceB.super.sayHi();
    }
}
