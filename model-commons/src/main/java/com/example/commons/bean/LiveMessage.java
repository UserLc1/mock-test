package com.example.commons.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Lc
 * @Date: 2020-06-18
 */
@Data
public class LiveMessage {
    private String userName;

    private String method;

    private Date date;

    private String content;

    private Integer length;

    class test  implements Lambda{
        @Override
        public String test(String text) {
            return text;
        }
    }

    public static String test2 (Lambda lambda){
        return lambda.test("123");
    }

}
