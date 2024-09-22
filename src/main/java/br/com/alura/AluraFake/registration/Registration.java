package br.com.alura.AluraFake.registration;

import jakarta.persistence.*;

@Table(name = "registration")
@Entity(name = "Registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coursecode;
    private String studentEmail;

    public Registration() {
    }

    public Registration(String coursecode, String studentEmail) {
        this.coursecode = coursecode;
        this.studentEmail = studentEmail;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
