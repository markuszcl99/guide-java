package com.markus.desgin.mode.structure.facade;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/15
 * @Description:
 */
public class FacadePatternDemo {
  public static void main(String[] args) {
    RestaurantFacade facade = new RestaurantFacade();
    facade.eat("糖醋排骨");
  }
}
