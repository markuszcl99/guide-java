package com.markus.desgin.mode.behaviour.memento;

/**
 * @author: markus
 * @date: 2024/4/2 11:27 PM
 * @Description: 备忘录
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
