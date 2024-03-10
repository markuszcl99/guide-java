package com.markus.desgin.mode.creational.factory.simple;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class SimpleFactory {

  public static Car create(CarType type) {
    switch (type) {
      case XIAOMI:
        return new XiaoMiCar();
      case SANTANA:
        return new SantanaCar();
      default:
        throw new UnsupportedOperationException("不支持的汽车类型");
    }
  }
}
