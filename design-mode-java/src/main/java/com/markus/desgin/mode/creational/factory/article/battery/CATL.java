package com.markus.desgin.mode.creational.factory.article.battery;

/**
 * @author: markus
 * @date: 2024/3/16 11:05 PM
 * @Description: 宁德时代
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CATL implements BatteryFactory {
    @Override
    public String productBattery() {
        return "宁德时代电池";
    }
}
