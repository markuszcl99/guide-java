package com.markus.desgin.mode.prototype;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public abstract class Car implements Cloneable {

  private String carName;
  private String carType;

  abstract void drive();

  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }
}
