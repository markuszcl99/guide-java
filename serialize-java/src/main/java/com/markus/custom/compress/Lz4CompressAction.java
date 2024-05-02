package com.markus.custom.compress;

import com.markus.custom.compress.utils.Lz4CompressUtils;

/**
 * @author: markus
 * @date: 2024/5/2 3:58 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Lz4CompressAction implements CompressAction {
    @Override
    public byte[] compress(byte[] source) {
        return Lz4CompressUtils.compress(source);
    }

    @Override
    public byte[] decompress(byte[] source) {
        return Lz4CompressUtils.decompress(source);
    }
}
