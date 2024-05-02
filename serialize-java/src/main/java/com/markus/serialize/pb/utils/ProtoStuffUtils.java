package com.markus.serialize.pb.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: markus
 * @date: 2024/5/2 9:09 AM
 * @Description: 序列化工具类
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ProtoStuffUtils {
    /**
     * 避免每次序列化都重新申请空间
     */
    private static LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

    /**
     * 缓存 schema
     */
    private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap<>();

    /**
     * 序列化
     * @param obj
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(clazz);
        byte[] data;
        try {
            data = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } finally {
            buffer.clear();
        }
        return data;
    }

    /**
     * 反序列化
     * @param data
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        Schema<T> schema = getSchema(clazz);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) schemaCache.get(clazz);
        if (Objects.isNull(schema)) {
            schema = RuntimeSchema.getSchema(clazz);
            if (Objects.nonNull(schema)) {
                schemaCache.put(clazz, schema);
            }
        }
        return schema;
    }

}
