package com.arjunapp.arjunapp.spring.data.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//to let the db know this class is used to create and map table we need to annotate with @entity
@Entity //whaterver we do in this particular class that will be reflected in DB
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    //create student properties which will reflect as columns of student table
    @Id //this will make studentId as primary key
    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;

    //The student table is linked with guardian table so add guardian properties as well
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
