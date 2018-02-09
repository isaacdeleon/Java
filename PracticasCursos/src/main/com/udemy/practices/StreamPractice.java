package com.udemy.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String[]args){

        List<String> nombres = new ArrayList<>();
        nombres.add("MARCO");
        nombres.add("JORGE");
        nombres.add("ARMANDO");
        nombres.add("MIGUEL");
        nombres.add("SERGIO");

        Stream<String> nombreA = nombres.stream().filter(it -> it.contains("Z"));


        System.out.println(nombreA.findFirst().orElse("notfound").toString());

    }
}
