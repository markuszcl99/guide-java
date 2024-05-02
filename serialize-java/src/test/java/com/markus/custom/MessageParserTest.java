package com.markus.custom;

import com.alibaba.fastjson.JSONObject;
import com.markus.custom.domain.User;
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
public class MessageParserTest {

    @Test
    public void testParserMessage() throws ClassNotFoundException {
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

        Message message = MessagePackager.packageDefaultMessage(user);
        String messageJson = JSONObject.toJSONString(message);

        // 发送消息 ...
        // 监听消息 ...
        message = JSONObject.parseObject(messageJson, Message.class);
        Object parsed = MessageParser.parseMessage(message);
        if (parsed instanceof User) {
            // 如果是 User 消息，走 User 消息的处理流程
            // 这里我们就打印一下
            System.out.println(parsed);
        } else {
            System.out.println("消息非 User 类型");
        }
    }
}
