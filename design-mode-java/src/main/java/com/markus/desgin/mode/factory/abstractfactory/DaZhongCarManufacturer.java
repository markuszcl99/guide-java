package com.markus.desgin.mode.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class DaZhongCarManufacturer implements CarManufacturer {
  @Override
  public Car product(CarType carType) {
    switch (carType) {
      case SUV:
        return new DaZhongSuvCar();
      case SALOON_CAR:
        return new DaZhongSaloonCar();
      default:
        throw new UnsupportedOperationException("小米汽车制造厂不生产该类型车");
    }
  }
}
