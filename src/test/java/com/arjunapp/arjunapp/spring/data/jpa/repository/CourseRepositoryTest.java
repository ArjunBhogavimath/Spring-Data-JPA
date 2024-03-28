package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Course;
import com.arjunapp.arjunapp.spring.data.jpa.entity.Student;
import com.arjunapp.arjunapp.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = (Pageable) PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll();
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("STRIVER")
                .lastName("TUF")
                .build();
        Course course = Course.builder()
                .title("SDE")
                .credit(100)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("Samanvi")
                .lastName("tha")
                .emailId("samanvitha@gamil.com")
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

//    @Test
//    public void saveCourseWithStudentAndTeacher(){
//        Teacher teacher = Teacher.builder()
//                .firstName("Rekha")
//                .lastName("R")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("Mallik")
//                .lastName("Arjun")
//                .emailId("Arjun@gmail.com")
//                .build();
//        Course course = Course.builder()
//                .title("ML")
//                .credit(10)
//                .teacher(teacher)
//                .build();
//
//        course.addStudents(student);
//        courseRepository.save(course);
//    }
}