package com.markus.desgin.mode.creational.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class CommonCarBuilder extends CarBuilder {

  @Override
  public CarBuilder buildWheel(Wheel wheel) {
    this.car.setWheel(wheel);
    return this;
  }

  @Override
  public CarBuilder buildSteeringWheel(SteeringWheel steeringWheel) {
    this.car.setSteeringWheel(steeringWheel);
    return this;
  }
}
