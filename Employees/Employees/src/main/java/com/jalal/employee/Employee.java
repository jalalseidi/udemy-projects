package com.jalal.employee;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {
  protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
  protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
  private static final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}), \\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
  protected static final Pattern peoplePat = Pattern.compile(peopleRegex);
  protected final Matcher peopleMat;
  protected String lastName;
  protected String firstName;
  protected LocalDate dob;

  public Employee(String personText) {
    peopleMat = Employee.peoplePat.matcher(personText);
    if (peopleMat.find()) {
      this.lastName = peopleMat.group("lastName");
      this.firstName = peopleMat.group("firstName");
      this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
    }
  }

  public static final Employee createEmployee(String employeeText) {
    Matcher peopleMat = Employee.peoplePat.matcher(employeeText);
    if (peopleMat.find()) {
      return switch (peopleMat.group("role")) {
        case "Programmer" -> new Programmer(employeeText);
        case "Manger" -> new Manager(employeeText);
        case "Analyst" -> new Analyst(employeeText);
        case "CEO" -> new CEO(employeeText);
        default -> null;
      };
    } else {
      return null;
    }
  }

    public abstract int getSalary ();

    public double getBonus () {
      return getSalary() * 1.10;
    }

    @Override
    public String toString () {
      return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }
  }

