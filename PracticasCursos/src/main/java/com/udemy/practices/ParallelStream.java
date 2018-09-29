package com.udemy.practices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {

    public static void main(String[]srgs){
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Integer suma = lista.parallelStream().peek(System.out::println).reduce(0,(a,b)->a+b);

        //se ejecuta paralelamente dependiendo del tipo de lista que recorre
        String listaStr = lista.parallelStream().map(String::valueOf).collect(Collectors.joining(","));

        System.out.println(listaStr);
    }
}
