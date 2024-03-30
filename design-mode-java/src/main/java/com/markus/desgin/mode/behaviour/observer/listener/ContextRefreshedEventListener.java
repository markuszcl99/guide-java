package com.markus.desgin.mode.behaviour.observer.listener;

import com.markus.desgin.mode.behaviour.observer.event.ContextRefreshedEvent;

/**
 * @author: markus
 * @date: 2024/3/30 3:48 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ContextRefreshedEventListener implements ApplicationEventListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("监听到 ContextRefreshedEvent");
    }
}
