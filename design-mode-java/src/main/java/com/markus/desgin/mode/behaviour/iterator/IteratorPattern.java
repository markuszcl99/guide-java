package com.markus.desgin.mode.behaviour.iterator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/25
 * @Description:
 */
public class IteratorPattern {
  public static void main(String[] args) {
    Container<String> container = new NameRepository<String>();
    container.add("Markus Zhang");
    container.add("Markus");
    container.add("Luna");

    Iterator<String> iterator = container.iterator();
    while (iterator.hasNext()) {
      String name = iterator.next();
      System.out.println(name);
    }

  }
}
