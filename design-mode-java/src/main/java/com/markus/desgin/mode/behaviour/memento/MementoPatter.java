package com.markus.desgin.mode.behaviour.memento;

/**
 * @author: markus
 * @date: 2024/4/2 11:30 PM
 * @Description: 备忘录模式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MementoPatter {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("状态1");
        originator.setState("状态2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("状态3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("状态4");

        System.out.println("当前状态: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("第一次保存时的状态: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("第二次保存时的状态: " + originator.getState());
    }
}
