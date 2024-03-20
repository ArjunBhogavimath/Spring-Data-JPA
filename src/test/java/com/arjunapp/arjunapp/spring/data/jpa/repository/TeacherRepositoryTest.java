package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Course;
import com.arjunapp.arjunapp.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseAlgo = Course.builder()
                .title("Algorithms")
                .credit(10)
                .build();
        Course courseDB = Course.builder()
                .title("DBMS")
                .credit(15)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Rekha")
                .lastName("Nataraj")
               // .course(List.of(courseAlgo, courseDB))
                .build();

        teacherRepository.save(teacher);
    }
}