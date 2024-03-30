package com.markus.desgin.mode.behaviour.observer.listener;

import com.markus.desgin.mode.behaviour.observer.event.ApplicationEvent;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: markus
 * @date: 2024/3/30 3:27 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class GenericApplicationEventListenerAdapter implements GenericApplicationEventListener {

    private static final Map<Class<?>, Class<?>> eventTypeCache = new ConcurrentHashMap<>();
    private final ApplicationEventListener<ApplicationEvent> delegate;
    private final Class<?> declaredEventType;

    @SuppressWarnings("unchecked")
    public GenericApplicationEventListenerAdapter(ApplicationEventListener<?> listener) {
        this.delegate = (ApplicationEventListener<ApplicationEvent>) listener;
        this.declaredEventType = resolveEventType(delegate);
    }

    @Nullable
    private Class<?> resolveEventType(ApplicationEventListener<ApplicationEvent> listener) {
        Class<?> listenerClass = listener.getClass();
        Class<?> existEventType = eventTypeCache.get(listenerClass);
        if (existEventType != null) {
            return existEventType;
        }
        Type[] genericInterfaces = listener.getClass().getGenericInterfaces();
        ParameterizedType genericInterface = (ParameterizedType) genericInterfaces[0];
        Type[] typeArguments = genericInterface.getActualTypeArguments();
        if (typeArguments.length > 0 && typeArguments[0] instanceof Class) {
            Class<?> eventType = (Class<?>) typeArguments[0];
            eventTypeCache.put(listenerClass, eventType);
            return eventType;
        }
        return null;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        this.delegate.onApplicationEvent(event);
    }

    @Override
    public boolean supportsEventType(Class<?> eventType) {
        return this.declaredEventType.isAssignableFrom(eventType);
    }
}
