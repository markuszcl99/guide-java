package com.markus.java.generic;

/**
 * @author: markus
 * @date: 2024/1/4 11:33 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SimpleHolder3<T extends String> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return this.obj;
    }

    public static void main(String[] args) {
        SimpleHolder3<String> simpleHolder = new SimpleHolder3<>();
        simpleHolder.set("Item");
        String s = simpleHolder.get();
    }
}
