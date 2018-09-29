package com.udemy.practices;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[]args){

        Function<Integer,String> converter = (i)-> Integer.toString(i);

        String strInt = converter.apply(4);

        System.out.println(converter.apply(444).length());
    }
}
