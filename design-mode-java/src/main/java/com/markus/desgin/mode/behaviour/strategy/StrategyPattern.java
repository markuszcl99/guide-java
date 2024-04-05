package com.markus.desgin.mode.behaviour.strategy;

/**
 * @author: markus
 * @date: 2024/4/5 1:42 PM
 * @Description: 策略模式示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StrategyPattern {
    public static void main(String[] args) {
        ArithmeticOperation operation = new AddOperation();
        int calculate = operation.calculate(1, 2);
        System.out.println(calculate);

        operation = new SubtractionOperation();
        calculate = operation.calculate(1, 2);
        System.out.println(calculate);
    }
}
