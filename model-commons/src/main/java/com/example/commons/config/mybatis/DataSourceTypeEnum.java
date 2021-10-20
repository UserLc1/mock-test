package com.example.commons.config.mybatis;

/**
 * @Author: Lc
 * @Date: 2021-07-29
 */
public enum DataSourceTypeEnum {
    /**
     * 数据源
     */
    PRIMARY("PRIMARY"),
    ZBSYS("ZBSYS");

    private String value;

    DataSourceTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
