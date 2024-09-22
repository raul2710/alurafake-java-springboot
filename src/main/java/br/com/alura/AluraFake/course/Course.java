package br.com.alura.AluraFake.course;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;


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
    private LocalDateTime inactiveDateTime = null;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Course() {
    }

    public Course(String title, String code, String instructor, String emailInstructor, String description, int hoursToComplete, Status status) {
        this.title = title;
        this.code = code;
        this.instructor = instructor;
        this.emailInstructor = emailInstructor;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
        this.status = status;
    }

    public void updateStatus(String status) {
        if (this.status == Status.ACTIVE) {
            this.status = Status.INACTIVE;
            this.inactiveDateTime = LocalDateTime.now();
        }
        else {
            this.status = Status.ACTIVE;
        }
    }
}
