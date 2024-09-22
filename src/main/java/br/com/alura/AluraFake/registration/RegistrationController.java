package br.com.alura.AluraFake.registration;

import br.com.alura.AluraFake.course.CourseRepository;
import br.com.alura.AluraFake.course.Status;
import br.com.alura.AluraFake.util.ErrorItemDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationRepository resgistrationRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/registration/new")
    @Transactional
    public ResponseEntity createCourse(@Valid @RequestBody NewRegistrationDTO newRegistration) {
        //Questão 3 aqui
        if (courseRepository.existsByCode(newRegistration.getCourseCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorItemDTO("sourseCode", "Código não encontrado no sistema"));
        }
        else if (courseRepository.isActive(newRegistration.getCourseCode()) == Status.INACTIVE){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorItemDTO("sourseCode", "Curso inativo no sistema"));
        }

//        registrationRepository.save(newRegistration.toModel());

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
