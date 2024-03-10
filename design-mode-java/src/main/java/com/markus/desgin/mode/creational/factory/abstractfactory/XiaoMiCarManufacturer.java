package com.markus.desgin.mode.creational.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class XiaoMiCarManufacturer implements CarManufacturer {
  @Override
  public Car product(CarType carType) {
    switch (carType) {
      case SUV:
        return new XiaoMiSuvCar();
      case SALOON_CAR:
        return new XiaoMiSallonCar();
      default:
        throw new UnsupportedOperationException("小米汽车制造厂不生产该类型车");
    }
  }
}
