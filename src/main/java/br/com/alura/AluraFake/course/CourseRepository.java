package br.com.alura.AluraFake.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByCode(String code);

    @Query("SELECT c.status FROM Course c WHERE c.code = :courseCode")
    Status isActive(String courseCode);
}
