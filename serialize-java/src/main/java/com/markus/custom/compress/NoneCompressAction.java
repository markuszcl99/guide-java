package com.markus.custom.compress;

/**
 * @author: markus
 * @date: 2024/5/2 3:58 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class NoneCompressAction implements CompressAction {
    @Override
    public byte[] compress(byte[] source) {
        return source;
    }

    @Override
    public byte[] decompress(byte[] source) {
        return source;
    }
}
