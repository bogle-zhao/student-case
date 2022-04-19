package com.example.scase.mapper;

import com.example.scase.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    int save(@Param("student") Student student);

    Student get(@Param("id") Long id);

    int update(@Param("student") Student student);

    int delete(@Param("id") Long id);
}
