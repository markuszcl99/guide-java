package com.markus.java.generic;

/**
 * @author: markus
 * @date: 2024/1/4 11:33 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get(){
        return this.obj;
    }

    public static void main(String[] args) {
        SimpleHolder simpleHolder = new SimpleHolder();
        simpleHolder.set("Item");
        String s = (String) simpleHolder.get();
    }
}
