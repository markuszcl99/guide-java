package com.markus.desgin.mode.structural.bridge;

/**
 * @author: markus
 * @date: 2024/4/5 2:18 PM
 * @Description: 正方形
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Square extends Shape {

    public Square(DrawApi api) {
        super(api);
    }

    @Override
    public void draw() {
        System.out.println("Draw Square: " + drawApi.draw());
    }
}
