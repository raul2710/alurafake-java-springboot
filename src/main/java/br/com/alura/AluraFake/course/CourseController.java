package br.com.alura.AluraFake.course;

import br.com.alura.AluraFake.util.ErrorItemDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/course/new")
    @Transactional
    public ResponseEntity createCourse(@Valid @RequestBody NewCourseDTO newCourse) {
        // Questão 1 aqui

        if(courseRepository.existsByCode(newCourse.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorItemDTO("code", "Código já cadastrado no sistema"));
        }
        Course course = newCourse.toModel();
        courseRepository.save(course);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/course/{code}/inactive")
    @Transactional
    public ResponseEntity createCourse(@PathVariable("code") String courseCode) {
        // Questão 2 aqui
        Course courseToUpdate = courseRepository.getReferenceByCode(courseCode);

        courseToUpdate.updateStatus("INACTIVE");

        return ResponseEntity.ok().build();
    }

}
