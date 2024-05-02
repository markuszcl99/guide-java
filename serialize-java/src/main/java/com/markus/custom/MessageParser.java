package com.markus.custom;

import com.markus.custom.compress.CompressAction;
import com.markus.custom.compress.CompressActionFactory;
import com.markus.custom.encode.EncodeAction;
import com.markus.custom.encode.EncodeActionFactory;
import com.markus.custom.serialize.SerializeAction;
import com.markus.custom.serialize.SerializeActionFactory;

/**
 * @author: markus
 * @date: 2024/5/2 4:39 PM
 * @Description: Message 解析
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MessageParser {
    public static Object parseMessage(Message message) throws ClassNotFoundException {
        EncodeAction encodeAction = EncodeActionFactory.getEncodeAction(message.getEncodeMode());
        byte[] decoded = encodeAction.decode(message.getTranslationData());

        CompressAction compressAction = CompressActionFactory.getCompressAction(message.getCompressMode());
        byte[] decompressed = compressAction.decompress(decoded);
        SerializeAction serializeAction = SerializeActionFactory.getSerializeAction(message.getSerializeMode());

        Class<?> clazz = Class.forName(message.getRawDataType());
        return serializeAction.deserialize(decompressed, clazz);
    }
}
