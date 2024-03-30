package com.markus.desgin.mode.behaviour.observer.multicaster;

import com.markus.desgin.mode.behaviour.observer.event.ApplicationEvent;
import com.markus.desgin.mode.behaviour.observer.listener.ApplicationEventListener;

import java.util.Collection;

/**
 * @author: markus
 * @date: 2024/3/30 2:33 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    @Override
    public void multicastEvent(ApplicationEvent event) {
        multicastEvent(event, resolveEventType(event));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void multicastEvent(ApplicationEvent event, Class<?> eventType) {
        for (ApplicationEventListener applicationEventListener : getApplicationEventListener(event, eventType)) {
            applicationEventListener.onApplicationEvent(event);
        }
    }

    private Class<?> resolveEventType(ApplicationEvent event) {
        return event.getClass();
    }
}
