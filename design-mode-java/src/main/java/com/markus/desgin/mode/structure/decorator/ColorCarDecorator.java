package com.markus.desgin.mode.structure.decorator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/13
 * @Description:
 */
public abstract class ColorCarDecorator implements Car {

  private Car car;

  public ColorCarDecorator(Car car) {
    this.car = car;
  }

  @Override
  public void running() {
    before();
    car.running();
    after();
  }

  protected abstract void before();
  protected abstract void after();
}
