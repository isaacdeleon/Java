package com.udemy.practices;

public class FunctionalInterfacePractice{

    public static void main(String[]args){

        String str11 = "hello ";
        String str22 = "world ";

        FunctionalInterface<String,Integer> functionalInterface = (str1,str2) -> Integer.valueOf(str1) + Integer.valueOf(str2);

        int resultado = functionalInterface.getNumberValue("24","25");

        System.out.println( "resultado " + resultado);
    }

}
