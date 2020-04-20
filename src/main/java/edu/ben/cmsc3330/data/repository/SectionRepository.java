package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {

    Page<Section> findByCourseId(String id, Pageable pageable);

    Page<Section> findBySectionNo(String id, Pageable pageable);

    Page<Section> findBySemester(String id, Pageable pageable);
}
