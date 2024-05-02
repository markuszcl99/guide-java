package com.markus.compress.lz4;

import com.markus.compress.lz4.util.Lz4CompressUtils;
import com.markus.serialize.pb.domain.User;
import com.markus.serialize.pb.utils.ProtoStuffUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

/**
 * @author: markus
 * @date: 2024/5/2 10:29 AM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Lz4QuickStart {
    public static void main(String[] args) {
        Random random = new Random(47);
        List<Long> poiIds = new ArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
//            poiIds.add(random.nextLong());
            poiIds.add(10000L);
        }
        User user = User.builder()
                .id(1L)
                .username("markus")
                .company("meituan")
                .salary(2500D)
                .poiIds(poiIds)
                .build();

        byte[] serialize = ProtoStuffUtils.serialize(user);
        byte[] compress = Lz4CompressUtils.compress(serialize);
        String encodeToString = Base64.getEncoder().encodeToString(compress);
        System.out.println("pb.size : " + serialize.length);
        System.out.println("compress.size : " + compress.length);
        System.out.println("encodeToString.size : " + encodeToString.length());
//        System.out.println(encodeToString);

        byte[] decode = Base64.getDecoder().decode(encodeToString);
        byte[] decompress = Lz4CompressUtils.decompress(decode);
        User deserialize = ProtoStuffUtils.deserialize(decompress, User.class);
//        System.out.println(deserialize);
    }
}
