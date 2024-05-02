package com.markus.custom.compress;

import com.markus.custom.encode.Base64EncodeAction;
import com.markus.custom.encode.EncodeAction;

/**
 * @author: markus
 * @date: 2024/5/2 3:41 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class CompressActionFactory {
    public static CompressAction getCompressAction(int mode) {
        CompressMode encodeMode = CompressMode.findModeByValue(mode);
        switch (encodeMode) {
            case NONE:
                return new NoneCompressAction();
            case LZ4:
                return new Lz4CompressAction();
        }
        throw new IllegalArgumentException("非法参数");
    }
}
