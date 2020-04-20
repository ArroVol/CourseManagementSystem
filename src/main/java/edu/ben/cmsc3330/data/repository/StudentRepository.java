package edu.ben.cmsc3330.data.repository;


import edu.ben.cmsc3330.data.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findByActiveIsTrue(Pageable pageable);

    Page<Student> findByIdContainingOrderById(Long id, Pageable pageable);


}
