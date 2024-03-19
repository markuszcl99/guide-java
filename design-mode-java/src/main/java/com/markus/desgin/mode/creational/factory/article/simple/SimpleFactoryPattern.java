package com.markus.desgin.mode.creational.factory.article.simple;

/**
 * @author: markus
 * @date: 2024/3/16 10:37 PM
 * @Description: 简单工厂模式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        // 买小米汽车
        Car car = orderCar(CarType.XIAOMI);
        // 买比亚迪汽车
        car = orderCar(CarType.BYD);
    }

    private static Car orderCar(CarType carType) {
        CarFactory carFactory = new DefaultCarFactory();
        Car car = carFactory.createCar(carType);

        // 有了汽车厂商后，我们就开始安装对应的电池、轮子以及座椅（实际上很多程序，我这里就选三个作为举例）
        car.installBattery();
        car.installWheel();
        car.installSeat();

        // 将成品交付
        return car;
    }
}
