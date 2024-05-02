package com.markus.encode.base64;

import com.markus.serialize.pb.domain.User;
import com.markus.serialize.pb.utils.ProtoStuffUtils;

import java.util.Base64;

/**
 * @author: markus
 * @date: 2024/5/2 9:57 AM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Java8Test {
    public static void main(String[] args) {
        User user = User.builder()
                .id(1L)
                .username("markus")
                .company("meituan")
                .salary(2500D)
                .build();

        byte[] serialize = ProtoStuffUtils.serialize(user);
        String encodeToString = Base64.getEncoder().encodeToString(serialize);
        System.out.println("pb.size : " + serialize.length);
        System.out.println("encodeToString.size : " + encodeToString.length());
        System.out.println(encodeToString);

        byte[] decode = Base64.getDecoder().decode(encodeToString);
        User deserialize = ProtoStuffUtils.deserialize(decode, User.class);
        System.out.println(deserialize);
    }
}
