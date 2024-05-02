package com.markus.custom.compress;

import com.markus.custom.serialize.SerializeMode;
import lombok.Getter;

/**
 * @author: markus
 * @date: 2024/5/2 3:31 PM
 * @Description: 编码方式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Getter
public enum CompressMode {
    NONE(0),
    LZ4(1),
    ;

    private int mode;

    CompressMode(int mode) {
        this.mode = mode;
    }

    public static CompressMode findModeByValue(int mode) {
        switch (mode) {
            case 0:
                return NONE;
            case 1:
                return LZ4;
            default:
                throw new IllegalArgumentException("参数违规，未找到指定类型的枚举");
        }
    }
}
