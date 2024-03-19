package com.markus.desgin.mode.creational.factory.article.abstractfactory;

/**
 * @author: markus
 * @date: 2024/3/16 11:45 PM
 * @Description: 消费者
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Consumer {
    public static void main(String[] args) {
        // 想买小米旗舰版汽车
        CarFactory carFactory = new XiaomiCarFactory();
        Car car = carFactory.orderCar(CarType.FLAGSHIP);

        System.out.println();

        // 想买比亚迪基础版汽车
        carFactory = new BYDCarFactory();
        car = carFactory.orderCar(CarType.BASIC);
    }
}
