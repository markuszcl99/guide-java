package com.markus.desgin.mode.creational.factory.article.abstractfactory;

import com.markus.desgin.mode.creational.factory.article.battery.BatteryFactory;
import com.markus.desgin.mode.creational.factory.article.battery.CATL;
import com.markus.desgin.mode.creational.factory.article.battery.Toshiba;

/**
 * @author: markus
 * @date: 2024/3/16 11:25 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class XiaomiCarFactory extends AbstractCarFactory {

    @Override
    protected Car createCar(CarType carType) {
        BatteryFactory batteryFactory = new Toshiba();
        if (CarType.BASIC.equals(carType)) {
            return new XiaomiBasicCar(batteryFactory);
        } else if (CarType.FLAGSHIP.equals(carType)) {
            return new XiaomiFlagshipCar(batteryFactory);
        }
        throw new UnsupportedOperationException("不支持的汽车类型");
    }
}
