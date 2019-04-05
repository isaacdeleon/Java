package com.ginger;

public class Examen {

    public static void main(String[] args){

        Examen examen = new Examen();
        examen.reverse("house");
    }

    public void reverse(String original) {
        int length = original.length();
        String reversed = "";
        for(int i = length; i>=1; i--) {
            reversed = reversed + original.charAt(i-1);
        }

        if(original.equalsIgnoreCase(reversed)){
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }
}
