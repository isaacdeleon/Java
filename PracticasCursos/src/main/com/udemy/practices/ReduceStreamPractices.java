package com.udemy.practices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceStreamPractices {

    public static void main(String[]srgs){

        Stream<String> stream = Stream.of("a","b","c","a");
        StringBuilder sb = new StringBuilder();
        //filter filtrar                  //map transformar          //iterar
        stream.filter(s -> s.equals("b")).map(s -> s.toUpperCase()).forEach(s -> sb.append(s));
                                                                                            // collectors
        List<String> lista = stream.filter(s -> s.equals("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(sb.toString());
    }
}
