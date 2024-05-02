package com.markus.custom.serialize;

/**
 * @author: markus
 * @date: 2024/5/2 3:24 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface SerializeAction {
    byte[] serialize(Object data);

    Object deserialize(byte[] source, Class<?> clazz);
}
