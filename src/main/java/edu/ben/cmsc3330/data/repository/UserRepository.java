package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.User;
import edu.ben.cmsc3330.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Users
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find User by UserID
     * @param userId User ID
     * @return User
     */
    Optional<User> findByUserId(int userId);

    Optional<User> findByStudentId(int studentId);

    /**
     * Find User by Email
     * @param email User Email
     * @return User
     */
    Optional<User> findByEmail(String email);

    /**
     * Find User by Email and Password
     * @param email User Email
     * @param password User Password
     * @return User
     */
    Optional<User> findByEmailAndPassword(String email, String password);





}
