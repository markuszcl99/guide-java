package com.markus.desgin.mode.structure.composite;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/14
 * @Description:
 */
public class CompositePatternDemo {
  /**
   * 组合模式在 Spring 中的应用：org.springframework.aop.support.ComposablePointcut
   * @param args
   */
  public static void main(String[] args) {
    Employee employer = new Employee("employer",25,"老板");
    Employee employee = new Employee("markus",25,"员工");
    Employee employee1 = new Employee("markus1",25,"员工");
    Employee employee2 = new Employee("markus2",25,"员工");
    Employee employee3 = new Employee("markus3",25,"员工");

    employer.add(employee);
    employer.add(employee1);
    employer.add(employee2);
    employer.add(employee3);

    for (Employee employerEmployee : employer.getEmployees()) {
      System.out.println(employerEmployee);
    }

    employer.remove(employee1);
    for (Employee employerEmployee : employer.getEmployees()) {
      System.out.println(employerEmployee);
    }
  }
}
