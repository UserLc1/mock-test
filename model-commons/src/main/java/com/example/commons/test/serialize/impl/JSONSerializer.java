package com.example.commons.test.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.example.commons.test.serialize.Serializer;
import com.example.commons.test.serialize.SerializerAlgorithm;

/**
 * @Author: Lc
 * @Date: 2020-09-07
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
