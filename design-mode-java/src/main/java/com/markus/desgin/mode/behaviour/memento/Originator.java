package com.markus.desgin.mode.behaviour.memento;

/**
 * @author: markus
 * @date: 2024/4/2 11:26 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Originator {
    private String state;

    public Originator() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
