package com.demo.common.response;


public class RestResponseFactory {

    private static final int STATUS_OK = 200;

    public static <T> RestResponse<T> ok(T data, String message, int count) {
        return new RestResponse<T>(STATUS_OK, data, message, count);
    }

    public static <T> RestResponse<T> ok(T data, int count) {
        return ok(data, "处理成功", count);
    }

    public static <T> RestResponse<T> ok(T data) {
        return ok(data, "处理成功", 0);
    }
}
