package com.markus.desgin.mode.behaviour.observer;

import com.markus.desgin.mode.behaviour.observer.event.ContextRefreshedEvent;
import com.markus.desgin.mode.behaviour.observer.event.ContextStartedEvent;
import com.markus.desgin.mode.behaviour.observer.listener.ContextRefreshedEventListener;
import com.markus.desgin.mode.behaviour.observer.listener.ContextStartedEventListener;
import com.markus.desgin.mode.behaviour.observer.multicaster.ApplicationEventMulticaster;
import com.markus.desgin.mode.behaviour.observer.multicaster.SimpleApplicationEventMulticaster;

/**
 * @author: markus
 * @date: 2024/3/30 3:46 PM
 * @Description: 观察者模式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ObserverPattern {
    public static void main(String[] args) {
        ApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        applicationEventMulticaster.addApplicationListener(new ContextRefreshedEventListener());
        applicationEventMulticaster.addApplicationListener(new ContextStartedEventListener());

        System.out.println("发布 ContextRefreshedEvent 事件: ");
        // 打印 ContextRefreshedEventListener 监听结果
        applicationEventMulticaster.multicastEvent(new ContextRefreshedEvent(new Object()));

        System.out.println("\n发布 ContextStartedEvent 事件: ");
        // 打印 ContextStartedEventListener 监听结果
        applicationEventMulticaster.multicastEvent(new ContextStartedEvent(new Object()));
    }
}
