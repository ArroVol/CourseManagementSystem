package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.User;
import edu.ben.cmsc3330.data.repository.UserRepository;
import edu.ben.cmsc3330.data.translator.UserTranslator;
import edu.ben.cmsc3330.web.model.UserView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controller for Users
 */
@Slf4j
@RestController
public class UserController {

    /**
     * User Repository
     */
    private final UserRepository userRepository;

    /**
     * User Controller Builder
     * @param userRepository
     */
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //http://localhost:8080/api/user/1
    @GetMapping(value = "/api/user/{userId}")
    public UserView viewUserById(@PathVariable int userId) throws Exception {
        log.info("inside the view user by id method");
        // Retrieve the User object
        Optional<User> userOption = userRepository.findByUserId(userId);

        // Verify we actually got a good user/user id
        if (userOption.isEmpty()) {
            log.error("User with id [{}] does not exist in DB", userId);
            throw new Exception("User with id [" + userId + "] does not exist in DB");
        }
        return UserTranslator.entityToView(userOption.get());
    }

    //Get User
    @GetMapping(value = "/api/user/retrieve/{email}/{password}")
    public UserView getUser(@PathVariable String email, @PathVariable String password) throws Exception {
        log.info("inside the get user by email and password");
        log.info(email);
        log.info(password);

        // Retrieve the User object
        Optional<User> userOption = userRepository.findByEmailAndPassword(email, password);
        log.info(userOption.toString());


        // Verify we actually got a good user/user id
        if (userOption.isEmpty()) {
            log.error("User with email [{}] does not exist in DB", email, password);
            throw new Exception("User with email [" + email + "and password: " + password +"] does not exist in DB sorry");
        }
        return UserTranslator.entityToView(userOption.get());
    }

    //Get User by Email
    @GetMapping(value = "/api/user/retrieve/{email}")
    public UserView getUserByEmail(@PathVariable String email) throws Exception {
        log.info("inside view user method");
        // Retrieve the User object
        Optional<User> userOption = userRepository.findByEmail(email);

        // Verify we actually got a good user/user id
        if (userOption.isEmpty()) {
            log.error("User with email [{}] does not exist in DB", email);
            throw new Exception("User with id [" + email + "] does not exist in DB sorry");
        }
        return UserTranslator.entityToView(userOption.get());
    }

    // get all users
    @GetMapping(value = "/api/user")
    public List<User> viewAllUsers() {
        log.info("inside the get all users in the user controller ");
        return this.userRepository.findAll();
//                return UserTranslator.entityToView(userRepository.findAll());
    }

//    // get all users by subject
//    @GetMapping(value = "/api/user/subject/{userSubject}")
//    public List<User> getUsersBySubject(@PathVariable String userSubject) throws Exception {
//        log.info("inside the get lal users in the user controller: " + userSubject);
//        return this.userRepository.findByUserSubjectContainingOrderByUserSubject(userSubject);
//    }
//
//    // get all users by name
//    @GetMapping(value = "/api/user/name/{userName}")
//    public List<User> getUsersByName(@PathVariable String userName) throws Exception {
//        log.info("inside the get lal users in the user controller: " + userName);
//        return this.userRepository.findByUserSubjectContainingOrderByUserSubject(userName);
//    }
}
