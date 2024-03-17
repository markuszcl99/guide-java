package com.markus.desgin.mode.creational.factory.article.abstractfactory;

import com.markus.desgin.mode.creational.factory.article.battery.BatteryFactory;

/**
 * @author: markus
 * @date: 2024/3/16 11:29 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class XiaomiBasicCar extends AbstractCar {


    public XiaomiBasicCar(BatteryFactory batteryFactory) {
        super(batteryFactory);
    }

    @Override
    public void installWheel() {
        System.out.println("安装小米基础版轮子");
    }

    @Override
    public void installSeat() {
        System.out.println("安装小米基础版座椅");
    }
}
