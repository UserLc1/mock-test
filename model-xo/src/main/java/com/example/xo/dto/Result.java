package com.example.xo.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据定义
 * @author Cxc
 */
public class Result extends HashMap<String,Object> {
    /**
     * 成功编码
     */
    private static final int SUCCESS_CODE = 0;
    /**
     * 失败编码
     *
     */
    private static final int ERROR_CODE = 1;

    private static Map<String, Object> map = new HashMap<>(0);

    public Result() {
        put("returnCode", SUCCESS_CODE);
        put("returnMsg","操作成功！");
    }

    public static Result error() {
        return error(ERROR_CODE, "系统异常，请联系管理员").put("result", Result.map);
    }

    public static Result error(String msg) {
        return error(ERROR_CODE, msg).put("result", Result.map);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("returnCode", code);
        result.put("returnMsg", msg);
        result.put("result", Result.map);
        return result;
    }

    public static Result error(int code, String msg, Object obj) {
        Result result = new Result();
        result.put("returnCode", code);
        result.put("returnMsg", msg);
        result.put("result", obj);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.put("returnMsg", msg);
        result.put("result", Result.map);
        return result;
    }

    public static Result success(String msg, Object object) {
        Result result = new Result();
        result.put("returnMsg", msg);
        result.put("result", object);
        return result;
    }

    public static Result success(Map<String, Object> map) {
        Result result = new Result();
        result.put("result", map);
        return result;
    }

    public static Result success(Object obj) {
        Result result = new Result();
        result.put("result", obj);
        return result;
    }

    public static Result success() {
        return new Result().put("result", Result.map);
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Result putMap(Map<String, Object> map) {
        super.putAll(map);
        return this;
    }

    /**
     * 获取当前返回的code值
     */
    public Integer getCode() {
        return Integer.valueOf(this.get("returnCode").toString());
    }
}
