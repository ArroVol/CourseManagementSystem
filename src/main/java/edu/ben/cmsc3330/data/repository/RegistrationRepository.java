package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Registration Repository
 */
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Page<Registration> findByCourseName(String id, Pageable pageable);

    /**
     * Find Registration by Student ID
     * @param id Student ID
     * @return Registration Object
     */
    List<Registration> findByStudentId(int id);

    /**
     * Find Registration by Registration ID
     * @param registrationId Registration ID
     * @return Registration Object
     */
   Registration findByRegistrationId(int registrationId);

    Page<Registration> findBySemester(String id, Pageable pageable);
}
