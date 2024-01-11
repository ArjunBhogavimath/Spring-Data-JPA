package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Guardian;
import com.arjunapp.arjunapp.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //This one is used to store the tested data in DB
//@DataJpaTest //IT WILL HELP TO TEST REPOSITORY LAYER AND ONCE IT IS DONE IT WILL FLUSH THE DATA AND IT WONT BE SAVED IN DB
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        //we utilize builder pattern here as student class is declare by builder annotation
        Student student = Student.builder()
                .emailId("arjun@gmail.com")
                .firstName("arjun")
                .lastName("bm")
//                .guardianEmail("sujatha@gmail.com")
//                .guardianName("Sujatha")
//                .guardianMobile("9899991157")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("sujatha@gmail.com")
                .name("Sujatha")
                .mobile("9998889975")
                .build();

        Student student = Student.builder()
                .firstName("Mallik")
                .lastName("Arjun")
                .emailId("mallik.arjun@gmail.com")
                .guardian(guardian)
                .build();

        //need to save the object

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List ------->"+ studentList);
    }
}