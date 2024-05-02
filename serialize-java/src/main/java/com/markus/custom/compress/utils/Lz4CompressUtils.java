package com.markus.custom.compress.utils;

import com.sun.istack.internal.Nullable;
import lombok.extern.slf4j.Slf4j;
import net.jpountz.lz4.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author: markus
 * @date: 2024/5/2 10:04 AM
 * @Description: lz4 压缩工具
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Slf4j
public class Lz4CompressUtils {
    private static final int ARRAY_SIZE = 4096;
    private static LZ4Factory factory = LZ4Factory.fastestInstance();
    private static LZ4Compressor compressor = factory.fastCompressor();
    private static LZ4FastDecompressor decompressor = factory.fastDecompressor();
    private static LZ4SafeDecompressor safeDecompressor = factory.safeDecompressor();

    @Nullable
    public static byte[] compress(byte[] data) {
        if (data == null || data.length == 0) {
            return data;
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            LZ4BlockOutputStream lz4BlockOutputStream = new LZ4BlockOutputStream(outputStream, ARRAY_SIZE, compressor);
            lz4BlockOutputStream.write(data);
            lz4BlockOutputStream.finish();
            return outputStream.toByteArray();
        } catch (Exception e) {
            log.error("compress error, exception is {}", e.getMessage());
        }
        return null;
    }

    public static byte[] decompress(byte[] compress) {
        if (compress == null || compress.length == 0) {
            return compress;
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(ARRAY_SIZE);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(compress);
            LZ4BlockInputStream decompressInputStream = new LZ4BlockInputStream(inputStream, decompressor);
            int count;
            byte[] buffer = new byte[ARRAY_SIZE];
            while ((count = decompressInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            log.error("decompress error, exception is {}", e.getMessage());
        }
        return null;
    }
}
