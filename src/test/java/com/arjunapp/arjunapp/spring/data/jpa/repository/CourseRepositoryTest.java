package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Course;
import com.arjunapp.arjunapp.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("Printing all the courses -"+courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Amulya")
                .lastName("mam")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(12)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}