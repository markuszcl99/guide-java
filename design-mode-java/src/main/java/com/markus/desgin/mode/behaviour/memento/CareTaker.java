package com.markus.desgin.mode.behaviour.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2024/4/2 11:29 PM
 * @Description: 小心操作
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CareTaker {
    private List<Memento> mementos;

    public CareTaker() {
        this.mementos = new ArrayList<>();
    }

    public void add(Memento memento) {
        this.mementos.add(memento);
    }

    public Memento get(int index) {
        return this.mementos.get(index);
    }
}
