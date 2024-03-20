package com.markus.desgin.mode.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/20
 * @Description:
 */
public class XiaomiCarFactory implements CarFactory {

  private final Map<String, Car> garage = new ConcurrentHashMap<>();

  @Override
  public Car getCar(String owner) {
    if (garage.containsKey(owner)) {
      return garage.get(owner);
    }
    Car car = new XiaomiCar(owner);
    garage.put(owner, car);
    return car;
  }
}
