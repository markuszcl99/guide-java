package com.markus.desgin.mode.creational.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class AbstractFactoryClient {
  public static void main(String[] args) {
    CarManufacturer manufacturer = CarManufacturerFactory.create(ManufacturerType.XIAOMI);
    Car car = manufacturer.product(CarType.SUV);
    car.start();
    car.stop();

    car = manufacturer.product(CarType.SALOON_CAR);
    car.start();
    car.stop();

    manufacturer = CarManufacturerFactory.create(ManufacturerType.DA_ZHONG);
    car = manufacturer.product(CarType.SUV);
    car.start();
    car.stop();

    car = manufacturer.product(CarType.SALOON_CAR);
    car.start();
    car.stop();
  }
}
