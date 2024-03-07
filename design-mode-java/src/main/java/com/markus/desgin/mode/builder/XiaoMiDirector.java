package com.markus.desgin.mode.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description: 小米制造商
 */
public class XiaoMiDirector implements Director<Car> {
  private CarBuilder carBuilder;

  public XiaoMiDirector(CarBuilder carBuilder) {
    this.carBuilder = carBuilder;
  }

  @Override
  public Car construct() {
    carBuilder.buildWheel(new XiaomiWheel());
    carBuilder.buildSteeringWheel(new XiaomiSteeringWheel());
    return carBuilder.builder();
  }
}
