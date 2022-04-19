package com.example.scase.controller;

import com.example.scase.controller.res.ResCode;
import com.example.scase.controller.res.Response;
import com.example.scase.entity.Student;
import com.example.scase.error.LogicException;
import com.example.scase.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping(value = "/save")
    public Response<Student> create(@RequestBody Student student) {
        int count = studentMapper.save(student);
        if (count > 0) {
            return Response.SUCCESS(student);
        }
        throw LogicException.build(ResCode.SERVER_ERROR.getCode(), ResCode.SERVER_ERROR.getMsg());
    }

    @GetMapping(value = "/{id}")
    public Response<Student> query(@PathVariable("id") Long id) {
        Student student = studentMapper.get(id);
        return Response.SUCCESS(student);
    }

    @PutMapping(value = "/{id}")
    public Response<Student> update(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        int count = studentMapper.update(student);
        if (count > 0) {
            return Response.SUCCESS(studentMapper.get(id));
        }
        throw LogicException.build(ResCode.DATA_NOT_FOUND.getCode(), ResCode.DATA_NOT_FOUND.getMsg());
    }

    @DeleteMapping(value = "/{id}")
    public Response<Student> update(@PathVariable("id") Long id) {
        int count = studentMapper.delete(id);
        if (count > 0) {
            return Response.SUCCESS(true);
        }
        throw LogicException.build(ResCode.DATA_NOT_FOUND.getCode(), ResCode.DATA_NOT_FOUND.getMsg());
    }
}
