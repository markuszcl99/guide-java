package com.markus.desgin.mode.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public class Car {
  private Wheel wheel;

  private SteeringWheel steeringWheel;

  public Wheel getWheel() {
    return wheel;
  }

  public void setWheel(Wheel wheel) {
    this.wheel = wheel;
  }

  public SteeringWheel getSteeringWheel() {
    return steeringWheel;
  }

  public void setSteeringWheel(SteeringWheel steeringWheel) {
    this.steeringWheel = steeringWheel;
  }

  @Override
  public String toString() {
    return "Car{" +
        "wheel=" + wheel +
        ", steeringWheel=" + steeringWheel +
        '}';
  }
}
