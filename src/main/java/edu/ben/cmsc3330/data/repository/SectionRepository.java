package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Sections
 */
public interface SectionRepository extends JpaRepository<Section, Long> {

    Page<Section> findByCourseId(String id, Pageable pageable);

    Page<Section> findBySectionNo(String id, Pageable pageable);

    /**
     * Method to find Section by Section Number
     * @param sectionNo Section Number
     * @return Section
     */
    Optional<Section> findBySectionNo(int sectionNo);

    /**
     * Method to find Section by Semester ordered by Semester
     * @param semester Semester
     * @return Section
     */
    List<Section> findBySemesterContainingOrderBySemester(String semester);

    List<Section>findByCourseSubject(String courseSubject);




}
