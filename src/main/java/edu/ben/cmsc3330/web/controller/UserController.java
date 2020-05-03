package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.User;
import edu.ben.cmsc3330.data.model.Section;
import edu.ben.cmsc3330.data.model.User;
import edu.ben.cmsc3330.data.repository.UserRepository;
import edu.ben.cmsc3330.data.translator.UserTranslator;
import edu.ben.cmsc3330.web.model.UserView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {

    private final UserRepository userRepository;

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

    @PostMapping(value = "/api/user/newUser")
    public User save(@RequestBody User user, BindingResult bindingResult) {
        log.info("inside the postmapping of add newUser!");
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        log.info(user.getFirstName());
        log.info(user.getEmail());
        log.info(String.valueOf(user.getStudentId()));

        Optional<User> check = userRepository.findByStudentId(user.getStudentId());

        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setStudentId(user.getStudentId());

        // save note instance to db
        this.userRepository.save(newUser);
        return newUser;
    }

//
//    // get all users by name
//    @GetMapping(value = "/api/user/name/{userName}")
//    public List<User> getUsersByName(@PathVariable String userName) throws Exception {
//        log.info("inside the get lal users in the user controller: " + userName);
//        return this.userRepository.findByUserSubjectContainingOrderByUserSubject(userName);
//    }
}
