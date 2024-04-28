package com.markus.serialize.json;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.markus.serialize.json.domain.User;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2024/4/28 11:01 PM
 * @Description: alibaba fastjson use demo
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class FastJsonDemo {
    @Test
    public void testFieldBased() {
        User user = new User();
        user.setUsername("zhangchenglong");
        user.setAlias("markus");
        user.setTrue(true);

        String userJson = JSONObject.toJSONString(user, JSONWriter.Feature.FieldBased);
        System.out.println(userJson);
    }
}
