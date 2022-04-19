package com.example.scase.controller.res;

import lombok.Data;

@Data
public class Response<R> {

    /**
     * 200: 成功
     * 4xx: 客户端业务错误
     * 5xx: 服务器错误
     */
    private int code;
    private String msg;
    private R content;


    public Response(int code, R r) {
        this.code = code;
        this.content = r;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Response SUCCESS(Object content) {
        return new Response<>(200, content);
    }

    public static Response ERROR(int code,String msg) {
        return new Response<>(code, msg);
    }
}
