package com.markus.desgin.mode.behaviour.strategy;

/**
 * @author: markus
 * @date: 2024/4/5 1:42 PM
 * @Description: 加法操作
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SubtractionOperation implements ArithmeticOperation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
