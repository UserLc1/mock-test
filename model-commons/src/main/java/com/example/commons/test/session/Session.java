package com.example.commons.test.session;

import lombok.Data;

/**
 * @Author: Lc
 * @Date: 2020-09-15
 */
@Data
public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }


    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}
