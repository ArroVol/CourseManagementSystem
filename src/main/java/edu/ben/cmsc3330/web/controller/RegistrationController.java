package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.model.Registration;
import edu.ben.cmsc3330.data.model.Section;
import edu.ben.cmsc3330.data.repository.CourseRepository;
import edu.ben.cmsc3330.data.repository.RegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

/**
 * Controller for Registration
 */
@Slf4j
@RestController
public class RegistrationController {
    /**
     * Repository for Registration
     */
    private final RegistrationRepository registrationRepository;
    /**
     * Repository for Courses
     */
    private final CourseRepository courseRepository;

    /**
     * Registration Controller Builder
     * @param registrationRepository Registration Repository
     * @param courseRepository Course Repository
     */
    public RegistrationController(RegistrationRepository registrationRepository, CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.courseRepository = courseRepository;
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

//    @PostMapping(value = "/api/registration/register")
//    public Registration save(@RequestBody Section section, BindingResult bindingResult) {
//        log.info("inside the postmapping of add registration");
//        if (bindingResult.hasErrors()) {
//            throw new ValidationException();
//        }
//          Optional<Course> course = courseRepository.findByCourseId(section.getCourseId());
//        Registration newRegistration = new Registration();
////        newRegistration.setRegistrationId();
//        newRegistration.setStudentId(1);
//        newRegistration.setSectionNo(section.getSectionNo());
//        newRegistration.setSemester(section.getSemester());
//        newRegistration.setCourseName(RegistrationTranslator.entityToView(registrationOption.get());
//        newRegistration.setDateOfRegistration(registrationView.getDateOfRegistration());
//        newRegistration.setDateOfCompletion(registrationView.getDateOfCompletion());
//        log.info(registrationView.getCourseName() + " :Course Name");
//        log.info(registrationView.getDateOfRegistration() + " : registration Id");
//        log.info(registrationView.getSectionNo() + " :sectionNo");
//
//        // save note instance to db
////        this.registrationRepository.save(newRegistration);
//        this.registrationRepository.save(registrationView);
//        log.info("saved the registration object");
////        return newRegistration;
//        return registrationView;
//    }

    // delete user by id
    @DeleteMapping(value = "/api/registration/delete/{registrationId}")
//    public ResponseEntity<Registration> deleteRegistration(@PathVariable("registrationId") int registrationId) {
         public void deleteRegistration(@PathVariable("registrationId") int registrationId) {

        log.info("inside the delete mapping backend");
        Registration existingRegistration = this.registrationRepository.findByRegistrationId(registrationId);
        this.registrationRepository.delete(existingRegistration);
        List<Registration> listOfClasses = this.registrationRepository.findAll();
//        return ResponseEntity.ok().build();
//        return listOfClasses;
    }
//
//    // delete user by id
//    @RequestMapping(value = "/api/registration/test")
//    public ResponseEntity<Registration> deleteUserTest()  {
//        log.info("inside the delete mapping backend");
////        Registration existingRegistration = this.registrationRepository.findByRegistrationId(registrationId);
////        this.registrationRepository.delete(existingRegistration);
//        return ResponseEntity.ok().build();
//    }

}
