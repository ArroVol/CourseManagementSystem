package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Page<Registration> findByCourseName(String id, Pageable pageable);

    Page<Registration> findByStudentId(String id, Pageable pageable);

    Page<Registration> findBySemester(String id, Pageable pageable);
}
