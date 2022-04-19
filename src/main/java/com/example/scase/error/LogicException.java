package com.example.scase.error;

import lombok.Getter;

@Getter
public class LogicException extends RuntimeException{

    private int code;
    private String msg;


    public LogicException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public static LogicException build(int code, String msg) {
        return new LogicException(code, msg);
    }
}
