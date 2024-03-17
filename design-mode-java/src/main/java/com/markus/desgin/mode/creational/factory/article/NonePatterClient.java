package com.markus.desgin.mode.creational.factory.article;

import com.markus.desgin.mode.creational.factory.article.simple.Car;
import com.markus.desgin.mode.creational.factory.article.simple.XiaoMiCar;

/**
 * @author: markus
 * @date: 2024/3/16 9:59 PM
 * @Description: 无模式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class NonePatterClient {
    public static void main(String[] args) {
        // 买小米汽车
        Car car = orderCar("xiaomi");

        // 买比亚迪汽车
        car = orderCar("byd");

    }

    private static Car orderCar(String type) {
        Car car;

        if ("xiaomi".equals(type)) {
            car = new XiaoMiCar();
        } else if ("byd".equals(type)) {
            car = new XiaoMiCar();
        } else {
            throw new UnsupportedOperationException("不支持的汽车类型");
        }

        // 有了汽车厂商后，我们就开始安装对应的电池、轮子以及座椅（实际上很多程序，我这里就选三个作为举例）
        car.installBattery();
        car.installWheel();
        car.installSeat();

        // 将成品交付
        return car;
    }
}
