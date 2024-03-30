package com.markus.desgin.mode.behaviour.observer.multicaster;

import com.markus.desgin.mode.behaviour.observer.event.ApplicationEvent;
import com.markus.desgin.mode.behaviour.observer.listener.ApplicationEventListener;

/**
 * @author: markus
 * @date: 2024/3/30 1:42 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationEventListener<?> listener);

    void removeApplicationListener(ApplicationEventListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
