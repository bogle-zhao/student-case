package com.example.scase.controller;

import com.example.scase.StudentCaseApplication;
import com.example.scase.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentCaseApplication.class)
public class StudentControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_create() {

        Random random = new Random(100);
        Student student = new Student();
        student.setName("name_" + random.nextInt());
        byte b = 0;
        student.setSex(b);
        student.setAge(random.nextInt());
        student.setNum("num_" + random.nextInt());
        String content = null;
        try {
            content = objectMapper.writeValueAsString(student);
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/student/save")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(200)))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void should_create_repeat_num() {

        Random random = new Random(100);
        Student student = new Student();
        student.setName("name_" + random.nextInt());
        byte b = 0;
        student.setSex(b);
        student.setAge(random.nextInt());
        student.setNum("num_" + random.nextInt());
        String content = null;
        try {
            content = objectMapper.writeValueAsString(student);
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/student/save")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(200)))
                    .andDo(MockMvcResultHandlers.print());

            mockMvc.perform(MockMvcRequestBuilders
                            .post("/student/save")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(403)))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 500 error
     */
    @Test
    public void should_create_when_num_is_null() {
        Random random = new Random(100);
        Student student = new Student();
        student.setName("name_" + random.nextInt());
        byte b = 0;
        student.setSex(b);
        student.setAge(random.nextInt());
        String content = null;
        try {
            content = objectMapper.writeValueAsString(student);
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/student/save")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(500)))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void query() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/student/1")
                            .accept(MediaType.APPLICATION_JSON_VALUE)

                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void show_update_when_not_exist() {
        Random random = new Random(100);
        Student student = new Student();
        student.setName("name_" + random.nextInt());
        byte b = 0;
        student.setSex(b);
        student.setAge(random.nextInt());
        student.setNum("num_" + random.nextInt());
        String content = null;
        try {
            content = objectMapper.writeValueAsString(student);
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/student/1")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(404)))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void show_update_when_exist() {
        Random random = new Random(100);
        Student student = new Student();
        student.setName("name_" + random.nextInt());
        byte b = 0;
        student.setSex(b);
        student.setAge(random.nextInt());
        student.setNum("num_" + random.nextInt());
        String content = null;
        try {
            content = objectMapper.writeValueAsString(student);
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/student/save")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(200)))
                    .andDo(MockMvcResultHandlers.print());

            mockMvc.perform(MockMvcRequestBuilders
                            .put("/student/1")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(200)))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void show_testDelete_when_data_not_exist() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/student/1")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(404)))
                    .andDo(MockMvcResultHandlers.print());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void show_testDelete_when_data_exist() {
        try {
            this.should_create();
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/student/1")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                    )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(jsonPath("$.code", Is.is(200)))
                    .andDo(MockMvcResultHandlers.print());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}