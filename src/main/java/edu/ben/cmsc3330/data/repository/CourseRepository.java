package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Courses
 */
public interface CourseRepository extends JpaRepository<Course, Long > {

    Page<Course> findByCourseId(String id, Pageable pageable);

    Page<Course> findByCourseNameContainingOrderByCourseName(String id, Pageable pageable);

//    Page<Course> findByCourseSubject(String id, Pageable pageable);

    /**
     * Method to find Course Subject in order
     * @param id CourseID
     * @return Course
     */
    List<Course> findByCourseSubjectContainingOrderByCourseSubject(String id);

    /**
     * Method to find course by CourseUD
     * @param id Course
     * @return Course
     */
    Optional<Course> findByCourseId(int id);


}
