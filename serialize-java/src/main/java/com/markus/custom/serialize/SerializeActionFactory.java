package com.markus.custom.serialize;

import com.markus.custom.serialize.fastjson.FastJsonSerializeAction;
import com.markus.custom.serialize.pb.PbSerializeAction;

/**
 * @author: markus
 * @date: 2024/5/2 3:41 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SerializeActionFactory {
    public static SerializeAction getSerializeAction(int mode) {
        SerializeMode serializeMode = SerializeMode.findModeByValue(mode);
        switch (serializeMode) {
            case PB:
                return new PbSerializeAction();
            case FASTJSON:
                return new FastJsonSerializeAction();
        }
        throw new IllegalArgumentException("非法参数");
    }
}
