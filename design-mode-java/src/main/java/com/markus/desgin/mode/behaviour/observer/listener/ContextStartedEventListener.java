package com.markus.desgin.mode.behaviour.observer.listener;

import com.markus.desgin.mode.behaviour.observer.event.ContextStartedEvent;

/**
 * @author: markus
 * @date: 2024/3/30 4:08 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ContextStartedEventListener implements ApplicationEventListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("监听到 ContextStartedEvent");
    }
}
