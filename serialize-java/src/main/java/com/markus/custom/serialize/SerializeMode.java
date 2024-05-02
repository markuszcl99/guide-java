package com.markus.custom.serialize;

import lombok.Getter;

/**
 * @author: markus
 * @date: 2024/5/2 3:15 PM
 * @Description: 序列化方式
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Getter
public enum SerializeMode {
    FASTJSON(1),
    PB(2),
    ;

    private int mode;

    SerializeMode(int mode) {
        this.mode = mode;
    }

    public static SerializeMode findModeByValue(int mode) {
        switch (mode) {
            case 1:
                return FASTJSON;
            case 2:
                return PB;
            default:
                throw new IllegalArgumentException("参数违规，未找到指定类型的枚举");
        }
    }
}
