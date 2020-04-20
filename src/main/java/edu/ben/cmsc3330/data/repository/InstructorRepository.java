package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
