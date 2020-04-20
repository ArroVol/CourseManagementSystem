package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long > {

    Page<Course> findByCourseId(String id, Pageable pageable);

    Page<Course> findByCourseNameContainingOrderByCourseName(String id, Pageable pageable);

    Page<Course> findByCourseSubject(String id, Pageable pageable);


}
