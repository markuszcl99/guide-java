package com.markus.desgin.mode.creational.factory.article.simple;

/**
 * @author: markus
 * @date: 2024/3/16 10:29 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultCarFactory implements CarFactory {

    @Override
    public Car createCar(CarType carType) {
        if (carType.equals(CarType.XIAOMI)) {
            return new XiaoMiCar();
        } else if (carType.equals(CarType.BYD)) {
            return new BYDCar();
        }
        throw new UnsupportedOperationException("其他汽车类型不支持创建!");
    }
}
