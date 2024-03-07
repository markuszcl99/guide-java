package com.markus.desgin.mode.prototype;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class XiaoMiSuvCar extends Car {
  @Override
  void drive() {
    String message = "carName: " + this.getCarName() + ", carType: " + this.getCarType();
    System.out.println(message + " 已启动");
  }
}
