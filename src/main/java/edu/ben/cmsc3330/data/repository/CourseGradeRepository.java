package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.CourseGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseGradeRepository extends JpaRepository<CourseGrade, Long> {

}
