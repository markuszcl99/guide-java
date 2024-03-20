package com.markus.desgin.mode.structural.flyweight;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/20
 * @Description:
 */
public class XiaomiCar implements Car {

  private String owner;

  public XiaomiCar(String owner) {
    this.owner = owner;
  }

  @Override
  public void drive() {
    System.out.println("车主: [ " + owner + " ] 的小米汽车被开走了");
  }
}
