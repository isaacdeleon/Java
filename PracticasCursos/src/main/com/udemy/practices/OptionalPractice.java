package com.udemy.practices;

import java.util.Optional;

public class OptionalPractice {

    public static void main(String[]args){

        Long id = null;

        Long optCadena = Optional.ofNullable(id).orElse(0L);

        Optional<Long> optional = Optional.ofNullable(id);

        System.out.println("long " + optional.isPresent());
    }
}
