package com.arjunapp.arjunapp.spring.data.jpa.entity;

import jakarta.persistence.*;
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
@Table(
        name="students_tbl",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "email_address"
        )//only unique emails are allowed for email
) //this will create a new table with this name if not exists
public class Student {

    //create student properties which will reflect as columns of student table
    @Id //this will make studentId as primary key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    ) //how the sequence should be generated
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )//this will increment value whenever new student is added and based on the sequence the id is created
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address",
            nullable = false //this defines this should get the value, it shouldnt be null
    )//this is how to change the name of the column
    private String emailId;

    //The student table is linked with guardian table so add guardian properties as well
    //Commenting this because we create new class for guardian and embedded them to student table
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;

    @Embedded
    private Guardian guardian;
}
