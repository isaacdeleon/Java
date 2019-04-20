package com.basic.enums;

public class MyEnumTest {

  public static void main(String[] args) {

    int max = 15;
    int min = 1;
    int range = max - min + 1;
    int rand = (int) (Math.random() * range) + min;

    System.out.println("Generated Random " + rand);

    MyEnum myEnum;

    if (rand < 5) {
      myEnum = MyEnum.COMPLETED;
    } else if (rand > 5 && rand < 10) {
      myEnum = MyEnum.IN_PROGRESS;
    } else {
      myEnum = MyEnum.MY_STRING;
    }

    switch (myEnum) {
      case COMPLETED:
        System.out.println("Completed");
        break;
      case IN_PROGRESS:
        System.out.println("InProgress");
        break;
      case MY_STRING:
        System.out.println("String case");
        break;
    }
  }
}
