package com.jalalseidi.udemy.basicjava.exercise30;

public class Person {
  private String firstName;
  private String lastName;
  private int age;

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    if (age >= 0 && age <= 100) {
      this.age = age;
    } else {
      this.age = 0;
    }
  }

  public boolean isTeen() {
    return (age > 12 && age < 20);
  }

  public String getFullName() {
    if (firstName.isEmpty() && lastName.isEmpty()) {
      return "";
    }
    if (lastName.isEmpty()) {
      return firstName;
    }
    if (firstName.isEmpty()) {
      return lastName;
    }
    return firstName + " " + lastName;
  }
}
