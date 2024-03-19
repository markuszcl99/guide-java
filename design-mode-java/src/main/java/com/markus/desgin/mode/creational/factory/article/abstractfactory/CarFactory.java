package com.markus.desgin.mode.creational.factory.article.abstractfactory;

/**
 * @author: markus
 * @date: 2024/3/16 10:00 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface CarFactory {

    Car orderCar(CarType carType);
}
