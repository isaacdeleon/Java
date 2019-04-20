package com.basic.enums;

public enum MyEnum {
  COMPLETED(7),
  IN_PROGRESS(6),
  MY_STRING("String Case");

  private int statusValues;
  private String stringValues;

  private MyEnum(int statusValues) {
    this.statusValues = statusValues;
  }

  private MyEnum(String stringValues) {
    this.stringValues = stringValues;
  }
}
