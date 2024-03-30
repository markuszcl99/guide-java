package com.markus.desgin.mode.behaviour.observer.event;

/**
 * @author: markus
 * @date: 2024/3/30 1:44 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ContextRefreshedEvent extends ApplicationEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
