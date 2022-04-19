package com.example.scase.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -5279424092571572799L;

    /**
     * id 主键
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 学号
     */
    private String num;
}
