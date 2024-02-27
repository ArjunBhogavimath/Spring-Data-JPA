package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Course;
import com.arjunapp.arjunapp.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

   @Autowired
    private CourseMaterialRepository repository;

   @Test
   public void saveCourseMaterial(){
       Course course = Course.builder()
               .title("DSA")
               .credit(5)
               .build();

       CourseMaterial courseMaterial = CourseMaterial.builder()
               .url("www.google.com")
               .course(course)
               .build();

       repository.save(courseMaterial);
   }

   @Test
   public void printAllCourseMaterials(){
       List<CourseMaterial> courseMaterials = repository.findAll();

       System.out.println("Course Materials =" + courseMaterials);
   }
}