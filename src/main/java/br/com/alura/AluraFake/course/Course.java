package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "courses")
    private Set<User> users = new HashSet<>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getEmailInstructor() {
        return emailInstructor;
    }

    public void setEmailInstructor(String emailInstructor) {
        this.emailInstructor = emailInstructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHoursToComplete() {
        return hoursToComplete;
    }

    public void setHoursToComplete(int hoursToComplete) {
        this.hoursToComplete = hoursToComplete;
    }

    public LocalDateTime getInactiveDateTime() {
        return inactiveDateTime;
    }

    public void setInactiveDateTime(LocalDateTime inactiveDateTime) {
        this.inactiveDateTime = inactiveDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
