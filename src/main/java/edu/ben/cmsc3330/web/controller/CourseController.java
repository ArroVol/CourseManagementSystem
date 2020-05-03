package edu.ben.cmsc3330.web.controller;
import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.data.repository.CourseRepository;
import edu.ben.cmsc3330.data.translator.CourseTranslator;
import edu.ben.cmsc3330.web.model.CourseView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //http://localhost:8080/api/course/1
    @GetMapping(value = "/api/course/{courseId}")
    public CourseView viewCourseById(@PathVariable int courseId) throws Exception {
        log.info("inside the get mapping for view course by Id");
        // Retrieve the Course object
        Optional<Course> courseOption = courseRepository.findByCourseId(courseId);

        // Verify we actually got a good course/course id
        if (courseOption.isEmpty()) {
            log.error("Course with id [{}] does not exist in DB", courseId);
            throw new Exception("Course with id [" + courseId + "] does not exist in DB");
        }
        return CourseTranslator.entityToView(courseOption.get());
    }

    // get all courses
    @GetMapping(value = "/api/course")
    public List<Course> viewAllCourses() {
        log.info("inside the get lal users in the course controller ");
        return this.courseRepository.findAll();
//                return CourseTranslator.entityToView(courseRepository.findAll());
    }

    // get all courses by subject
    @GetMapping(value = "/api/course/subject/{courseSubject}")
    public List<Course> getCoursesBySubject(@PathVariable String courseSubject) throws Exception {
        log.info("inside the get lal users in the course controller: " + courseSubject);
        return this.courseRepository.findByCourseSubjectContainingOrderByCourseSubject(courseSubject);
    }

    // get all courses by name
    @GetMapping(value = "/api/course/name/{courseName}")
    public List<Course> getCoursesByName(@PathVariable String courseName) throws Exception {
        log.info("inside the get lal users in the course controller: " + courseName);
        return this.courseRepository.findByCourseSubjectContainingOrderByCourseSubject(courseName);
    }
}
