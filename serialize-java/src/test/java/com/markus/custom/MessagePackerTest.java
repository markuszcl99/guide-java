package com.markus.custom;

import com.alibaba.fastjson.JSONObject;
import com.markus.serialize.pb.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: markus
 * @date: 2024/5/2 4:30 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MessagePackerTest {

    @Test
    public void testPackageDefaultMessage(){
        Random random = new Random(47);
        List<Long> poiIds = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            poiIds.add(random.nextLong());
        }
        User user = User.builder()
                .id(1L)
                .username("markus")
                .company("meituan")
                .salary(2500D)
                .poiIds(poiIds)
                .build();

        String userJson = JSONObject.toJSONString(user);

        Message message = MessagePackager.packageDefaultMessage(user);
        String messageJson = JSONObject.toJSONString(message);

        System.out.println(userJson.length());
        System.out.println(messageJson.length());
        System.out.println(messageJson);
    }
}
