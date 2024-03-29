package com.example.commons.util;

import com.example.commons.enums.LogEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地日志参考类
 * @author ljy
 *
 */
public class LogUtils {

    /**
     * 获取业务日志logger
     *
     * @return
     */
    public static Logger getBusinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSINESS.getCategory());
    }

    /**
     * 获取平台日志logger
     *
     * @return
     */
    public static Logger getPlatformLogger() {
        return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
    }

    /**
     * 获取数据库日志logger
     *
     * @return
     */
    public static Logger getDbLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }


    /**
     * 获取异常日志logger
     *
     * @return
     */
    public static Logger getExceptionLogger() {
        return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
    }

    public static void main(String[] args) {

    }
}
