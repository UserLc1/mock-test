package com.example.commons.test.attr;

import com.example.commons.test.session.Session;
import io.netty.util.AttributeKey;

/**
 * @Author: Lc
 * @Date: 2020-09-08
 */
public interface Attributes {
//    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
