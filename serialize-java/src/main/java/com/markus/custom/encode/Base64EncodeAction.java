package com.markus.custom.encode;

import java.util.Base64;

/**
 * @author: markus
 * @date: 2024/5/2 3:53 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Base64EncodeAction implements EncodeAction {
    @Override
    public String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    @Override
    public byte[] decode(String source) {
        return Base64.getDecoder().decode(source);
    }
}
