package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Registration;
import edu.ben.cmsc3330.data.model.Registration;
import edu.ben.cmsc3330.data.model.Registration;
import edu.ben.cmsc3330.data.model.Registration;
import edu.ben.cmsc3330.data.repository.RegistrationRepository;
import edu.ben.cmsc3330.data.translator.RegistrationTranslator;
import edu.ben.cmsc3330.data.translator.RegistrationTranslator;
import edu.ben.cmsc3330.web.model.RegistrationView;
import edu.ben.cmsc3330.web.model.RegistrationView;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
public class RegistrationController {
    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

//    //http://localhost:8080/api/registration/1
//    @GetMapping(value = "/api/registration/{registrationId}")
//    public RegistrationView viewRegistrationById(@PathVariable int registrationId) throws Exception {
//        log.info("inside view registration method");
//        // Retrieve the Registration object
//        Optional<Registration> registrationOption = registrationRepository.findByRegistrationId(registrationId);
//
//        // Verify we actually got a good registration/registration id
//        if (registrationOption.isEmpty()) {
//            log.error("Registration with id [{}] does not exist in DB", registrationId);
//            throw new Exception("Registration with id [" + registrationId + "] does not exist in DB");
//        }
//        return RegistrationTranslator.entityToView(registrationOption.get());
//    }

    // get all registrations
    @GetMapping(value = "/api/registration")
    public List<Registration> viewAllRegistrations() {
        log.info("inside the get all users in the registration controller ");
        return this.registrationRepository.findAll();
    }

    // get all registrations by subject
    @GetMapping(value = "/api/registration/{studentId}")
    public List<Registration> getRegistrationsBySubject(@PathVariable int studentId) throws Exception {
        List<Registration> registrationOption = registrationRepository.findByStudentId(studentId);

        // Verify we actually got a good registration/registration id
        if (registrationOption.isEmpty()) {
            log.error("Registration with id [{}] does not exist in DB", studentId);
            throw new Exception("Registration with id [" + studentId + "] does not exist in DB");
        }
        return registrationOption;
    }
//
//    // get all registrations by name
//    @GetMapping(value = "/api/registration/name/{registrationName}")
//    public List<Registration> getRegistrationsByName(@PathVariable String registrationName) throws Exception {
//        log.info("inside the get lal users in the registration controller: " + registrationName);
//        return this.registrationRepository.findByRegistrationSubjectContainingOrderByRegistrationSubject(registrationName);
//    }

    @PostMapping(value = "/api/registration/register")
    public Registration save(@RequestBody RegistrationView registrationView, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Registration newRegistration = new Registration();
        newRegistration.setRegistrationId(registrationView.getRegistrationId());
        newRegistration.setStudentId(registrationView.getStudentId());
        newRegistration.setSectionNo(registrationView.getSectionNo());
        newRegistration.setSemester(registrationView.getSemester());
        newRegistration.setCourseName(registrationView.getCourseName());
        newRegistration.setDateOfRegistration(registrationView.getDateOfRegistration());
        newRegistration.setDateOfCompletion(registrationView.getDateOfCompletion());

        // save note instance to db
        this.registrationRepository.save(newRegistration);
        log.info("saved the registration object");
        return newRegistration;
    }

    // delete user by id
    @DeleteMapping(value = "/api/registration/delete/{registrationId}")
    public ResponseEntity<Registration> deleteUser(@PathVariable("registrationId") int registrationId) {
        Registration existingRegistration = this.registrationRepository.findByRegistrationId(registrationId);
        this.registrationRepository.delete(existingRegistration);
        return ResponseEntity.ok().build();
    }
}
