package com.example.scase.controller.res;

import lombok.Getter;

@Getter
public enum ResCode {
    DATA_NOT_FOUND(404, "数据不存在"),
    SERVER_ERROR(500, "服务器错误")
    ;


    private int code;
    private String msg;

    ResCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
