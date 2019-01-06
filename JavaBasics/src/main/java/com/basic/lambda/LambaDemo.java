package com.basic.lambda;

import java.util.Arrays;
import java.util.List;

interface A {
    void show();
}

interface B {
    void show(int i);
}

//class Xyz implements A {
//    public void show() {
//        System.out.println("Hello");
//    }
//}

public class LambaDemo {

    public static void main(String[] args) {
//        A obj = new A() {
//            public void show() {
//                System.out.println("Hello Anonim");
//            }
//        };
//        A obj = () -> {
//            System.out.println("Hello Lamba");
//        };
        A obj = () -> System.out.println("Hello Lamba in one line");
        obj.show();

        B bojb = (intParam) -> System.out.println("Hello int val " + intParam);
        bojb.show(22);

        List<Integer> values = Arrays.asList(1,2,3,4,5);
        values.forEach(i -> System.out.println(i));
    }
}
