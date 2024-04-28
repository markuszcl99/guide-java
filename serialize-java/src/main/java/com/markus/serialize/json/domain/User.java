package com.markus.serialize.json.domain;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @author: markus
 * @date: 2024/4/28 11:02 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class User {
    @JSONField(serializeFeatures = JSONWriter.Feature.FieldBased)
    private String username;
    @JSONField(serializeFeatures = JSONWriter.Feature.FieldBased)
    private boolean isTrue;

    @JSONField(serializeFeatures = JSONWriter.Feature.FieldBased)
    private String alias;

//    public String getUsername() {
//        return username;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public boolean isTrue() {
//        return isTrue;
//    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

//    public String getAlias() {
//        return alias;
//    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
