package br.com.alura.AluraFake.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    boolean existsByCode(String code);
}
