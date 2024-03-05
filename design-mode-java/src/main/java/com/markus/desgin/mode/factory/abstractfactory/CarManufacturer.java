package com.markus.desgin.mode.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public interface CarManufacturer {
  Car product(CarType carType);
}
