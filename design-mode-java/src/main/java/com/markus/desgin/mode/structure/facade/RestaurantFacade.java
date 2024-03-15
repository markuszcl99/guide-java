package com.markus.desgin.mode.structure.facade;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/15
 * @Description:
 */
public class RestaurantFacade {
  private Waiter waiter;
  private Chef chef;

  public RestaurantFacade() {
    waiter = new Waiter();
    chef = new Chef();
  }

  public void eat(String dishName) {
    waiter.order(dishName);
    String cook = chef.cook(dishName);
    waiter.serving(cook);
    System.out.println("顾客可以吃了...");
  }
}
