package br.com.alura.AluraFake.course;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.sql.Timestamp;

@Table(name = "Course")
@Entity(name = "Course")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;
    private String instructor;
    private String emailInstructor;
    private String description;
    private int hoursToComplete;
    private Timestamp inactiveDateTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Course() {
    }

    public Course(@Valid NewCourseDTO newCourse) {
        this.code = newCourse.getCode();
        this.title = newCourse.getTitle();
        this.emailInstructor = newCourse.getEmailInstructor();
        this.instructor = newCourse.getInstructor();
        this.description = newCourse.getDescription();
        this.hoursToComplete = newCourse.getHoursToComplete();
        this.status = Status.ACTIVE;
    }
}
