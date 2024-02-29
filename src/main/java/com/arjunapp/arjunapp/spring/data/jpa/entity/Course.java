package com.arjunapp.arjunapp.spring.data.jpa.entity;

import ch.qos.logback.core.model.INamedModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
