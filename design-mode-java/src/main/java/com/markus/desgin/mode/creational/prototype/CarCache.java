package com.markus.desgin.mode.creational.prototype;

import java.util.HashMap;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class CarCache {
  private static HashMap<String, Car> carMap = new HashMap<String, Car>();

  static {
    XiaoMiSuvCar xiaoMiSuvCar = new XiaoMiSuvCar();
    xiaoMiSuvCar.setCarType("SUV");
    xiaoMiSuvCar.setCarName("XiaoMi");
    carMap.put("Xiaomi", xiaoMiSuvCar);

    BydSuvCar bydSuvCar = new BydSuvCar();
    bydSuvCar.setCarType("SUV");
    bydSuvCar.setCarName("BYD");
    carMap.put("BYD", bydSuvCar);
  }

  public static Car getCar(String key) {
    Car car = carMap.get(key);
    return (Car) car.clone();
  }
}
