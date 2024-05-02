package com.markus.custom.serialize.pb;

import com.markus.custom.serialize.SerializeAction;

/**
 * @author: markus
 * @date: 2024/5/2 3:29 PM
 * @Description: pb 序列化工具
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PbSerializeAction implements SerializeAction {
    @Override
    public byte[] serialize(Object data) {
        return ProtoStuffUtils.serialize(data);
    }

    @Override
    public Object deserialize(byte[] source, Class<?> clazz) {
        return ProtoStuffUtils.deserialize(source, clazz);
    }
}
