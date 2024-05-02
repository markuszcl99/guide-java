package com.markus.custom.serialize.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.markus.custom.serialize.SerializeAction;

/**
 * @author: markus
 * @date: 2024/5/2 3:28 PM
 * @Description: fastjson 序列化工具
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class FastJsonSerializeAction implements SerializeAction {
    @Override
    public byte[] serialize(Object data) {
        return JSONObject.toJSONBytes(data);
    }

    @Override
    public Object deserialize(byte[] source, Class<?> clazz) {
        return JSONObject.parseObject(source, clazz);
    }
}
