package com.example.scase.controller;

import com.example.scase.controller.res.ResCode;
import com.example.scase.controller.res.Response;
import com.example.scase.error.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("系统错误:{}", e.getMessage(), e);
        return Response.ERROR(ResCode.SERVER_ERROR.getCode(), ResCode.SERVER_ERROR.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(LogicException.class)
    public Response handleException(LogicException e) {
        log.error("业务错误:{}", e.getMessage(), e);
        return Response.ERROR(e.getCode(), e.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(DuplicateKeyException.class)
    public Response handleException(DuplicateKeyException e) {
        log.error("客户端错误:{}", e.getMessage(), e);
        return Response.ERROR(ResCode.DATA_EXISTS.getCode(), ResCode.DATA_EXISTS.getMsg());
    }
}
