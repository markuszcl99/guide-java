package com.markus.custom.encode;

/**
 * @author: markus
 * @date: 2024/5/2 3:53 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface EncodeAction {
    String encode(byte[] data);

    byte[] decode(String source);
}
