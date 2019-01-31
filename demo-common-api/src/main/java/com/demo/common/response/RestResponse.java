package com.demo.common.response;

import lombok.Data;

@Data
public class RestResponse<T> {

    private int code;
    private T data;
    private String msg;
    private int count;

    public RestResponse() {
        super();
    }

    public RestResponse(int code, T data, String msg, int count) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.count = count;
    }
}
