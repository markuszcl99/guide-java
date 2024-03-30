package com.markus.desgin.mode.behaviour.observer.listener;

import com.markus.desgin.mode.behaviour.observer.event.ApplicationEvent;

/**
 * @author: markus
 * @date: 2024/3/30 3:26 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface GenericApplicationEventListener extends ApplicationEventListener<ApplicationEvent> {

    boolean supportsEventType(Class<?> eventType);
}
