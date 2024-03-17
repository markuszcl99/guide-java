package com.markus.desgin.mode.creational.factory.article.abstractfactory;

import com.markus.desgin.mode.creational.factory.article.battery.BatteryFactory;

/**
 * @author: markus
 * @date: 2024/3/16 11:12 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractCar implements Car {
    protected BatteryFactory batteryFactory;

    public AbstractCar(BatteryFactory batteryFactory) {
        this.batteryFactory = batteryFactory;
    }

    @Override
    public void installBattery() {
        String battery = batteryFactory.productBattery();
        System.out.println("安装【" + battery + "】电池");
    }
}
