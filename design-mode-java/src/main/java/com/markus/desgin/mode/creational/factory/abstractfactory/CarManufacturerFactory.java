package com.markus.desgin.mode.creational.factory.abstractfactory;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/5
 * @Description:
 */
public class CarManufacturerFactory {

  public static CarManufacturer create(ManufacturerType type) {
    switch (type) {
      case XIAOMI:
        return new XiaoMiCarManufacturer();
      case DA_ZHONG:
        return new DaZhongCarManufacturer();
      default:
        throw new UnsupportedOperationException("不支持的汽车制造商类型");
    }
  }
}
