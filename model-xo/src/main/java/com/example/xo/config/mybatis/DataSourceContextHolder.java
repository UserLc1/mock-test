package com.example.xo.config.mybatis;

/**
 * @Author: Lc
 * @Date: 2021-07-29
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dbTypeEnum 枚举
     */
    public static void setDbType(DataSourceTypeEnum dbTypeEnum) {
        CONTEXT_HOLDER.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return 数据源对象
     */
    public static String getDbType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        CONTEXT_HOLDER.remove();
    }
}
