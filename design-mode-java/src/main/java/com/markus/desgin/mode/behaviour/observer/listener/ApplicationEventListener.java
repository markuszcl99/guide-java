package com.markus.desgin.mode.behaviour.observer.listener;

import com.markus.desgin.mode.behaviour.observer.event.ApplicationEvent;

import java.util.EventListener;

/**
 * @author: markus
 * @date: 2024/3/30 1:42 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface ApplicationEventListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
