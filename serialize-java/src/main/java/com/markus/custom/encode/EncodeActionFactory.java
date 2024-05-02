package com.markus.custom.encode;

import com.markus.custom.serialize.SerializeAction;
import com.markus.custom.serialize.SerializeMode;
import com.markus.custom.serialize.fastjson.FastJsonSerializeAction;
import com.markus.custom.serialize.pb.PbSerializeAction;

/**
 * @author: markus
 * @date: 2024/5/2 3:41 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class EncodeActionFactory {
    public static EncodeAction getEncodeAction(int mode) {
//        EncodeMode encodeMode = EncodeMode.findModeByValue(mode);
        // 当前只有一种编码方式，直接返回即可，后续再扩展
        return new Base64EncodeAction();
    }
}
