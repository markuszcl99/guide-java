package com.markus.desgin.mode.behaviour.observer.event;

import java.util.EventObject;

/**
 * @author: markus
 * @date: 2024/3/30 1:43 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "ApplicationEvent{" +
                "source=" + source +
                "} " + super.toString();
    }
}
