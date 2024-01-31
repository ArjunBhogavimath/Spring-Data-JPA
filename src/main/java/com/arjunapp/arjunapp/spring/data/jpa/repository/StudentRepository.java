package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //the naming of the method should append with proper property nane with operation(findBy)
    //and make the first letter upperCase for the property name (firstName --> FirstName)
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByFirstNameContaining(String name); //this will check if the word is present in nam// e
}

