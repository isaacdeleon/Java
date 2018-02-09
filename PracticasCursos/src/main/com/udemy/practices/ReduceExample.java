package com.udemy.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceExample {

    public static void main(String[]srgs){

        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //lista.stream().reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
        //lista.stream().reduce(Integer::sum).ifPresent(s -> System.out.println(s));


        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");
        list.add("perl");
        list.add("c");
        list.add("lisp");
        list.add("c#");
        Stream<String> wordStream = list.stream();
        Stream<String> wordStream2 = list.stream();
        Stream<String> wordStream3 = list.stream();

        Stream<Integer> lenghtStraeam = wordStream.map(s -> s.length());
        Optional<Integer> sum = lenghtStraeam.reduce((x,y) -> x + y);
        sum.ifPresent(System.out::println);


        Stream<Integer> lenghtStraeam2 = wordStream2.map(s -> s.length());
        int sum2 = lenghtStraeam2.reduce(0,(x,y) -> x+y);
        System.out.println(sum2);



    }
}
