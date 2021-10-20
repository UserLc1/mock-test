package com.example.commons.demo.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Lc
 * @Date: 2020-11-18
 */
@Data
public class TestBean implements Serializable {
    private String name;
    private String addr;
}
