package com.example.commons.test.serialize;


import com.example.commons.test.serialize.impl.JSONSerializer;

/**
 * @Author: Lc
 * @Date: 2020-09-07
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
