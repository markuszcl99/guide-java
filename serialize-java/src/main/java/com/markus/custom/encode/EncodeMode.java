package com.markus.custom.encode;

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
public enum EncodeMode {
    BASE64(1),
    ;

    private int mode;

    EncodeMode(int mode) {
        this.mode = mode;
    }

    public static EncodeMode findModeByValue(int mode) {
        if (mode == 1) {
            return BASE64;
        }
        throw new IllegalArgumentException("参数违规，未找到指定类型的枚举");
    }
}
