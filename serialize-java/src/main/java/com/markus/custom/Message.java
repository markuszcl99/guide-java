package com.markus.custom;

import com.markus.custom.compress.CompressMode;
import com.markus.custom.encode.EncodeMode;
import com.markus.custom.serialize.SerializeMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: markus
 * @date: 2024/5/2 3:14 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Getter
@Builder
public class Message implements Serializable {

    public static int MAGIC_NUMBER = 0xCAFEBABE;
    public static int DEFAULT_VERSION = 1;
    public static SerializeMode DEFAULT_SERIALIZE_MODE = SerializeMode.PB;
    public static EncodeMode DEFAULT_ENCODE_MODE = EncodeMode.BASE64;
    public static CompressMode DEFAULT_COMPRESS_MODE = CompressMode.NONE;

    private int magicNumber;
    private int version;
    private int encodeMode;
    private int compressMode;
    private int serializeMode;
    private String rawDataType;
    private String translationData;

    public void setTranslationData(String translationData) {
        this.translationData = translationData;
    }
}
