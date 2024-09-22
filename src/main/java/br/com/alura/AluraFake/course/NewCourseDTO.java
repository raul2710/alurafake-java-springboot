package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import static br.com.alura.AluraFake.course.Status.ACTIVE;

public class NewCourseDTO {

    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    @Length(min = 4, max = 10)
    private String code;
    @NotNull
//    @Length(min = 1, max = 40)
    private int hoursToComplete;
    @NotNull
    @NotBlank
    @Email
    private String emailInstructor;
    @NotBlank
    private String description;
    @NotBlank
    private String instructor;

    @Deprecated
    public NewCourseDTO() {}

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public int getHoursToComplete() {
        return hoursToComplete;
    }

    public String getEmailInstructor() {
        return emailInstructor;
    }

    public String getDescription() { return description; }

    public String getInstructor() { return instructor; }

    public Course toModel() {
            return new Course(title, code, instructor, emailInstructor, description, hoursToComplete, ACTIVE);
    }
}
