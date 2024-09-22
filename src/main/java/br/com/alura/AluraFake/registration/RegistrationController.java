package br.com.alura.AluraFake.registration;

import br.com.alura.AluraFake.course.Course;
import br.com.alura.AluraFake.course.CourseRepository;
import br.com.alura.AluraFake.course.Status;
import br.com.alura.AluraFake.user.User;
import br.com.alura.AluraFake.user.UserRepository;
import br.com.alura.AluraFake.util.ErrorItemDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class RegistrationController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping("/registration/new")
    public ResponseEntity createCourse(@Valid @RequestBody NewRegistrationDTO newRegistration) {
        //Questão 3 aqui
        User user = userRepository.getReferenceByEmail(newRegistration.getStudentEmail());
        Course course = courseRepository.getReferenceByCode(newRegistration.getCourseCode());

        if(course==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorItemDTO("courseCode", "Código de curso não encontrado no sistema"));

        user.getCourses().add(course);
        course.getUsers().add(user);

        userRepository.save(user);
        courseRepository.save(course);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/registration/report")
    public ResponseEntity<List<RegistrationReportItem>> report() {
        List<RegistrationReportItem> items = new ArrayList<>();

        //Questão 4 aqui


        //Dados fakes que devem ser rescrevidos
        items.add(new RegistrationReportItem(
                "Java para iniciantes",
                "java",
                "Caio Bugorin",
                "caio.bugorin@alura.com.br",
                10L
                )
        );

        items.add(new RegistrationReportItem(
                        "Spring para iniciantes",
                        "spring",
                        "Caio Bugorin",
                        "caio.bugorin@alura.com.br",
                        9L
                )
        );

        items.add(new RegistrationReportItem(
                        "Maven para avançados",
                        "mavem",
                        "Caio Bugorin",
                        "caio.bugorin@alura.com.br",
                        9L
                )
        );

        return ResponseEntity.ok(items);
    }


}
