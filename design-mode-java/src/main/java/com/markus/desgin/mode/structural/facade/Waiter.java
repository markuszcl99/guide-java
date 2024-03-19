package com.markus.desgin.mode.structural.facade;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/15
 * @Description:
 */
public class Waiter {
  public void order(String dishName) {
    System.out.println("顾客点了一道菜: " + dishName);
  }

  public void serving(String dish) {
    System.out.println("服务员上菜: " + dish);
  }
}
