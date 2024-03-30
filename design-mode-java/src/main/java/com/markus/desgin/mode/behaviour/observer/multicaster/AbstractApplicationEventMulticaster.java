package com.markus.desgin.mode.behaviour.observer.multicaster;

import com.markus.desgin.mode.behaviour.observer.event.ApplicationEvent;
import com.markus.desgin.mode.behaviour.observer.listener.ApplicationEventListener;
import com.markus.desgin.mode.behaviour.observer.listener.GenericApplicationEventListenerAdapter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: markus
 * @date: 2024/3/30 1:51 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster {

    private final DefaultListenerRetriever defaultRetriever = new DefaultListenerRetriever();
    private Map<ListenerCacheKey, CachedListenerRetriever> retrieverCache = new ConcurrentHashMap<>(16);

    @Override
    public void addApplicationListener(ApplicationEventListener<?> listener) {
        synchronized (defaultRetriever) {
            this.defaultRetriever.applicationEventListeners.add(listener);
            this.retrieverCache.clear();
        }
    }

    @Override
    public void removeApplicationListener(ApplicationEventListener<?> listener) {
        synchronized (defaultRetriever) {
            this.defaultRetriever.applicationEventListeners.remove(listener);
            this.retrieverCache.clear();
        }
    }

    public Collection<ApplicationEventListener<?>> getApplicationEventListener(ApplicationEvent event, Class<?> eventType) {
        Class<?> sourceType = event.getSource().getClass();
        ListenerCacheKey cacheKey = new ListenerCacheKey(eventType, sourceType);
        CachedListenerRetriever newRetriever = null;

        CachedListenerRetriever existListenerRetriever = retrieverCache.get(cacheKey);
        if (existListenerRetriever == null) {
            newRetriever = new CachedListenerRetriever();
            existListenerRetriever = retrieverCache.putIfAbsent(cacheKey, newRetriever);
            if (existListenerRetriever != null) {
                // 不需要设置
                newRetriever = null;
            }
        }
        if (existListenerRetriever != null) {
            return existListenerRetriever.getApplicationEventListeners();
        }
        return retrieveApplicationListeners(eventType, sourceType, newRetriever);
    }

    private Collection<ApplicationEventListener<?>> retrieveApplicationListeners(Class<?> eventType, Class<?> sourceType, CachedListenerRetriever newRetriever) {
        Collection<ApplicationEventListener<?>> applicationEventListeners = defaultRetriever.getApplicationEventListeners();
        Collection<ApplicationEventListener<?>> result = new ArrayList<>(applicationEventListeners.size());
        for (ApplicationEventListener<?> applicationEventListener : applicationEventListeners) {
            // 筛选逻辑
            // 1. 事件类型匹配
            GenericApplicationEventListenerAdapter listenerAdapter = new GenericApplicationEventListenerAdapter(applicationEventListener);
            if (listenerAdapter.supportsEventType(eventType)) {
                result.add(applicationEventListener);
            }
        }
        return result;
    }

    private static class CachedListenerRetriever {
        public volatile Set<ApplicationEventListener<?>> applicationEventListeners;

        public Collection<ApplicationEventListener<?>> getApplicationEventListeners() {
            List<ApplicationEventListener<?>> allListeners = new ArrayList<>(
                    this.applicationEventListeners.size());
            allListeners.addAll(this.applicationEventListeners);
            return allListeners;
        }
    }

    private static class DefaultListenerRetriever {

        public final Set<ApplicationEventListener<?>> applicationEventListeners = new LinkedHashSet<>();

        public Collection<ApplicationEventListener<?>> getApplicationEventListeners() {
            List<ApplicationEventListener<?>> allListeners = new ArrayList<>(
                    this.applicationEventListeners.size());
            allListeners.addAll(this.applicationEventListeners);
            return allListeners;
        }
    }

    private static class ListenerCacheKey implements Comparable<ListenerCacheKey> {

        public final Class<?> eventType;
        public final Class<?> sourceType;

        private ListenerCacheKey(Class<?> eventType, Class<?> sourceType) {
            this.eventType = eventType;
            this.sourceType = sourceType;
        }

        @Override
        public int hashCode() {
            return this.eventType.hashCode() * 29 + this.sourceType.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListenerCacheKey)) {
                return false;
            }
            return this.eventType.equals(((ListenerCacheKey) other).eventType)
                    && this.sourceType.equals(((ListenerCacheKey) other).sourceType);
        }

        @Override
        public String toString() {
            return "ListenerCacheKey{" +
                    "eventType=" + eventType +
                    ", sourceType=" + sourceType +
                    '}';
        }

        @Override
        public int compareTo(ListenerCacheKey other) {
            int result = this.eventType.toString().compareTo(other.eventType.toString());
            if (result == 0) {
                if (this.sourceType == null) {
                    return (other.sourceType == null ? 0 : -1);
                }
                if (other.sourceType == null) {
                    return 1;
                }
                result = this.sourceType.getName().compareTo(other.sourceType.getName());
            }
            return result;
        }
    }
}
