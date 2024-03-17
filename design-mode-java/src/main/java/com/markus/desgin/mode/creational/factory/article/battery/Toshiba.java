package com.markus.desgin.mode.creational.factory.article.battery;

/**
 * @author: markus
 * @date: 2024/3/16 11:06 PM
 * @Description: 东芝
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Toshiba implements BatteryFactory {
    @Override
    public String productBattery() {
        return "东芝电池";
    }
}
