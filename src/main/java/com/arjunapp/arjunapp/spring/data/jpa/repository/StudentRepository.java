package com.arjunapp.arjunapp.spring.data.jpa.repository;

import com.arjunapp.arjunapp.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //the naming of the method should append with proper property nane with operation(findBy)
    //and make the first letter upperCase for the property name (firstName --> FirstName)
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByFirstNameContaining(String name); //this will check if the word is present in nam// e

    //JPQL QUERIES
    //JPQL queries are defined in seperate way rather than native SQL queries
    //This will defined based on class not based on attributes
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //NATIVE QUERIES
    @Query(
            value = "SELECT * FROM students_tbl s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(
            value = "SELECT * FROM students_tbl s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying //This will be used to modify the table
    @Transactional //after the particular operation completed The commit happens to DB
    @Query(
            value = "update students_tbl set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}

