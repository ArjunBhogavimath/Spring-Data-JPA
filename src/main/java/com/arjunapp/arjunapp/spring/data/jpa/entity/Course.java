package com.arjunapp.arjunapp.spring.data.jpa.entity;

import ch.qos.logback.core.model.INamedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    //this course doesnt have relation with coursematerial only coursematerial has that
    @OneToOne(
            mappedBy = "course"
    ) //This shows onetoone mapping is already done in CourseMaterial class. so I'm just mentioning it here
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    ) //creating new table alled student_course_map
    //table will have 2 columns course id and student id
    private List<Student> students;

    //create a method to add students
    public void addStudents(Student student){
        if(student == null) students = new ArrayList<>(); //creating new array list if the student object is null
        students.add(student);
    }
}
