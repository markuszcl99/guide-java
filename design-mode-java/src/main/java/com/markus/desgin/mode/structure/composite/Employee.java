package com.markus.desgin.mode.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/14
 * @Description:
 */
public class Employee {
  private String name;
  private Integer age;
  private String positionStatement;
  private List<Employee> employees;

  public Employee(String name, Integer age, String positionStatement) {
    this.name = name;
    this.age = age;
    this.positionStatement = positionStatement;
    this.employees = new ArrayList<>();
  }

  public void add(Employee employee) {
    this.employees.add(employee);
  }

  public void remove(Employee employee) {
    this.employees.remove(employee);
  }

  public List<Employee> getEmployees() {
    return this.employees;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", positionStatement='" + positionStatement + '\'' +
        '}';
  }
}
