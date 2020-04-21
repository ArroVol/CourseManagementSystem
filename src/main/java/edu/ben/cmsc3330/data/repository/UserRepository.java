package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
