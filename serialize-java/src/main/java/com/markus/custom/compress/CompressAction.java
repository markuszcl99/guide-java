package com.markus.custom.compress;

/**
 * @author: markus
 * @date: 2024/5/2 3:58 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface CompressAction {
    byte[] compress(byte[] source);

    byte[] decompress(byte[] source);
}
