package com.markus.desgin.mode.creational.factory.article.simple;

/**
 * @author: markus
 * @date: 2024/3/16 10:13 PM
 * @Description: 小米汽车
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BYDCar implements Car {
    @Override
    public void installWheel() {
        System.out.println("安装比亚迪轮子");
    }

    @Override
    public void installSeat() {
        System.out.println("安装比亚迪座椅");
    }

    @Override
    public void installBattery() {
        System.out.println("安装比亚迪电池");
    }
}
