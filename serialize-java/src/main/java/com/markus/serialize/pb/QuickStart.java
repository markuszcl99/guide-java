package com.markus.serialize.pb;

import com.alibaba.fastjson.JSONObject;
import com.markus.serialize.pb.domain.User;
import com.markus.serialize.pb.utils.ProtoStuffUtils;

/**
 * @author: markus
 * @date: 2024/5/2 9:08 AM
 * @Description: 快速开始
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class QuickStart {
    public static void main(String[] args) {
        User user = User.builder()
                .id(1L)
                .username("markus")
                .company("meituan")
                .salary(2500D)
                .build();

        byte[] serialize = ProtoStuffUtils.serialize(user);
        String fastjson = JSONObject.toJSONString(user);
        byte[] fastjsonByteArr = JSONObject.toJSONBytes(user);
        System.out.println("pb.size : " + serialize.length);
        System.out.println("fastjson.size : " + fastjson.length());
        System.out.println("fastjsonByteArr.size : " + fastjsonByteArr.length);
        for (byte b : serialize) {
            System.out.printf(" %d,", b);
        }
        System.out.println();

        User deserializeUser = ProtoStuffUtils.deserialize(serialize, User.class);
        System.out.println("user == deserializeUser : " + (user == deserializeUser));
        System.out.println(deserializeUser);
    }
}
