package com.markus.custom;

import com.markus.custom.compress.CompressAction;
import com.markus.custom.compress.CompressActionFactory;
import com.markus.custom.encode.EncodeAction;
import com.markus.custom.encode.EncodeActionFactory;
import com.markus.custom.serialize.SerializeAction;
import com.markus.custom.serialize.SerializeActionFactory;

import static com.markus.custom.Message.*;

/**
 * @author: markus
 * @date: 2024/5/2 4:11 PM
 * @Description: MessagePackager
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MessagePackager {

    public static <T> Message packageDefaultMessage(T data) {
        Message message = Message.builder()
                .magicNumber(MAGIC_NUMBER)
                .version(DEFAULT_VERSION)
                .serializeMode(DEFAULT_SERIALIZE_MODE.getMode())
                .compressMode(DEFAULT_COMPRESS_MODE.getMode())
                .encodeMode(DEFAULT_ENCODE_MODE.getMode())
                .rawDataType(data.getClass().getName())
                .build();

        SerializeAction serializeAction = SerializeActionFactory.getSerializeAction(message.getSerializeMode());
        byte[] serialize = serializeAction.serialize(data);
        CompressAction compressAction = CompressActionFactory.getCompressAction(message.getCompressMode());
        byte[] compressed = compressAction.compress(serialize);
        EncodeAction encodeAction = EncodeActionFactory.getEncodeAction(message.getEncodeMode());
        String targetData = encodeAction.encode(compressed);
        message.setTranslationData(targetData);

        return message;
    }
}
