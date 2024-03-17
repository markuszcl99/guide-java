package com.markus.desgin.mode.creational.factory.article.abstractfactory;

/**
 * @author: markus
 * @date: 2024/3/16 11:38 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractCarFactory implements CarFactory {
    @Override
    public Car orderCar(CarType carType) {
        Car car = createCar(carType);

        car.installWheel();
        car.installSeat();
        car.installBattery();
        return car;
    }

    protected abstract Car createCar(CarType carType);
}
