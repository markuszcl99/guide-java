package com.markus.desgin.mode.creational.factory.article.abstractfactory;

import com.markus.desgin.mode.creational.factory.article.battery.BatteryFactory;
import com.markus.desgin.mode.creational.factory.article.battery.CATL;
import com.markus.desgin.mode.creational.factory.article.battery.Toshiba;

/**
 * @author: markus
 * @date: 2024/3/16 11:32 PM
 * @Description: 比亚迪汽车生产商
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BYDCarFactory extends AbstractCarFactory {

    @Override
    protected Car createCar(CarType carType) {
        BatteryFactory batteryFactory = new CATL();
        Car car;
        if (CarType.BASIC.equals(carType)) {
            return new BYDBasicCar(batteryFactory);
        } else if (CarType.FLAGSHIP.equals(carType)) {
            return new BYDFlagshipCar(batteryFactory);
        }
        throw new UnsupportedOperationException("不支持的汽车类型");
    }
}
