package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.User;
import edu.ben.cmsc3330.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(int userId);

    Optional<User> findByStudentId(int studentId);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);





}
