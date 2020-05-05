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
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public List<Registration> viewAllRegistrations() throws Exception {
        List<Registration> allRegistrations = registrationRepository.findAll();
        if(allRegistrations == null){
          throw new Exception("There are no registrations");
        }
        return allRegistrations;
    }

    // get all registrations by student id
    @GetMapping(value = "/api/registration/{studentId}")
    public List<Registration> getRegistrationsByStudent(@PathVariable int studentId) throws Exception {
        List<Registration> registrationOption = registrationRepository.findByStudentId(studentId);

        // Verify we actually got a good registration/registration id
        if (registrationOption.isEmpty()) {
            log.error("Registration with id [{}] does not exist in DB", studentId);
            throw new Exception("There are no registration for [" + studentId + "] in the DB");
        }
        return registrationOption;
    }

    @PostMapping(value = "/api/registration/register/{studentId}")
    public Registration save(@RequestBody Section section, BindingResult bindingResult, @PathVariable int studentId) {
        log.info("inside the postmapping of add registration, studentId; " + studentId);
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
          Optional<Course> course = courseRepository.findByCourseId(section.getCourseId());

        Registration check = registrationRepository.findBySectionNoAndStudentId(section.getSectionNo(), studentId);
        if(check != null){
            return null;
        }
        Registration newRegistration = new Registration();
        newRegistration.setStudentId(studentId);
        newRegistration.setSectionNo(section.getSectionNo());
        newRegistration.setSemester(section.getSemester());
        newRegistration.setCourseName(section.getCourseName());

        // save note instance to db
        this.registrationRepository.save(newRegistration);
        return newRegistration;
    }

    // delete user by id
    @DeleteMapping(value = "/api/registration/delete/{registrationId}")
         public void deleteRegistration(@PathVariable("registrationId") int registrationId) {

        Registration existingRegistration = this.registrationRepository.findByRegistrationId(registrationId);
        if(existingRegistration == null){

        }
        this.registrationRepository.delete(existingRegistration);
        List<Registration> listOfClasses = this.registrationRepository.findAll();
    }

}
